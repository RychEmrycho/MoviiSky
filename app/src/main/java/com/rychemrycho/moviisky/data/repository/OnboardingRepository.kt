package com.rychemrycho.moviisky.data.repository

interface OnboardingRepository {
    fun isOnboarded(): Boolean
    fun setOnboarded(isOnboarded: Boolean)
}
