package com.example.debt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.debt.R
import com.example.debt.model.RewardModel
import kotlinx.android.synthetic.main.layout_item_reward.view.*

class RewardListAdapter(context: Context) : RecyclerView.Adapter<RewardListAdapter.ViewHolder>(),
    View.OnClickListener {
    val rewardList = mutableListOf<RewardModel>()
    val context: Context

    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.layout_item_reward, parent, false)

        val viewHolder = ViewHolder(inflate)
        viewHolder.itemView.deleteIcon.setOnClickListener(this)
        return viewHolder
    }

    override fun getItemCount(): Int {

        return rewardList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.textView.text = rewardList.get(position).content
        holder.itemView.deleteIcon.setTag(position)
    }

    fun addReward(content: String) {
        rewardList.add(0, RewardModel(content))
        notifyDataSetChanged()
        //todo 更新数据库
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onClick(view: View?) {
        val position: Int = view?.getTag() as Int
        rewardList.removeAt(position)
        notifyDataSetChanged()
    }
}