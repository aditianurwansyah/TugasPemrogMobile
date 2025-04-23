package com.example.implicit

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
         setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val websiteEditText: EditText = findViewById(R.id.website_edit_text)
        val openWebsiteButton: Button = findViewById(R.id.open_website_button)
        openWebsiteButton.setOnClickListener {
            val websiteUrl = websiteEditText.text.toString()
            openWebsite(websiteUrl)
        }
        val locationEditText: EditText = findViewById(R.id.location_edit_text)
        val openLocationButton: Button = findViewById(R.id.location_button)
        openLocationButton.setOnClickListener {
            val locationName = locationEditText.text.toString()
            openLocation(locationName)
        }
        val shareEditText: EditText = findViewById(R.id.share_edit_text)
        val shareTextButton: Button = findViewById(R.id.share_edit_button)
        shareTextButton.setOnClickListener {
            val shareText = shareEditText.text.toString()
            shareText(shareText)

        }
        val implicitEdit: EditText = findViewById(R.id.implicit_edit_text)
        val implicitButton: Button = findViewById(R.id.implicit_button)
        implicitButton.setOnClickListener {
           val text = implicitEdit.text.toString()
            sendData(text)
        }
    }
    private fun openWebsite(url: String){
      val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
      Log.v("hello_warning", url)
        Toast.makeText(applicationContext,url,Toast.LENGTH_LONG).show()
        startActivity(intent)
    }
    private fun openLocation(location: String){
      val uri = Uri.parse("geo:0,0?=$location")
      val intent = Intent(Intent.ACTION_VIEW, uri)
      intent.setPackage("com.google.android.apps.maps")
      startActivity(intent)
    }
    private fun shareText(text: String){
     val intent = Intent(Intent.ACTION_SEND)
     intent.type= "text/plain"
     intent.putExtra(Intent.EXTRA_TEXT, text)
     startActivity(Intent.createChooser(intent,  "Pilih Aplikasi"))
    }
    private fun sendData(text: String){
     val intent = Intent(this, SecondActivity::class.java)
     intent.putExtra("LOCK", text)
     startActivity(intent)
    }

    fun openWebsite(view: View) {}
    fun openLocation(view: View) {}
    fun shareText(view: View) {}
    fun sendData(view: View) {}
}