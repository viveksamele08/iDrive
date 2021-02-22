package com.assignments.idrive

import com.google.gson.annotations.SerializedName

   
data class Links (

   @SerializedName("self") var self : String,
   @SerializedName("html") var html : String,
   @SerializedName("download") var download : String

)