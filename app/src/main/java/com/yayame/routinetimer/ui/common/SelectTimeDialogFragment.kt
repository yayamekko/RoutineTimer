package com.yayame.routinetimer.ui.common

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import com.yayame.routinetimer.R

class SelectTimeDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_select_time_dialog, null, false)
        val minutesNumberPicker = view.findViewById<NumberPicker>(R.id.minutes_numberPicker)
        minutesNumberPicker.maxValue = 59
        minutesNumberPicker.minValue = 0
        val secondsNumberPicker = view.findViewById<NumberPicker>(R.id.seconds_numberPicker)
        secondsNumberPicker.maxValue = 59
        secondsNumberPicker.minValue = 0

        val dialog = AlertDialog.Builder(context).apply {
            setPositiveButton(
                "OK"
            ) { _, _ ->
                //TODO 時間設定
            }
            setNeutralButton("Cancel", null)
            setView(view)
        }
        return dialog.create()
    }

    companion object {
        fun newInstance() = SelectTimeDialogFragment()
    }
}