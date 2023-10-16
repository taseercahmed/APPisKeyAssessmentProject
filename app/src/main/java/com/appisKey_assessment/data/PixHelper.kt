package com.appisKey_assessment.data

import com.google.gson.annotations.SerializedName


data class PixHelper (

  @SerializedName("total")
  var total : Int?= null,
  @SerializedName("totalHits" )
  var totalHits : Int?= null,
  @SerializedName("hits")
  var hits: ArrayList<Hits> = arrayListOf()

)