package com.example.inflearn_workmanager_percentage

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay

class WorkManager1(context: Context, workerParams: WorkerParameters) : CoroutineWorker(context, workerParams) {

    companion object {
        const val HowMuch = "progress"
    }

    override suspend fun doWork(): Result {

        for (i in 1..10) {
            val result = workDataOf(HowMuch to i * 10)
            setProgress(result)
            delay(1_000)
        }

        return Result.success()

    }

}