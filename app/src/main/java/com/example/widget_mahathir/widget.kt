package com.example.widget_mahathir

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widget_mahathir.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

private lateinit var binding : ActivityWidgetBinding
class widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWidgetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Ini adalah Toast", Toast.LENGTH_SHORT).show()
        }

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "ini adalah snackbar", Snackbar.LENGTH_SHORT).show()
        }

        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Message")
                setMessage("ini adalah Alert")

                setPositiveButton("OK") { dialog, _ ->
                    Toast.makeText(applicationContext, "anda klik OK", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }

                setNegativeButton("Back") { dialog, _ ->
                    Toast.makeText(applicationContext, "anda klik Back", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }
            }.show()
        }
        //Button custom Dialog
        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(window.hashCode())
                setCancelable(false)
                setContentView(R.layout.custom_dialog)

                val btnCancel = this.findViewById<Button>(R.id.btnCancel)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext, "anda klik cancel",Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }

                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext, "anda klik continue",Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }

    }
}