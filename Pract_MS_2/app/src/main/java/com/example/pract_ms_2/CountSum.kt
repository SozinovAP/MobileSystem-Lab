package com.example.pract_ms_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class CountSum : AppCompatActivity() {
    private var sum = 0;
    private var isCount = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_sum)
    }

    fun ToActionRec(view: View)
    {

        val newAct = Intent(this, ActionRectangle::class.java);
        startActivity(newAct);
    }

    fun ClearField(view: View)
    {
        findViewById<TextView>(R.id.first_number).text = "";
        findViewById<TextView>(R.id.second_number).text = "";
        isCount = false;
    }

    fun PrintSum(view: View)
    {
        if (!isCount)
            Count(view);

        if (isCount)
            Toast.makeText(applicationContext, sum.toString(), Toast.LENGTH_LONG).show();
        else
        {
            Toast.makeText(applicationContext, getString(R.string.text_input_val), Toast.LENGTH_LONG).show();
        }
    }

    fun Count(view: View)
    {
        if (findViewById<TextView>(R.id.first_number).text.toString().isNotEmpty() &&
            findViewById<TextView>(R.id.second_number).text.toString().isNotEmpty())
        {
            sum = Integer.parseInt(findViewById<TextView>(R.id.first_number).text.toString()) +
                Integer.parseInt(findViewById<TextView>(R.id.second_number).text.toString());
            isCount = true;
        }
    }
}