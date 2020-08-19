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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward_remake)
        val rewardRv = findViewById<RecyclerView>(R.id.reward_rv)
        rewardRv?.layoutManager = LinearLayoutManager(this)
        rewardRv?.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rewardRv?.adapter = RewardListAdapter(this)
        btn_add_reward.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_add_reward -> {
                val adapter: RewardListAdapter = reward_rv.adapter as RewardListAdapter
                val trim = text_reward_add.text.trim().toString()
                text_reward_add.setText("")
                if (!TextUtils.isEmpty(trim)) {
                    adapter.addReward(trim)
                }

            }
        }

    }
}