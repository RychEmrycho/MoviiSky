package com.rychemrycho.moviisky.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rychemrycho.moviisky.ui.launcher.LauncherActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, LauncherActivity::class.java))
        finish()
    }
}
