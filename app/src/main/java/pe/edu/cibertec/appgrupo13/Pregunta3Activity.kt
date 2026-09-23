package pe.edu.cibertec.appgrupo13

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo13.databinding.ActivityPregunta3Binding

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta3Binding.inflate(layoutInflater)
        // setContentView(R.layout.activity_pregunta3)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnCalcular.setOnClickListener(this)
        //binding.btnirpregunta4.setOnClickListener(this)
    }

    fun calcularPenalizacion ():String {
        val sobrante = binding.etsobrante.text.toString().toDouble()

        return when {
            sobrante <= 100 -> "Plato dentro del margen admisible de consumo."
            sobrante > 100 -> """
                Gramos sobrantes pesados: $sobrante
                Exceso de desperdicio: ${sobrante - 100}
                Penalización total por desperdicio: S/${String.format("%.2f",(15 + (0.12 * (sobrante - 100))))}  
            """.trimIndent()
            else -> "Valor ingresado inválido"
        }

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnCalcular -> calcularPen()
            //R.id.btnirpregunta4 -> irPregunta4()
        }
    }

    fun calcularPen() {
        val resultadoSobrante = calcularPenalizacion()
        binding.tvmostrar.text = resultadoSobrante
    }
/*
    fun irPregunta4(){
        startActivity(
            Intent(this, Pregunta4Activity::class.java)
        )
    }
*/

}
