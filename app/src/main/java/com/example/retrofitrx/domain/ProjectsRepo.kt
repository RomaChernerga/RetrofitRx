package com.example.retrofitrx.domain

import com.example.retrofitrx.domain.GitProjectEntity
import io.reactivex.rxjava3.core.Single

interface ProjectsRepo {
    //CRUD
    fun observeReposForUser(userName: String) : Single<List<GitProjectEntity>>
}