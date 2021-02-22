package com.assignments.idrive

import com.google.gson.annotations.SerializedName

   
data class Categories (

   @SerializedName("id") var id : Int,
   @SerializedName("title") var title : String,
   @SerializedName("photo_count") var photoCount : Int,
   @SerializedName("links") var links : Links

){


}