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

/**
 * Represents the base class that will be extended by any Fragment in the app.
 * It receives the corresponding ViewDataBinding and ViewModel generic types
 * and the id of the layout to be inflated
 *
 * @param layoutResId Int. The id of the layout that defines the structure
 * for the user interface of the fragment
 */
abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel>(@LayoutRes private val layoutResId: Int) :
    Fragment() {

    private var binding: VB? = null
    protected abstract val viewModel: VM
    private val loadingDialog: UILoading by inject()

    /**
     * Receives the value from loading LiveData variable inside BaseViewModel
     * and display the loading progress bar if value is true, and hide it otherwise
     */
    private val loadingObserver: Observer<Boolean> = Observer { showLoading ->
        if (showLoading) {
            loadingDialog.show()
            return@Observer
        }

        loadingDialog.hide()
    }

    /**
     * Receives the value from navigationCommand LiveData variable inside BaseViewModel
     * and, depending on NavigationCommand, proceed the navigation
     */
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
        }
    }

    /**
     * Receives the value from message LiveData variable inside BaseViewModel
     * and displays the messages in a Toast
     */
    private val messageObserver = Observer<String> {
        (activity as? AppCompatActivity)?.apply {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }

    /**
     * Receives the value from messageResId LiveData variable inside BaseViewModel
     * and get the corresponding string to the id and displays the messages in a Toast
     */
    private val messageResIdObserver = Observer<Int> {
        (activity as? AppCompatActivity)?.apply {
            if (it != -1) {
                if (getString(it) != "") {
                    Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context?.let { loadingDialog.init(it) }
    }

    /**
     * Using DataBindingUtil, inflate the layout by creating the corresponding ViewDataBinding
     * Set always used "viewModel" DataBinding variable
     */
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
            messageResId.observe(viewLifecycleOwner, messageResIdObserver)
        }
    }

    /**
     * Access the binding object from all subclasses
     */
    protected fun requireBinding(): VB =
        binding ?: throw NullPointerException("View is in destroyed state and the Binding is null")

    override fun onDestroyView() {
        super.onDestroyView()
        loadingDialog.cancel()
        binding = null
    }

}