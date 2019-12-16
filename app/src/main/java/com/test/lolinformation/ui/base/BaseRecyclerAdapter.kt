package com.test.lolinformation.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.lolinformation.BR
import com.test.lolinformation.R

abstract class BaseRecyclerAdapter<Item, ViewBinding : ViewDataBinding>(
    callback: DiffUtil.ItemCallback<Item>
) : ListAdapter<Item, BaseViewHolder<ViewBinding>>(callback) {

    protected var listFull = mutableListOf<Item>()
    override fun submitList(list: MutableList<Item>?) {
        super.submitList(ArrayList<Item>(list ?: listOf()))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewBinding> {
        return BaseViewHolder(
            DataBindingUtil.inflate<ViewBinding>(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            ).apply {
                bindFirstTime(this)
            }
        )
    }
    fun setFullList(list: MutableList<Item>) {
        listFull = list
    }

    protected open fun bindFirstTime(binding: ViewBinding) {}

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding>, position: Int) {
        currentList.get(position)?.let {
            holder.binding.setVariable(BR.item, it)
            bindView(holder.binding, it, position)
        }
        holder.binding.executePendingBindings()
        holder.itemView.startAnimation(
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.fade_in)
        )
    }

    protected open fun bindView(binding: ViewBinding, item: Item, position: Int) {}
}

class BaseViewHolder<ViewBinding : ViewDataBinding>(
    val binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root)
