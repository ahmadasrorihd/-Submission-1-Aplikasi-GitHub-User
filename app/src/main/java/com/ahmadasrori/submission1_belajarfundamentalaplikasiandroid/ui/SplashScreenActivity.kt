package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.ui

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.R
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.ActivitySplashScreenBinding
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.util.Constant.DELAY

class SplashScreenActivity : AppCompatActivity() {
    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val animSlide = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.slide
        )
        binding.ivLogo.animation = animSlide
        val splashTread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(DELAY.toLong())
                } catch (e: InterruptedException) {
                } finally {
                    val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
                    startActivity(i)
                    finish()
                }
            }
        }
        splashTread.start()
    }
}