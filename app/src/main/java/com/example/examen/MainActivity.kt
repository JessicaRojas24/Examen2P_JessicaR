package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    data class Persona(val nombre: String, val apellidos: String)
    object UserData {
        val username = "jess"
        val password = "jess"
        val personas = listOf(Persona("Jessica Judith", "Rojas Torres"))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {
            val user = binding.edtLogin.text.toString()
            val pass = binding.edtPassword.text.toString()

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Ingresa tus datos", Toast.LENGTH_SHORT).show()
            } else if (user == UserData.username && pass == UserData.password) {
                val intent = Intent(this, MainActivityBienvenida::class.java)
                intent.putExtra("nombre", UserData.personas[0].nombre)
                intent.putExtra("apellidos", UserData.personas[0].apellidos)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}