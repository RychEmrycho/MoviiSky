package com.rychemrycho.moviisky.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class LauncherRepositoryImpl constructor(context: Context) : LauncherRepository {
    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = DS_FILE_NAME
    )

    override fun isLauncherSkipped(): Flow<Boolean?> {
        return dataStore.data.catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[KEY_LAUNCHER_SKIPPED]
        }
    }

    override suspend fun setLauncherSkipped(isLauncherSkipped: Boolean) {
        dataStore.edit {
            it[KEY_LAUNCHER_SKIPPED] = isLauncherSkipped
        }
    }

    companion object {
        const val DS_FILE_NAME = "data_store_launcher"
        val KEY_LAUNCHER_SKIPPED = preferencesKey<Boolean>("key_launcher_skipped")
    }
}
