package com.base_android_template.shared.model

import androidx.navigation.NavDirections

sealed class NavigationCommand {

    object PerformNavUp : NavigationCommand()

    data class PerformNavAction(val direction: NavDirections) : NavigationCommand()
}