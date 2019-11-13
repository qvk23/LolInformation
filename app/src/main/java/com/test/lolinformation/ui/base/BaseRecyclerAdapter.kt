package com.test.lolinformation.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<Item, ViewBinding : ViewDataBinding>(
    callback: DiffUtil.ItemCallback<Item>
) : ListAdapter<Item, BaseViewHolder<ViewBinding>>(callback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewBinding> {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding>, position: Int) {
        bindView(holder.binding, getItem(position), position)
        holder.binding.executePendingBindings()
    }

    protected open fun bindView(binding: ViewBinding, item: Item, position: Int) {}
}

class BaseViewHolder<ViewBinding : ViewDataBinding>(
    val binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root)
