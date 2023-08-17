package com.sezer.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters


class MyWorkerBildirimGonder (appContext : Context,
                              workerParams: WorkerParameters
): Worker(appContext,workerParams)
{
    override fun doWork(): Result {
        val toplam = "15 dk sonra calisti"
        println(toplam.toString())
        yazdir()
      //  PeriyodikBildirimDeneme.Yazdir()
        // her 15 dk da bir anlık bir tane bildrim gonder
        return  Result.success()

    }

    fun yazdir()
    {
        println("bildirim ici")
    }
}