package com.base_android_template.usecase

import com.base_android_template.model.entity.GithubUserEntity
import com.base_android_template.persistance.dao.GithubUsersListDao
import com.base_android_template.repository.GithubUsersRepository
import com.base_android_template.shared.network.Exception
import com.base_android_template.utils.Either
import com.base_android_template.utils.doOnSuccess
import com.base_android_template.utils.map
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class GetGithubUsersUseCaseImpl internal constructor(
    private val githubUsersRepository: GithubUsersRepository,
    private val githubUsersListDao: GithubUsersListDao
) : GetGithubUsersUseCase {

    override suspend fun getRemoteAndSaveLocalGithubUsers(): Either<Exception, List<GithubUserEntity>> =
        coroutineScope {
            githubUsersRepository.getLocalGithubUsers()
                .map { githubUsersList ->
                    githubUsersList.map { GithubUserEntity.mapToGithubUserEntity(it) }
                }
                .doOnSuccess {
                    launch { updateLocalGithubUsersList(it) }
                }
        }

    override suspend fun getLocalGithubUsers(): Either<Exception, List<GithubUserEntity>> {
        val list = githubUsersListDao.getGithubUsers()

        return if (list?.isNullOrEmpty() == true)
            Either.Failure(Exception.EmptyLocalGithubUsersLisException)
        else Either.Success(list)
    }

    private suspend fun updateLocalGithubUsersList(list: List<GithubUserEntity>) {
        try {
            githubUsersListDao.insertGithubUsers(list)
        } catch (e: kotlin.Exception) {
            Either.Failure(Exception.SaveGithubUsersException)
        }
    }

}