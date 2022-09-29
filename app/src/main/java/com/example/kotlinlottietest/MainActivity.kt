package com.example.kotlinlottietest

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kotlinlottietest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var isHearting : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickButton(view: View) {
        if (!isHearting) {
            val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(500)
            animator.addUpdateListener {
                binding.animationView.progress = it.animatedValue as Float
            }
            animator.start()
            isHearting = true
            Log.d("Lottie TEST", "좋아요 버튼을 누르면 하트가 나온다")
        } else {
            val animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(500)
            animator.addUpdateListener {
                binding.animationView.progress = it.animatedValue as Float
            }
            animator.start()
            isHearting = false
        }
    }
}