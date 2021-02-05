package com.base_android_template.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.base_android_template.BR

abstract class BaseFragment<VB : ViewDataBinding, VM : ViewModel>(@LayoutRes private val layoutResId: Int) :
    Fragment() {

    private var binding: VB? = null
    protected abstract val viewModel: VM?

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


    protected fun requireBinding(): VB =
        binding ?: throw NullPointerException("View is in destroyed state and the Binding is null")

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}