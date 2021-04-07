package com.example.pract_ms_4

import android.app.ActivityManager
import android.app.ActivityManager.AppTask
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var am: ActivityManager;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        am = getSystemService(ACTIVITY_SERVICE) as ActivityManager;
        val task: AppTask = am.appTasks.get(0);
        findViewById<TextView>(R.id.dep_stack).text = getString(R.string.text_cur_stack_depth).plus(task.taskInfo.numActivities);
    }

    fun IncStackDepth(view: View)
    {
        val newAct = Intent(this, MainActivity::class.java);
        startActivity(newAct);
    }

    fun DecStackDepth(view: View)
    {
        this.finish();
    }

    fun NextTask(view: View)
    {
        val newAct = Intent(this, FirstPinActivity::class.java);
        startActivity(newAct);
    }
}