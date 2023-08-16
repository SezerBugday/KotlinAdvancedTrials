package com.sezer.retrofit
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class UlkeCevap (
    @SerializedName("Ulkeler")
    @Expose
    var ulkeler : List<Ulke>,

    @SerializedName("success")
    @Expose
    var success : String

)
{
}