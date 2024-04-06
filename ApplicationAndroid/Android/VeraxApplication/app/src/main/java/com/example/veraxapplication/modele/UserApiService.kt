package com.example.veraxapplication.modele

import com.example.veraxapplication.modele.user.User
import retrofit2.Call
import retrofit2.http.GET

interface UserApiService {
    @GET("users/")
    suspend fun getUsers(): Call<List<User>>

}