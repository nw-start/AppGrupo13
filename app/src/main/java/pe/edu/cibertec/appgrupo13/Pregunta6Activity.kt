package pe.edu.cibertec.appgrupo13

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo13.databinding.ActivityPregunta6Binding
import java.util.Locale

class Pregunta6Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPregunta6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btncalcular.setOnClickListener(this)
        binding.btnregresar.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            binding.btncalcular.id -> calcularHospitalizacion()
            binding.btnregresar.id -> irMenu()
        }
    }

    fun calcularHospitalizacion() {
        val dias = binding.etdias.text.toString().toIntOrNull()
        if (dias == null || dias < 0) {
            binding.tvresultado.text = getString(R.string.error_numero)
            return
        }
        if (dias <= 3) {
            binding.tvresultado.text = getString(R.string.cortesia_p6)
        } else {
            val diasExcedentes = dias - 3
            val costo = 95.0 + (45.0 * diasExcedentes)
            binding.tvresultado.text = "Total de días registrados: $dias\n" +
                    "Días excedentes computables: $diasExcedentes\n" +
                    "Costo hospitalario adicional: ${formatoMoneda(costo)}"
        }
    }

    fun formatoMoneda(valor: Double): String = String.format(Locale.US, "S/ %.2f", valor)
    fun irMenu() { startActivity(Intent(this, MainActivity::class.java)) }
}
