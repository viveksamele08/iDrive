package com.assignments.idrive.data

import com.assignments.idrive.data.remote.api.ApiClient
 import com.assignments.idrive.model.pintrest.UserObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {



    // GET users list
    fun getUserList(onResult: (isSuccess: Boolean, response: List<UserObject>?) -> Unit) {

        ApiClient.instance.getUsers().enqueue(object : Callback<List<UserObject>> {
            override fun onResponse(call: Call<List<UserObject>>?, response: Response<List<UserObject>>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<List<UserObject>>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: UserRepository? = null
        fun getInstance() = INSTANCE
            ?: UserRepository().also {
                INSTANCE = it
            }
    }
}