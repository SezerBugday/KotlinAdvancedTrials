package com.sezer.retrofit

class ApiUtils {
    companion object
    {


        val base_url ="https://raw.githubusercontent.com/"

        fun GetUlkeDaoInterface():UlkeDaoInterface
        {
            return RetrofitClient.getClient(base_url).create(UlkeDaoInterface::class.java)
        }

    }
}