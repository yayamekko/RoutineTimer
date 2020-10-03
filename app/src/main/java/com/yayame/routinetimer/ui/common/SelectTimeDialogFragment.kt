package com.yayame.routinetimer.ui.common

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.yayame.routinetimer.R

class SelectTimeDialogFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        val dialog = TimePickerDialog(
            activity,
            this,
            0,
            0,
            true
        )

        val view = inflater.inflate(R.layout.fragment_select_time_dialog, null)
        val minutesNumberPicker = view.findViewById<NumberPicker>(R.id.minutes_numberPicker)
        minutesNumberPicker.maxValue = 59
        minutesNumberPicker.minValue = 0
        val secondsNumberPicker = view.findViewById<NumberPicker>(R.id.seconds_numberPicker)
        secondsNumberPicker.maxValue = 59
        secondsNumberPicker.minValue = 0
        dialog.setView(inflater.inflate(R.layout.fragment_select_time_dialog, null))
        return dialog
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        // Do something with the time chosen by the user
    }

    companion object {
        fun newInstance() = SelectTimeDialogFragment()
    }
}