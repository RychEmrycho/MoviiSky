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

class OnboardingRepositoryImpl constructor(context: Context) : OnboardingRepository {
    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = DS_FILE_NAME
    )

    override fun isOnboarded(): Flow<Boolean?> {
        return dataStore.data.catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[KEY_ONBOARDED]
        }
    }

    override suspend fun setOnboarded(isOnboarded: Boolean) {
        dataStore.edit {
            it[KEY_ONBOARDED] = isOnboarded
        }
    }

    companion object {
        const val DS_FILE_NAME = "data_store_onboarding"
        val KEY_ONBOARDED = preferencesKey<Boolean>("key_onboarded")
    }
}
