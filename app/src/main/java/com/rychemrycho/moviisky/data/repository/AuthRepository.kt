package com.rychemrycho.moviisky.data.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun isAuthenticated(): Flow<Boolean?>
    suspend fun setAuthenticated(isAuthenticated: Boolean)
}
