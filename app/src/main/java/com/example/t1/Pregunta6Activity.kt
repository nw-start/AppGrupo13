package com.example.t1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.t1.databinding.ActivityPregunta6Binding

class Pregunta6Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == binding.btnCalcular.id) {

            val dias = binding.etDias.text.toString().toIntOrNull()

            if (dias == null) {
                binding.tvResultado.text = "Ingrese una cantidad válida de días."
                return
            }

            if (dias <= 3) {

                binding.tvResultado.text =
                    "Días cubiertos por el paquete quirúrgico contratado."

            } else {

                val diasExcedentes = dias - 3
                val costo = 95.00 + (45.00 * diasExcedentes)

                binding.tvResultado.text =
                    "Total de días registrados: $dias\n" +
                            "Días excedentes computables: $diasExcedentes\n" +
                            "Costo hospitalario adicional: S/ %.2f".format(costo)
            }
        }
    }
}