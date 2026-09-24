package pe.edu.cibertec.appgrupo13

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPregunta1.setOnClickListener(this)
        binding.btnPregunta2.setOnClickListener(this)
        binding.btnPregunta3.setOnClickListener(this)
        binding.btnPregunta4.setOnClickListener(this)
        binding.btnPregunta5.setOnClickListener(this)
        binding.btnPregunta6.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val destination = when (view?.id) {
            binding.btnPregunta1.id -> Pregunta1Activity::class.java
            binding.btnPregunta2.id -> Pregunta2Activity::class.java
            binding.btnPregunta3.id -> Pregunta3Activity::class.java
            binding.btnPregunta4.id -> Pregunta4Activity::class.java
            binding.btnPregunta5.id -> Pregunta5Activity::class.java
            binding.btnPregunta6.id -> Pregunta6Activity::class.java
            else -> null
        }

        destination?.let { startActivity(Intent(this, it)) }
    }
}
