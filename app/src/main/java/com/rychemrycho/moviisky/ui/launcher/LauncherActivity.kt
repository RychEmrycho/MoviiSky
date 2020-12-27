package com.rychemrycho.moviisky.ui.launcher

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rychemrycho.moviisky.databinding.ActivityLauncherBinding

class LauncherActivity : AppCompatActivity() {
    private val viewModel: LauncherViewModel by viewModels()
    private lateinit var binding: ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLauncherBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (!viewModel.isOnboarded()) {
            TODO("launch onboarding screen")
        }

        if (viewModel.isAuthenticated() || viewModel.isLauncherSkipped()) {
            TODO("launch home screen")
        }

        binding.btnSignIn.setOnClickListener {
            TODO("launch sign in screen")
        }

        binding.btnSignUp.setOnClickListener {
            TODO("launch sign up screen")
        }

        binding.btnSkipLauncher.setOnClickListener {
            if (binding.cbSkipLauncher.isChecked) {
                viewModel.hideLauncher()
            }
            TODO("launch home screen")
        }
    }
}
