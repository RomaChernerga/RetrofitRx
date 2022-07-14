package com.example.retrofitrx

import android.app.Application
import android.content.Context
import com.example.retrofitrx.data.MockProjectsRepoImpl
import com.example.retrofitrx.domain.ProjectsRepo

class App : Application() {

    val gitProjectRepo: ProjectsRepo by lazy { MockProjectsRepoImpl() }
}

val Context.app : App
get()= applicationContext as App

