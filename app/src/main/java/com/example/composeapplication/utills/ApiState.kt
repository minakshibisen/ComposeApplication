package com.example.composeapplication.utills

import com.example.composeapplication.retrofit.Post

sealed class ApiState {
    class Success(val data:List<Post>):ApiState()
    class Failure(val msg :Throwable):ApiState()

     object Loading : ApiState()
     object Empty : ApiState()
        

    
}