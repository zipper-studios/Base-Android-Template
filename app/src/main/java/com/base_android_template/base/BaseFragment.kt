package com.base_android_template.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.base_android_template.BR
import com.base_android_template.shared.loading.UILoading
import com.base_android_template.shared.model.NavigationCommand
import org.koin.android.ext.android.inject

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel>(@LayoutRes private val layoutResId: Int) :
    Fragment() {

    private var binding: VB? = null
    protected abstract val viewModel: VM

    private val loadingDialog: UILoading by inject()

    private val loadingObserver: Observer<Boolean> = Observer { showLoading ->
        if (showLoading) {
            loadingDialog.show()
            return@Observer
        }

        loadingDialog.hide()
    }

    private val commandObserver = Observer<NavigationCommand?> { command ->
        if (command != null) {
            when (command) {
                is NavigationCommand.PerformNavUp -> {
                    findNavController().navigateUp()
                }
                is NavigationCommand.PerformNavAction -> {
                    findNavController().navigate(command.direction)
                }
            }
            viewModel.clearLastNavigationCommand()
        }
    }

    private val messageObserver = Observer<String> {
        (activity as? AppCompatActivity)?.apply {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                viewModel.clearLastMessage()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context?.let { loadingDialog.init(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<VB>(inflater, layoutResId, container, false).also {
            it.lifecycleOwner = viewLifecycleOwner
            it.setVariable(BR.viewModel, viewModel)
            binding = it
        }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.apply {
            navigationCommand.observe(viewLifecycleOwner, commandObserver)
            loading.observe(viewLifecycleOwner, loadingObserver)
            message.observe(viewLifecycleOwner, messageObserver)
        }
    }

    protected fun requireBinding(): VB =
        binding ?: throw NullPointerException("View is in destroyed state and the Binding is null")

    override fun onDestroyView() {
        super.onDestroyView()
        loadingDialog.cancel()
        binding = null
    }

}