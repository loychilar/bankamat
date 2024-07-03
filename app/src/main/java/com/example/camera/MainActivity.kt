package com.example.camera

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.camera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.videoView.setOnClickListener{
            getImageContent.launch("*/*")
        }
    }

    private val getImageContent = registerForActivityResult(ActivityResultContracts.GetContent()){
        it ?: return@registerForActivityResult
        binding.videoView.setVideoURI(it)

    }
}