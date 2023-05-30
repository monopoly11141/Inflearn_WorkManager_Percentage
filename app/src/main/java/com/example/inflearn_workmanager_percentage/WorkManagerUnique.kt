package com.example.inflearn_workmanager_percentage

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class WorkManagerUnique(context: Context, workerParams: WorkerParameters) : CoroutineWorker(context, workerParams) {

    private val TAG = this::class.java.simpleName

    override suspend fun doWork(): Result {

        Log.d(TAG, "Starting...")

        for (i in 1..3) {

            Log.d(TAG, "Printing : $i")
            delay(1_000)

        }

        Log.d(TAG, "...Ended")

        return Result.success()

    }

}