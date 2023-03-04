package com.example.hrresturant.ui

import android.app.Application
import com.example.hrresturant.data.dataSources.local.MyDatabase
import dagger.hilt.android.HiltAndroidApp

//Above step is needed because the application context is provided through generated application class
@HiltAndroidApp
class App: Application() {
//    override fun onCreate() {
//        super.onCreate()
////        Objects.createApiInstance()
//        MyDatabase.getDatabaseInstance(context = applicationContext)
//    }
}