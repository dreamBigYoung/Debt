package com.example.debt.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.debt.R
import com.example.debt.application.MyApplication
import com.example.debt.entity.DaoSession
import com.example.debt.entity.RewardContent
import com.example.debt.entity.RewardContentDao
import kotlinx.android.synthetic.main.layout_item_reward.view.*
import org.greenrobot.greendao.rx.RxDao
import org.greenrobot.greendao.rx.RxQuery
import rx.android.schedulers.AndroidSchedulers

class RewardListAdapter(context: Context, title: String) :
    RecyclerView.Adapter<RewardListAdapter.ViewHolder>(),
    View.OnClickListener {
    val rewardList = mutableListOf<RewardContent>()
    val context: Context

    val daoSession: DaoSession
    val rewardDao: RxDao<RewardContent, Long>
    val rewardQuery: RxQuery<RewardContent>

    val TAG = "RewardListAdapter"

    init {
        this.context = context
        this.daoSession = (context.applicationContext as MyApplication).getDaoSession()
        rewardDao = this.daoSession.rewardContentDao.rx()
        rewardQuery = this.daoSession.rewardContentDao.queryBuilder()
            .where(RewardContentDao.Properties.Level.eq(title))
            .orderDesc(RewardContentDao.Properties.Id).rx()
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

    fun addReward(content: String, level: String) {
        val element = RewardContent(null, level, content)
        rewardList.add(0, element)
        notifyDataSetChanged()
        //更新数据库
        rewardDao.insert(element)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ elementResult ->
                Log.i(TAG, "the id is ${elementResult.id}")
            },
                { t: Throwable? ->
                    Log.e(TAG, t?.message)
                }, {})
    }

    fun refreashList() {
        rewardQuery
            .list()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { resultList ->
                rewardList.clear()
                rewardList.addAll(resultList)
                notifyDataSetChanged()
            }


    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onClick(view: View?) {
        val position: Int = view?.getTag() as Int
        val removeAt = rewardList.removeAt(position)
        notifyDataSetChanged()
        rewardDao.delete(removeAt)
            .subscribe({},
                {
                    Log.e(TAG, it?.message)
                })
    }
}