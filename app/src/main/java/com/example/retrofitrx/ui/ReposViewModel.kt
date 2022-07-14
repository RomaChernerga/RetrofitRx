package com.example.retrofitrx.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitrx.domain.GitProjectEntity
import com.example.retrofitrx.domain.ProjectsRepo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class ReposViewModel(private val gitProjectRepo: ProjectsRepo) : ViewModel() {

    private val _repos = MutableLiveData<List<GitProjectEntity>>()  /** <- этот объект делаем чтобы в него закидывать события **/
    val repos: LiveData<List<GitProjectEntity>> = _repos    /** <- а этот, чтобы с него считывать события, без возможности постить в него **/
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun onShowRepos(userName: String) {
        // Подписываемся на обновления + добавляем в механизм отписывания
        compositeDisposable.add(
            gitProjectRepo
                .observeReposForUser(userName)
                .subscribeBy {
                // Отправляеи результаты после обновления данных
                _repos.postValue(it)
            }
        )
    }
}