package com.example.pract_ms_4

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import java.util.*
import java.util.Calendar.HOUR
import java.util.Calendar.MINUTE

class DialogTasksActivity : AppCompatActivity() {
    private lateinit var date: String;
    private var dateSelected = false;
    private lateinit var time: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_tasks)

        val calendar = Calendar.getInstance();
        val sdfDate = SimpleDateFormat("d MMMM yyyy", Locale.getDefault());
        date = sdfDate.format(calendar.time);
    }

    fun CallInputText(view: View) {
        val promptsView = LayoutInflater.from(applicationContext).inflate(
            R.layout.edit_text_dialog,
            null
        );
        val alertDialogBuilder = AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptsView);

        alertDialogBuilder.setCancelable(true)
            .setPositiveButton(
                getString(R.string.text_apply)
            ) { _, _ ->
                val inputText = promptsView.findViewById<EditText>(R.id.edit_text).text.toString();
                findViewById<TextView>(R.id.textView).text = inputText;
            }
            .setNegativeButton(
                getString(R.string.text_cancel)
            ) { dialog, _ -> dialog.cancel() };
        alertDialogBuilder.create().show();
    }

    fun CallSelectDate(view: View) {
        val promptsView = LayoutInflater.from(applicationContext).inflate(
            R.layout.select_date_dialog,
            null
        );

        val alertDialogBuilder = AlertDialog.Builder(this);
        val calendar = Calendar.getInstance();
        val calendarView = promptsView.findViewById<CalendarView>(R.id.calendarView);
        val sdfDate = SimpleDateFormat("d MMMM yyyy", Locale.getDefault());
        calendarView.setOnDateChangeListener { _, year, month, day ->
            calendar.set(year, month, day);
            date = sdfDate.format(calendar);
            dateSelected = true;
        }

        alertDialogBuilder.setView(promptsView);

        alertDialogBuilder.setCancelable(true)
            .setPositiveButton(
                getString(R.string.text_apply)
            ) { _, _ ->
                findViewById<TextView>(R.id.dateView).text = if (dateSelected)
                    date;
                else
                    sdfDate.format(calendarView.date);
                dateSelected = false;
            }
            .setNegativeButton(
                getString(R.string.text_cancel)
            ) { dialog, _ -> dialog.cancel() };
        alertDialogBuilder.create().show();
    }

    @SuppressLint("SetTextI18n")
    fun CallSelectTime(view: View) {
        val promptsView = LayoutInflater.from(applicationContext).inflate(
            R.layout.select_time_dialog,
            null
        );
        val alertDialogBuilder = AlertDialog.Builder(this);
        val timeView = promptsView.findViewById<TimePicker>(R.id.timePicker);

        alertDialogBuilder.setView(promptsView);

        alertDialogBuilder.setCancelable(true)
            .setPositiveButton(
                getString(R.string.text_apply)
            ) { _, _ ->
                findViewById<TextView>(R.id.timeView).text = timeView.hour.toString() + ":" + timeView.minute.toString();
            }
            .setNegativeButton(
                getString(R.string.text_cancel)
            ) { dialog, _ -> dialog.cancel() };
        alertDialogBuilder.create().show();
    }

    fun NextTask(view: View)
    {
        val newAct = Intent(this, ListTasksOnWeek::class.java);
        startActivity(newAct);
    }

    fun PrevTask(view: View)
    {
        this.finish();
    }
}