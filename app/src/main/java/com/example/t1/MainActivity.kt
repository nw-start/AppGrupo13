package com.example.t1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.t1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPregunta4.setOnClickListener(this)
        binding.btnPregunta6.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == binding.btnPregunta6.id) {

            val intent = Intent(this, Pregunta6Activity::class.java)
            startActivity(intent)
        } else if (v?.id == binding.btnPregunta4.id) {

            val intent = Intent(this, Pregunta4Activity::class.java)
            startActivity(intent)
        }
    }
}

