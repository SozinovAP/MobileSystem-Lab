package com.example.pract_ms_3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener


class RemainedTasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remained_tasks)

        ActionOnSpinner();
        ActionOnSwitch();
        ActionToSeekBarAndTextView();
    }

    private fun ActionOnSpinner()
    {
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

    private fun ActionOnSwitch()
    {
        val switch = findViewById<Switch>(R.id.switch1);

        switch.setOnCheckedChangeListener { _, isChecked ->
            findViewById<TextView>(R.id.textView_switch).text = if(isChecked)
                getString(R.string.text_switch_on);
            else
                getString(R.string.text_switch_off);
        }
    }

    private fun ActionToSeekBarAndTextView()
    {
        val seekBar = findViewById<SeekBar>(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (seekBar != null) {
                    findViewById<TextView>(R.id.value_seekBar).text = getString(R.string.text_seekBar).plus(seekBar.progress.toString())
                };
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {    }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {     }
        })
    }
}