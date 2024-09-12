package com.example.composeapplication.retrofit.network

import com.example.composeapplication.retrofit.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {
    companion object{
        const val BASE_URL ="https://jsonplaceholder.typicode.com/"
    }
    @GET("Posts")
    suspend fun getPost():List<Post>
}