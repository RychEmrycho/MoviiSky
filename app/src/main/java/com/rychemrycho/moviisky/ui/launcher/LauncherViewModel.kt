package com.rychemrycho.moviisky.ui.launcher

import androidx.lifecycle.ViewModel
import com.rychemrycho.moviisky.data.repository.AuthRepository
import com.rychemrycho.moviisky.data.repository.LauncherRepository
import com.rychemrycho.moviisky.data.repository.OnboardingRepository

class LauncherViewModel constructor(
    val launcherRepository: LauncherRepository,
    val onboardingRepository: OnboardingRepository,
    val authRepository: AuthRepository
) : ViewModel() {
    fun isOnboarded(): Boolean {
        TODO()
    }

    fun isLauncherSkipped(): Boolean {
        TODO()
    }

    fun isAuthenticated(): Boolean {
        TODO()
    }

    fun hideLauncher() {
        TODO()
    }
}
