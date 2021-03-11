package com.base_android_template.feature.settings

import android.os.Bundle
import com.base_android_template.R
import com.base_android_template.base.BaseFragment
import com.base_android_template.databinding.FragmentSettingsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment :
    BaseFragment<FragmentSettingsBinding, SettingsViewModel>(R.layout.fragment_settings) {

    override val viewModel: SettingsViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.recreateActivity.observe(viewLifecycleOwner, {
            if (it) {
                activity?.recreate()
            }
        })
    }

}