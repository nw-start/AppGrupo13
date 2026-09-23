package pe.edu.cibertec.appgrupo13

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.view.View
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo13.databinding.ActivityMainBinding
import android.content.Intent



    class MainActivity : AppCompatActivity(), View.OnClickListener {

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.btnPregunta1.setOnClickListener(this)
            binding.btnPregunta2.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            when (v?.id) {

                binding.btnPregunta1.id -> {
                    val intent = Intent(this, Pregunta1Activity::class.java)
                    startActivity(intent)
                }

                binding.btnPregunta2.id -> {
                    val intent = Intent(this, Pregunta2Activity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

