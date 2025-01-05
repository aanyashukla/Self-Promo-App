package com.aanyashukla.self_promoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        displayMessage()
        setupButton()
    }

    private fun displayMessage(){
        val textViewMessage: TextView = findViewById(R.id.text_view_message)

        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
            Hi! ${message.contactName},
            
            My name is ${message.myDisplayName} and I'm ${message.getFullJobDescription()}
            
            I have a portfolio of apps to demonstrate my technical skills that i can show on request.
            
            I'm able to start a new position ${message.getAvailability()}.
            
            Please get in touch if you have any suitable roles for me.
            
            Thanks and best regards.
        """.trimIndent()
        textViewMessage.text = messagePreviewText
    }

    private fun setupButton(){
        val buttonSendMessage: Button = findViewById(R.id.button_send_message)
        buttonSendMessage.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")  // Only SMS apps respond to this.
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }
}