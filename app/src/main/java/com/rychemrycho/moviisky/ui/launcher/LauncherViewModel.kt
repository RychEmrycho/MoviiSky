package com.rychemrycho.moviisky.ui.launcher

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rychemrycho.moviisky.data.repository.AuthRepository
import com.rychemrycho.moviisky.data.repository.LauncherRepository
import com.rychemrycho.moviisky.data.repository.OnboardingRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LauncherViewModel @ViewModelInject constructor(
    private val launcherRepository: LauncherRepository,
    private val onboardingRepository: OnboardingRepository,
    private val authRepository: AuthRepository
) : ViewModel() {
    fun isOnboarded(): Boolean {
        var onboarded = false
        viewModelScope.launch {
            onboardingRepository.isOnboarded().collect {
                onboarded = it ?: false
            }
        }

        return onboarded
    }

    fun isLauncherSkipped(): Boolean {
        var launcherSkipped = false
        viewModelScope.launch {
            launcherRepository.isLauncherSkipped().collect {
                launcherSkipped = it ?: false
            }
        }

        return launcherSkipped
    }

    fun isAuthenticated(): Boolean {
        var authenticated = false
        viewModelScope.launch {
            authRepository.isAuthenticated().collect {
                authenticated = it ?: false
            }
        }

        return authenticated
    }

    fun hideLauncher(isSkipped: Boolean) {
        viewModelScope.launch {
            launcherRepository.setLauncherSkipped(isSkipped)
        }
    }
}
