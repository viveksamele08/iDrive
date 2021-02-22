package com.assignments.idrive.data.remote.api

  import com.assignments.idrive.model.pintrest.UserObject
  import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

 @GET("raw/wgkJgazE")
 fun getUsers(): Call<List<UserObject>>


}