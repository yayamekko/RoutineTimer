package model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class RoutineTaskItem(
    var position: Int,
    var task: String,
    var hourOfDay: Int,
    var minute: Int
) : Parcelable
