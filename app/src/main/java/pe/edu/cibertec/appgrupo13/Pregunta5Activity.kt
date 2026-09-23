package pe.edu.cibertec.appgrupo13

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo13.databinding.ActivityPregunta5Binding
import java.util.Locale

class Pregunta5Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPregunta5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta5Binding.inflate(layoutInflater)
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
            R.id.btncalcular -> calcularSobrecarga()
            R.id.btnregresar -> irMenu()
        }
    }

    fun calcularSobrecarga() {
        val watts = binding.etwatts.text.toString().toIntOrNull()
        if (watts == null || watts < 0) {
            binding.tvresultado.text = getString(R.string.error_numero)
            return
        }
        if (watts <= 1000) {
            binding.tvresultado.text = getString(R.string.cortesia_p5)
        } else {
            val sobrecarga = watts - 1000
            val cobro = 180.0 + (0.40 * sobrecarga)
            binding.tvresultado.text = "Potencia registrada: $watts W\n" +
                    "Sobrecarga de potencia: $sobrecarga W\n" +
                    "Cobro por sobrecarga energética: ${formatoMoneda(cobro)}"
        }
    }

    fun formatoMoneda(valor: Double): String = String.format(Locale.US, "S/ %.2f", valor)
    fun irMenu() { startActivity(Intent(this, MainActivity::class.java)) }
}
