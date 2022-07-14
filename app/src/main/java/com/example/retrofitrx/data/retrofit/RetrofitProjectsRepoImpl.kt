package com.example.retrofitrx.data.retrofit

import com.example.retrofitrx.domain.GitProjectEntity
import com.example.retrofitrx.domain.ProjectsRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.subscribeBy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProjectsRepoImpl : ProjectsRepo {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())

        .build()
    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun observeReposForUser(userName: String): Single<List<GitProjectEntity>> {

        return api.listRepos(userName)
    }
}