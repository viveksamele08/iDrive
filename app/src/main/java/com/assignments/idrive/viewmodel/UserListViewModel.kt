package com.assignments.idrive.viewmodel

import androidx.lifecycle.MutableLiveData
 import com.assignments.idrive.data.UserRepository
 import com.assignments.idrive.model.pintrest.UserObject
import com.assignments.idrive.viewmodel.base.BaseViewModel

class UserListViewModel : BaseViewModel() {

    val userListLiveData = MutableLiveData<List<UserObject>>()

    // fetch the All Users

    fun fetchUserList() {
        dataLoading.value = true

        UserRepository.getInstance().getUserList() { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                userListLiveData.value = response
                 empty.value = false
            } else {
                empty.value = true
            }

        }



        }
    }
