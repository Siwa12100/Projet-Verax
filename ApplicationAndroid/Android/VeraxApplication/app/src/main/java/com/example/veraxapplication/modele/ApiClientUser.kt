package com.example.veraxapplication.modele

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientUser {

    private const val BASE_URL = "https://codefirst.iut.uca.fr/containers/Verax-verax-api"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    interface UserApiService {
//        @GET("users")
//        suspend fun getUsers() : List<User>
//    }
}

    object ApiClientUser {
        val apiService: UserApiService by lazy {
            RetrofitClientUser.retrofit.create(UserApiService::class.java)
        }
    }