package com.example.qweqa.firstproject.sign

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.qweqa.firstproject.R
import com.example.qweqa.firstproject.api.postApi
import com.example.qweqa.firstproject.models.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener(){
            onClickSignButton()
        }
    }

    private fun onClickSignButton(){
        postApi.sign(User(loginId.text.toString()))
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>){
                    handleSign(response.code(), response.body())
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(this@SignActivity, "Failure", Toast.LENGTH_LONG).show()
                }
            })
    }

    private fun handleSign(code: Int, user: User?){
        if (code !=201){
            Toast.makeText(this, "Failed to sign", Toast.LENGTH_SHORT).show()
            return
        }
    }
}