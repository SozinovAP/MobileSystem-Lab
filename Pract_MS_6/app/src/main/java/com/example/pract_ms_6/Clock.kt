package com.example.pract_ms_6

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

enum class Field{
    Hour,
    Minute,
    Second
}

class Clock(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs)  {
    private var hour: Int = 0;
    private var minute: Int = 0;
    private var second: Int = 0;
    private lateinit var clockView: TextView;

    init
    {
        val hour = 0;
        val minutes = 0;
        val seconds = 0;

        InitComponents();
        SetTime(hour, Field.Hour);
        SetTime(minutes, Field.Minute);
        SetTime(seconds, Field.Second);
    }

    private fun InitComponents()
    {
        // There will init textView
    }

    fun SetTime(value: Int, f: Field)
    {
        when (f)
        {
            Field.Hour -> hour = if (value < 0 || value > 23)
                                        0
                                    else
                                        value;
            Field.Minute -> minute = if (value < 0 || value > 59)
                0
            else
                value;
            Field.Second -> second = if (value < 0 || value > 59)
                0
            else
                value;
        }

    }

    fun GetTime(f: Field): Int
    {
        return when (f) {
            Field.Hour -> hour;
            Field.Minute -> minute
            Field.Second -> second;
        }
    }
}