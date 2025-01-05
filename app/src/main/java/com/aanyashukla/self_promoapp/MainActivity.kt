package com.aanyashukla.self_promoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    //yaha directly hamne findViewByid isliye nii kara because ye setContentView se pehle nii kar skte use
    //and ye variables kisi bhi method ke bahar isliye define kare h kyuki ye multiple methods m use honge isliye onCreate method m define nii kare
    var contactNameEditText: TextInputEditText? = null
    var contactNumberEditText: TextInputEditText? = null
    var myDisplayNameEditText: TextInputEditText? = null
    var startDateEditText: TextInputEditText? = null
    var juniorCheckBox: CheckBox? = null
    var immediateStartCheckBox: CheckBox? = null
    var jobSpinner: Spinner? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactNameEditText = findViewById(R.id.edit_text_contact_name)
        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
        myDisplayNameEditText = findViewById(R.id.edit_text_my_display_name)
        startDateEditText= findViewById(R.id.edit_text_start_date)
        juniorCheckBox = findViewById(R.id.check_box_junior)
        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start)
        jobSpinner = findViewById(R.id.spinner_job_title)

        val previewButton: Button = findViewById(R.id.button_preview)
        previewButton.setOnClickListener {
            onPreviewCliked()
        }
        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        val spinnerJobTitle: Spinner = findViewById(R.id.spinner_job_title)
        spinnerJobTitle.adapter = spinnerAdapter
    }

    private fun onPreviewCliked() {


        val message = Message(
            contactNameEditText!!.text.toString(),
            contactNumberEditText!!.text.toString(),
            myDisplayNameEditText!!.text.toString(),
            juniorCheckBox!!.isChecked,
            jobSpinner!!.selectedItem?.toString(),     //yha ? isliye lagaya kyuki for now spinner khali h mtlb null value throw krega so to ensure safe calling we used ?
            immediateStartCheckBox!!.isChecked,
            startDateEditText!!.text.toString(),
            )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
//        previewActivityIntent.putExtra("Contact Name", contactName)
//        previewActivityIntent.putExtra("Contact Number", contactNumber)
//        previewActivityIntent.putExtra("My Display Name", myDisplayName)
//        previewActivityIntent.putExtra("Start Date", startDate)
//        previewActivityIntent.putExtra("Include Junior", includeJunior)
//        previewActivityIntent.putExtra("Immediate Start", immediateStart)
//        previewActivityIntent.putExtra("Job Title", jobTitle)
        previewActivityIntent.putExtra("Message", message)


        startActivity(previewActivityIntent)

    }
}