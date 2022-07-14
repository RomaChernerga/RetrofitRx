package com.example.retrofitrx.data

import com.example.retrofitrx.domain.GitProjectEntity
import com.example.retrofitrx.domain.ProjectsRepo
import io.reactivex.rxjava3.core.Single

class MockProjectsRepoImpl : ProjectsRepo {

    override fun observeReposForUser(userName: String): Single<List<GitProjectEntity>> {
        val dummyList = listOf(
            GitProjectEntity(0, "Number zero"),
            GitProjectEntity(1, "Number one"),
            GitProjectEntity(2, "Number two"),
            GitProjectEntity(3, "Number three"),
            GitProjectEntity(4, "Number four"),
            GitProjectEntity(5, "Number five"),
            GitProjectEntity(6, "Number six"),
            GitProjectEntity(7, "Number seven"),
            GitProjectEntity(8, "Number eight"),
        )
        return Single.just(dummyList)
    }
}