package com.example.pract_ms_3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import android.widget.Toast


class RemainedTasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remained_tasks)
        val spinner = findViewById<Spinner>(R.id.spinner);

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, itemSelected: View,
                                        selectedItemPosition: Int, selectedId: Long) {
                val choose = resources.getStringArray(R.array.number)
                Toast.makeText(applicationContext, choose[selectedItemPosition], Toast.LENGTH_SHORT).show();
                Log.d("choose", choose[selectedItemPosition]);
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}