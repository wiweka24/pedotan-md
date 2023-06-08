package com.capstone.pedotan.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.capstone.pedotan.R
import com.capstone.pedotan.databinding.ActivityProfileBinding
import com.capstone.pedotan.databinding.ActivityRegisterBinding
import com.capstone.pedotan.databinding.ActivitySettingBinding
import com.capstone.pedotan.ui.ViewModelFactory

class ProfileActivity : AppCompatActivity() {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupAction()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(this))[ProfileViewModel::class.java]
    }

    private fun setupAction() {
        viewModel.getSettings()

        viewModel.user.observe(this) { user ->
            binding.apply {
                tvUsername.text = user?.username
                tvEmail.text = user?.fullname
                Glide.with(profileImage)
                    .load("https://picsum.photos/512")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(profileImage)
            }
        }
    }
}