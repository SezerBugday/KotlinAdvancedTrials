package com.sezer.currencyapp.Retrofit

class ApiUtils {
    companion object
    {


        val base_url ="https://raw.githubusercontent.com/"

        fun GetMoneyDaoInterface(): MoneyDaoInterface
        {
            return RetrofitClient.getClient(base_url).create(MoneyDaoInterface::class.java)
        }

    }
}