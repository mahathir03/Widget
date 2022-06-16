package com.example.widget_mahathir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.widget_mahathir.databinding.ActivityMainBinding
import com.example.widget_mahathir.databinding.ActivityWidgetBinding

private lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val getData = intent.getParcelableExtra<ModelLogin>("data")
        binding.txtUserName.text = getData?.username.toString()
        binding.txtPassword.text = getData?.password.toString()


        binding.btnIntentWidget.setOnClickListener {
            val intent = Intent(this, widget::class.java)
            startActivity(intent)

        }

        binding.btnIntentExplisit.setOnClickListener {

            val intent = Intent(this, ImplisitIntent::class.java)
            startActivity(intent)
        }

    }
}