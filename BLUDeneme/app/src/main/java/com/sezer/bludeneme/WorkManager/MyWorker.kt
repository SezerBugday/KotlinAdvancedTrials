package com.sezer.bludeneme.WorkManager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

// Arkaplanda calısacak worker sinifi
class MyWorker(appContext :Context,
               workerParams:WorkerParameters):Worker(appContext,workerParams)
{
    override fun doWork(): Result {
        val toplam = 5+15
        println(toplam.toString())
        return  Result.success()
    }

}