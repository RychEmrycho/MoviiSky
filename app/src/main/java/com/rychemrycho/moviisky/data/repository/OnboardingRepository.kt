package com.rychemrycho.moviisky.data.repository

import kotlinx.coroutines.flow.Flow

interface OnboardingRepository {
    fun isOnboarded(): Flow<Boolean?>
    suspend fun setOnboarded(isOnboarded: Boolean)
}
