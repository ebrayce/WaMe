package com.ebrayce.wame

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ebrayce.wame.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var txtPhoneNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        txtPhoneNumber = binding.txtPhoneNumber
        setContentView(view)
    }

    fun sendMessage(view: View) {
        val msgIntent = Intent(Intent.ACTION_VIEW)
        msgIntent.data =
            Uri.parse(getString(R.string.whatsAppApiPrefix) + txtPhoneNumber.text.toString())
        val title = getString(R.string.sndMessage)
        val chooser = Intent.createChooser(msgIntent, title)
        try {
            startActivity(chooser)
        } catch (e: Error) {
            startActivity(msgIntent)
        }
    }

}