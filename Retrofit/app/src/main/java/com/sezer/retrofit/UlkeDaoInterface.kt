package com.sezer.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface UlkeDaoInterface {

    @GET("SezerBugday/KotlinTrials/master/ulkeler.json")
    fun VeriGetir():Call<UlkeCevap>
}