package com.base_android_template.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.base_android_template.BR
import com.base_android_template.shared.model.NavigationCommand

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel>(@LayoutRes private val layoutResId: Int) :
    Fragment() {

    private var binding: VB? = null
    protected abstract val viewModel: VM

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
        }
    }

    protected fun requireBinding(): VB =
        binding ?: throw NullPointerException("View is in destroyed state and the Binding is null")

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}