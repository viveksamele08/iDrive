package com.assignments.idrive.model.pintrest

import android.provider.ContactsContract
import com.assignments.idrive.Categories
import com.assignments.idrive.Links
import com.assignments.idrive.Urls
import com.assignments.idrive.User
import com.google.gson.annotations.SerializedName
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*


data class UserObject(

   @SerializedName("id") var id: String,
   @SerializedName("created_at") var createdAt: String,
   @SerializedName("width") var width: Int,
   @SerializedName("height") var height: Int,
   @SerializedName("color") var color: String,
   @SerializedName("likes") var likes: Int,
   @SerializedName("liked_by_user") var likedByUser: Boolean,
   @SerializedName("user") var user: User,
   @SerializedName("current_user_collections") var currentUserCollections: List<String>,
   @SerializedName("urls") var urls: Urls,
   @SerializedName("categories") var categories: List<Categories>,
   @SerializedName("links") var links: Links

)
{
   public fun formatedCategories(): String?{

        var formatedString: String? = "Categories "

      for (item in  categories)
      {
         formatedString += "#${item.title}(${item.photoCount}) "
      }
      return  formatedString
   }



}


