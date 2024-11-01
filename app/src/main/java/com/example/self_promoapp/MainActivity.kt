package com.example.self_promoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var contactNameEditText: TextInputEditText? = null
    private var contactNumberEditText: TextInputEditText? = null
    private var myDisplayNameEditText: TextInputEditText? = null
    private var startDateEditText: TextInputEditText? = null
    private var juniorCheckbox: CheckBox? = null
    private var immediateStartCheckbox: CheckBox? = null
    private var jobTitleSpinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactNameEditText = findViewById(R.id.edit_text_contact_name)
        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
        myDisplayNameEditText = findViewById(R.id.edit_text_my_display_name)
        startDateEditText = findViewById(R.id.edit_text_start_date)
        juniorCheckbox = findViewById(R.id.check_box_junior)
        immediateStartCheckbox = findViewById(R.id.check_box_immediate_start)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)

        val previewButton: Button = findViewById(R.id.button_preview)
        previewButton.setOnClickListener {
            onPreviewClicked()
        }
        val spinnerValues = arrayOf("Android Developer", "Android Engineer", "iOS Developer", "iOS Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        jobTitleSpinner?.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {

        val message = Message(
            contactNameEditText!!.text.toString(),
            contactNumberEditText!!.text.toString(),
            myDisplayNameEditText!!.text.toString(),
            juniorCheckbox!!.isChecked,
            jobTitleSpinner!!.selectedItem?.toString(),
            immediateStartCheckbox!!.isChecked,
            startDateEditText!!.text.toString()
        )
        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)
        startActivity(previewActivityIntent)
    }
}