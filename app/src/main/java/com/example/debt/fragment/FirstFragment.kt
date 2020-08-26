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
import com.example.debt.activity.RwardRecordAddActivity
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_remake).setOnClickListener(this)

        btn_add.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.btn_remake -> {
                findNavController().navigate(R.id.action_FirstFragment_to_Reward_Remake_Fragment)
            }

            R.id.btn_add -> {
                var intent = Intent()
                context?.let {
                    intent.setClass(it, RwardRecordAddActivity::class.java)
                    startActivity(intent)
                }
            }

        }
    }
}