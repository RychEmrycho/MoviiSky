package com.rychemrycho.moviisky.data.repository

interface LauncherRepository {
    fun isLauncherSkipped(): Boolean
    fun setLauncherSkipped(isLauncherSkipped: Boolean)
}
