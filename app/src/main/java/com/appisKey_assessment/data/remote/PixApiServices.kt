package com.appisKey_assessment.data.remote

import com.appisKey_assessment.data.PixHelper
import okhttp3.Call
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface PixApiServices {

    companion object {
        const val BASE_URL = "https://pixabay.com/api/"
    }
    @GET("?key=38437071-5f1d14114d464cb7440d92ebd&q=kitten&image_type=photo&pretty=true")
    suspend fun LoadPixData():retrofit2.Response<PixHelper>

}