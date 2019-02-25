package com.example.qweqa.firstproject.api

import com.example.qweqa.firstproject.models.HomeResponse
import com.example.qweqa.firstproject.models.PostUpdateDTO
import com.example.qweqa.firstproject.models.User
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

val postApi by lazy { PostBoardService.create()}

interface PostBoardService{
    @POST("/users/sign")
    fun sign(@Body user: User): Call<User>

    @GET("/home")
    fun home(@Query("page") page: Int): Call<HomeResponse>

    @POST("/posts")
    fun postOnBoard(@Body post: PostUpdateDTO): Call<PostUpdateDTO>

    companion object {
        fun create(): PostBoardService{
            val client = OkHttpClient.Builder()
                .addInterceptor(AddCookiesInterceptor())
                .addInterceptor(ReceivedCookiesInterceptor())
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://android-tutorial-server.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(PostBoardService::class.java)
        }


    }
}