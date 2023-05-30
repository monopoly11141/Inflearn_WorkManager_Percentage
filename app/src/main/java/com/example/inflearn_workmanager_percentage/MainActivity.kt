package com.example.inflearn_workmanager_percentage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.inflearn_workmanager_percentage.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val TAG = this::class.java.simpleName
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val btnClick = binding.btnClick

        btnClick.setOnClickListener {

            val workManagerUnique = OneTimeWorkRequestBuilder<WorkManagerUnique>().build()
            WorkManager.getInstance(this)
                .enqueueUniqueWork("workManagerUnique", ExistingWorkPolicy.REPLACE, workManagerUnique)

        }

//        val workManager1 = OneTimeWorkRequestBuilder<WorkManager1>().build()
//        WorkManager.getInstance(this).enqueue(workManager1)
//
//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManager1.id)
//            .observe(this, Observer { workInfo ->
//                val progress = workInfo?.progress
//                val value = progress?.getInt(HowMuch, 0)
//
//                if (value != 0) {
//                    Log.d(TAG, "Progress : $value")
//                }
//            })

        val workerManager2 = PeriodicWorkRequestBuilder<WorkManager2>(15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(workerManager2)

    }
}