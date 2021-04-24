package com.example.pract_ms_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CustomComponentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_component)
    }

    fun NextTask(view: View)
    {
        val newAct = Intent(this, CustomTimePickerActivity::class.java);
        startActivity(newAct);
    }

    fun PrevTask(view: View)
    {
        this.finish();
    }
}