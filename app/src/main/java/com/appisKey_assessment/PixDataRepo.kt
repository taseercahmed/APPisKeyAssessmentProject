package com.appisKey_assessment

import okhttp3.Response
import okhttp3.ResponseBody

class PixDataRepo(var pixApiServices: PixApiServices) {

    suspend fun LoadPixData(): ResponseBody {
         return pixApiServices.LoadPixData()
    }
}