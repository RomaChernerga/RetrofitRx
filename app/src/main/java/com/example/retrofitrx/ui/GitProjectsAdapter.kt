package com.example.retrofitrx.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitrx.domain.GitProjectEntity

class GitProjectsAdapter: RecyclerView.Adapter<GitProjectViewHolder>() {
    private var data: List<GitProjectEntity> = emptyList()

    fun setData(repos: List<GitProjectEntity>) {
        data = repos
//        setHasStableIds(true)
        notifyDataSetChanged()
    }

    // Создание
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitProjectViewHolder {
        return GitProjectViewHolder.create(parent)
    }
    // Привязывание элементов
    override fun onBindViewHolder(holder: GitProjectViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    private fun getItem(pos: Int): GitProjectEntity = data[pos]

    override fun getItemCount(): Int = data.size
}
