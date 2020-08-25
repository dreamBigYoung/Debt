package com.example.debt.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.debt.R
import com.example.debt.activity.ReWardRemakeActivity
import kotlinx.android.synthetic.main.fragment_reward_remake.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RewardRemakeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reward_remake, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_RewardRemakeFragment_to_FirstFragment)
        }
        view.findViewById<Button>(R.id.btn_captain).setOnClickListener { view ->
            onClick(view)
        }
        btn_admiral.setOnClickListener(this)
        btn_governor.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        lateinit var title: String
        when (view?.id) {
            R.id.btn_captain -> title =
                ReWardRemakeActivity.CAPTAIN
            R.id.btn_admiral -> title =
                ReWardRemakeActivity.ADMIRAL
            R.id.btn_governor -> title =
                ReWardRemakeActivity.GOVORNOR
            else -> title =
                ReWardRemakeActivity.CAPTAIN
        }
        var intent: Intent = Intent(
            context,
            ReWardRemakeActivity::class.java
        )
        intent.putExtra(ReWardRemakeActivity.TITLE, title)
        context?.startActivity(intent)

    }
}