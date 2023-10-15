package com.appisKey_assessment

import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface PixApiServices {

    companion object {
        const val BASE_URL = "https://pixabay.com/api/"
    }
    @GET
    suspend fun LoadPixData(
        @Query("key") key: String="38437071-5f1d14114d464cb7440d92ebd",
        @Query("q") q:String="kitten",
        @Query("image_type") image_type:String="photo",
        @Query("pretty") pretty:Boolean=true
    ): ResponseBody

}