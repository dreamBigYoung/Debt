package com.example.debt.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.debt.R
import com.example.debt.application.MyApplication
import com.example.debt.entity.DaoSession
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.activity_add_reward_record.*
import java.util.*

class RwardRecordAddActivity : AppCompatActivity(), View.OnClickListener,
    DatePickerDialog.OnDateSetListener {
    lateinit var dpd: DatePickerDialog

    lateinit var daoSession: DaoSession

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_reward_record)
        val now: Calendar = Calendar.getInstance()
        dpd =
            DatePickerDialog.newInstance(
                this,
                now[Calendar.YEAR],  // Initial year selection
                now[Calendar.MONTH],  // Initial month selection
                now[Calendar.DAY_OF_MONTH] // Inital day selection
            )
        dpd.setVersion(DatePickerDialog.Version.VERSION_2);

        record_date.setOnClickListener(this)
        record_date.onFocusChangeListener = View.OnFocusChangeListener { view, b ->
            if (b == true) {
                if (dpd.isAdded == false)
                    dpd.show(getSupportFragmentManager(), "Datepickerdialog");
            }
        }

        //init database
        daoSession = (application as MyApplication).getDaoSession()
        val rewardRecordDaoRx = daoSession.rewardRecordDao.rx()

    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.record_date -> {
                if (dpd.isAdded == false)
                    dpd.show(getSupportFragmentManager(), "Datepickerdialog");

            }
            R.id.add_record -> {


            }
        }

    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        record_date.setText(" ${year}/ ${monthOfYear + 1} / ${dayOfMonth}")

    }
}