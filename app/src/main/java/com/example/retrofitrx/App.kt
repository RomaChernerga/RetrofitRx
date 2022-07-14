package com.example.retrofitrx

import android.app.Application
import android.content.Context
import com.example.retrofitrx.data.MockProjectsRepoImpl
import com.example.retrofitrx.data.retrofit.RetrofitProjectsRepoImpl
import com.example.retrofitrx.domain.ProjectsRepo

class App : Application() {

//    val gitProjectRepo: ProjectsRepo by lazy { MockProjectsRepoImpl() }
    val gitProjectRepo: ProjectsRepo by lazy { RetrofitProjectsRepoImpl() }
}

val Context.app : App
get()= applicationContext as App

