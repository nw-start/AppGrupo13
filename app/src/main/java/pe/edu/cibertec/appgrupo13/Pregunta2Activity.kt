package pe.edu.cibertec.appgrupo13

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import pe.edu.cibertec.appgrupo13.databinding.ActivityPregunta2Binding
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == binding.btnCalcular.id) {

            val pesoTexto = binding.edtPeso.text.toString()

            if (pesoTexto.isEmpty()) {
                binding.txtResultado.text = "Ingrese el peso de la mascota."
                return
            }

            val peso = pesoTexto.toDoubleOrNull()

            if (peso == null || peso < 0) {
                binding.txtResultado.text = "Ingrese un peso válido."
                return
            }

            if (peso <= 8) {

                binding.txtResultado.text =
                    "Mascota apta para viajar en cabina sin sobrecosto."

            } else {

                val exceso = peso - 8
                val recargo = 150.00 + (35.00 * exceso)

                binding.txtResultado.text = String.format(
                    Locale.US,
                    "Peso total ingresado: %.2f kg\n" +
                            "Exceso de peso: %.2f kg\n" +
                            "Monto total a pagar por recargo: S/ %.2f",
                    peso,
                    exceso,
                    recargo
                )
            }
        }
    }
}