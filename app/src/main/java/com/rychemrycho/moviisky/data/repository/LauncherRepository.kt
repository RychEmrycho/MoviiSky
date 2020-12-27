package com.rychemrycho.moviisky.data.repository

import kotlinx.coroutines.flow.Flow

interface LauncherRepository {
    fun isLauncherSkipped(): Flow<Boolean?>
    suspend fun setLauncherSkipped(isLauncherSkipped: Boolean)
}
