package pe.edu.cibertec.appgrupo13

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo13.databinding.ActivityPregunta4Binding

class Pregunta4Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btncalcular.setOnClickListener(this)
    }

    fun calcularMinutosComputables(minutos: Int): Int {
        return minutos - 10
    }

    fun calcularMontoAdicional(minutosComputables: Int): Double {
        return 30.00 + 2.50 * minutosComputables
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.btncalcular -> calcularAlquiler()
        }
    }

    fun calcularAlquiler() {
        val minutos = binding.etminutos.text.toString().toInt()

        if (minutos <= 10) {
            binding.tvresultado.text = "Tiempo de tolerancia para desalojo y cambio de turno."
        } else {
            val minutosComputables = calcularMinutosComputables(minutos)
            val monto = calcularMontoAdicional(minutosComputables)
            val montoFormateado = String.format("%.2f", monto)
            binding.tvresultado.text = "Minutos adicionales usados: $minutos\n" +
                    "Minutos computables para cobro: $minutosComputables\n" +
                    "Monto adicional a facturar: S/ $montoFormateado"
        }
    }
}