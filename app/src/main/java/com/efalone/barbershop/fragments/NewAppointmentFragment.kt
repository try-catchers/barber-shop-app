package com.efalone.barbershop.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.efalone.barbershop.R
import java.text.SimpleDateFormat

class NewAppointmentFragment : Fragment() {
    //TODO check issue on github for details

    lateinit var toolbarTile: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_appointment, container, false)
    }



    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val mButton = view?.findViewById<Button>(R.id.button_1)

        val startTime = "2022-02-1T09:00:00"
        val endTime = "2022-02-1T12:00:00"

        val mSimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val mStartTime = mSimpleDateFormat.parse(startTime)
        val mEndTime = mSimpleDateFormat.parse(endTime)

        mButton?.setOnClickListener {
            val mIntent = Intent(Intent.ACTION_EDIT)
            mIntent.type = "vnd.android.cursor.item/event"
            mIntent.putExtra("beginTime", mStartTime.time)
            mIntent.putExtra("time", true)
            mIntent.putExtra("rule", "FREQ=YEARLY")
            mIntent.putExtra("endTime", mEndTime.time)
            mIntent.putExtra("title", "Geeksforgeeks Event")
            startActivity(mIntent)
        }
    }
}