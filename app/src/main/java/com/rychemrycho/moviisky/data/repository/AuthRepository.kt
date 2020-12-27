package com.rychemrycho.moviisky.data.repository

interface AuthRepository {
    fun isAuthenticated(): Boolean
    fun setAuthenticated(isAuthenticated: Boolean)
}
