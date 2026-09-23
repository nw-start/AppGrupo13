package pe.edu.cibertec.appgrupo13

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo13.databinding.ActivityPregunta1Binding
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPregunta1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == binding.btnCalcular.id) {

            val horasTexto = binding.edtHoras.text.toString()

            if (horasTexto.isEmpty()) {
                binding.txtResultado.text = "Ingrese las horas adicionales."
                return
            }

            val horas = horasTexto.toDoubleOrNull()

            if (horas == null || horas < 0) {
                binding.txtResultado.text = "Ingrese un valor válido."
                return
            }

            if (horas <= 2) {

                binding.txtResultado.text =
                    "Salida dentro del margen de cortesía del hotel."

            } else {

                val horasCobro = horas - 2
                val cargo = 60.00 + (25.00 * horasCobro)

                binding.txtResultado.text = String.format(
                    Locale.US,
                    "Horas adicionales solicitadas: %.2f horas\n" +
                            "Horas sujetas a cobro: %.2f horas\n" +
                            "Cargo total por Late Check-out: S/ %.2f",
                    horas,
                    horasCobro,
                    cargo
                )
            }
        }
    }
}