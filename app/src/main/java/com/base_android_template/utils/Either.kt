package com.base_android_template.utils

/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Either] are either an instance of [Failure] or [Success].
 * FP Convention dictates that [Failure] is used for "failure"
 * and [Success] is used for "success".
 *
 * @see Failure
 * @see Success
 * @see <a href="https://github.com/android10/Android-CleanArchitecture-Kotlin">Credits to Fernando Cejas.</a>
 */
sealed class Either<out L, out R> {
    /** * Represents the left side of [Either] class which by convention is a "Exception". */
    data class Failure<out L>(val error: L) : Either<L, Nothing>()

    /** * Represents the right side of [Either] class which by convention is a "Success". */
    data class Success<out R>(val data: R) : Either<Nothing, R>()

    /**
     * Returns true if this is a Success, false otherwise.
     * @see Success
     */
    val isSuccess get() = this is Success<R>

    /**
     * Returns true if this is a Failure, false otherwise.
     * @see Failure
     */
    val isFailure get() = this is Failure<L>

    /**
     * Creates a Failure type.
     * @see Failure
     */
    fun <L> failure(a: L) = Failure(a)

    /**
     * Creates a Success type.
     * @see Success
     */
    fun <R> success(b: R) = Success(b)

    /**
     * Applies funFailure if this is a Failure or funSuccess if this is a Success.
     * @see Failure
     * @see Success
     */
    fun fold(funFailure: (L) -> Any, funSuccess: (R) -> Any): Any =
        when (this) {
            is Failure -> funFailure(error)
            is Success -> funSuccess(data)
        }
}

/**
 * Composes 2 functions
 * See <a href="https://proandroiddev.com/kotlins-nothing-type-946de7d464fb">Credits to Alex Hart.</a>
 */
fun <A, B, C> ((A) -> B).compose(function: (B) -> C): (A) -> C = {
    function(this(it))
}

/**
 * Success-biased flatMap() FP convention which means that Success is assumed to be the default case
 * to operate on. If it is Failure, operations like map, flatMap, ... return the Failure value unchanged.
 */
fun <T, L, R> Either<L, R>.flatMap(function: (R) -> Either<L, T>): Either<L, T> =
    when (this) {
        is Either.Failure -> Either.Failure(error)
        is Either.Success -> function(data)
    }

/**
 * Success-biased map() FP convention which means that Success is assumed to be the default case
 * to operate on. If it is Failure, operations like map, flatMap, ... return the Failure value unchanged.
 */
fun <T, L, R> Either<L, R>.map(function: (R) -> (T)): Either<L, T> =
    this.flatMap(function.compose(::success))

/** Returns the value from this `Success` or the given argument if this is a `Failure`.
 *  Right(12).getOrElse(17) RETURNS 12 and Left(12).getOrElse(17) RETURNS 17.
 *  Just for unit tests
 */
fun <L, R> Either<L, R>.getOrElse(value: R): R =
    when (this) {
        is Either.Failure -> value
        is Either.Success -> data
    }

/** Invokes function if Either is success.
 *  Returns itself.
 */
fun <L, R> Either<L, R>.doOnSuccess(block: (R) -> Any): Either<L, R> =
    when (this) {
        is Either.Failure -> Either.Failure(error)
        is Either.Success -> {
            block(data)
            Either.Success(data)
        }
    }