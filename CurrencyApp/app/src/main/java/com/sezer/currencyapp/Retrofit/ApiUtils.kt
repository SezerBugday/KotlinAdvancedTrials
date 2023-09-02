package com.sezer.currencyapp.Retrofit

class ApiUtils {
    companion object
    {


        val base_url ="http://data.fixer.io/api/"

        fun GetMoneyDaoInterface(): MoneyDaoInterface
        {
            return RetrofitClient.getClient(base_url).create(MoneyDaoInterface::class.java)
        }

    }
}