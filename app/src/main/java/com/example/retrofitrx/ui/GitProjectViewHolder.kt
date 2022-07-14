package com.example.retrofitrx.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitrx.databinding.ItemGitProjectBinding
import com.example.retrofitrx.domain.GitProjectEntity

class GitProjectViewHolder(private val binding: ItemGitProjectBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup) : GitProjectViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemView = ItemGitProjectBinding.inflate(inflater)
            return GitProjectViewHolder(itemView)
        }
    }

    fun bind(item: GitProjectEntity) {
        binding.itemGitRepoId.text = item.id.toString()
        binding.itemGitRepoName.text = item.name
    }
}