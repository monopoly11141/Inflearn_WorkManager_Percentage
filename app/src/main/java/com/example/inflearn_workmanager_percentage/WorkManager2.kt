package com.example.inflearn_workmanager_percentage

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class WorkManager2(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    val TAG = this::class.java.simpleName

    override fun doWork(): Result {

        val format = SimpleDateFormat("hh:mm:ss", Locale.getDefault())
        val currentTime = format.format(Date())

        Log.d(TAG, "Current time : $currentTime")

        return Result.success()

    }


}