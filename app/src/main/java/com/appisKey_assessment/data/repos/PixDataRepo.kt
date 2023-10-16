package com.appisKey_assessment.data.repos

import com.appisKey_assessment.data.Hits
import com.appisKey_assessment.data.PixHelper
import com.appisKey_assessment.data.remote.PixApiServices
import okhttp3.Call
import okhttp3.ResponseBody
import retrofit2.Response

class PixDataRepo(var pixApiServices: PixApiServices) {

    var selectedObj:Hits?=null

    suspend fun LoadPixData(): Response<PixHelper> {
         return pixApiServices.LoadPixData()
    }

    fun setSelectedHit(hits: Hits){
        selectedObj=hits
    }
    fun getSelectedHit(): Hits? {
        return selectedObj
    }
}