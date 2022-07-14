package com.example.retrofitrx.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitrx.app
import com.example.retrofitrx.databinding.ActivityReposBinding

class ReposActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReposBinding
    private val viewModel: ReposViewModel by viewModels { ReposViewModelFactory(app.gitProjectRepo) }
    private val adapter= GitProjectsAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityReposBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        initOutgoingEvents()
        initIncomingEvents()

    }

    // настройка RecyclerView
    private fun initViews() {
        binding.reposRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter.setHasStableIds(true)
        binding.reposRecyclerview.adapter = adapter
    }

    // тут принимаем данные
    private fun initIncomingEvents() {
        viewModel.repos.observe(this) {
            adapter.setData(it)
        }
    }

    // тут отдаем данные
    private fun initOutgoingEvents() {
        binding.showButton.setOnClickListener {
            val userName = binding.eTextUserName.text.toString()
            viewModel.onShowRepos(userName)
        }
    }
}