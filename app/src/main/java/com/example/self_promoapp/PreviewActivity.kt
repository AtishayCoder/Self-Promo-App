package com.example.self_promoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreviewActivity : AppCompatActivity() {
    private var sendMessageButton: Button? = null
    private var previewMessageTextView: TextView? = null
    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        sendMessageButton = findViewById(R.id.button_send_message)
        previewMessageTextView = findViewById(R.id.text_view_message)

        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
                Hi ${message.contactName},
                
                My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
                
                I have a portfolio of apps to demonstrate my technical skills that I can show on request.
                
                I am able to start a new position ${message.getAvailability()}.
                
                Thanks and best regards.
            """.trimIndent()

        previewMessageTextView?.text = messagePreviewText
    }

    private fun setupButton() {
        sendMessageButton!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }
}