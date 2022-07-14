package com.example.retrofitrx.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitrx.domain.ProjectsRepo

class ReposViewModelFactory(private val repo: ProjectsRepo) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create (modelClass: Class<T>): T {
        return ReposViewModel(repo) as T
    }
}

