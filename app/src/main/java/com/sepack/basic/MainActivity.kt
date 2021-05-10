package com.sepack.basic

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import com.sepack.basic.databinding.ActivityMainBinding
import com.sepack.basic.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.run {
            viewModel.getHello()
            viewModel.hello.observe(this@MainActivity) { result ->
                result.onSuccess { hello ->
                    tvHello.text = hello
                }
                result.onFailure { throwable ->
                    val message = throwable.message
                    tvHello.text = message
                    tvHello.setTextColor(Color.RED)
                }
            }
        }
    }
}