package com.example.qweqa.firstproject

import android.app.Application
import com.example.qweqa.firstproject.common.DefaultPrefHelper

class AndroidTutorial: Application(){
    override fun onCreate(){
        super.onCreate()
        DefaultPrefHelper.init(this)
    }
}