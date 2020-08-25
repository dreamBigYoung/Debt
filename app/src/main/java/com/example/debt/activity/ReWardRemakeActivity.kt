package com.example.debt.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.debt.R
import com.example.debt.adapter.RewardListAdapter
import kotlinx.android.synthetic.main.activity_reward_remake.*

class ReWardRemakeActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        val TITLE: String = "TITLE"
        val CAPTAIN: String = "CAPTAIN"
        val ADMIRAL: String = "ADMIRAL"
        val GOVORNOR: String = "GOVPRNOR"

    }

    lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward_remake)
        //提取传参
        title = intent.getStringExtra(ReWardRemakeActivity.TITLE)

        val rewardRv = findViewById<RecyclerView>(R.id.reward_rv)
        rewardRv?.layoutManager = LinearLayoutManager(this)
        rewardRv?.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val rewardListAdapter = RewardListAdapter(this, title)
        rewardRv?.adapter = rewardListAdapter

        btn_add_reward.setOnClickListener(this)
        btn_add_reward.setText("添加  ${getNameFromTitle(title)}  福利")

        //刷新显示
        rewardListAdapter.refreashList()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_add_reward -> {
                val adapter: RewardListAdapter = reward_rv.adapter as RewardListAdapter
                val trim = text_reward_add.text.trim().toString()
                text_reward_add.setText("")
                if (!TextUtils.isEmpty(trim)) {
                    adapter.addReward(trim, title)
                }

            }
        }

    }

    fun getNameFromTitle(title: String): String {
        when (title) {
            ReWardRemakeActivity.CAPTAIN -> return "舰长"
            ReWardRemakeActivity.ADMIRAL -> return "提督"
            ReWardRemakeActivity.GOVORNOR -> return "总督"
            else -> return "舰长"
        }

    }
}