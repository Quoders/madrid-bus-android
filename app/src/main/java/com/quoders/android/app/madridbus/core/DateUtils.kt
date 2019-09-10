package com.quoders.android.app.madridbus.core

import android.text.format.DateFormat
import java.util.*

fun getTodayInEmtServiceFormat(): String {
    return DateFormat.format("ddMMyyyy", Calendar.getInstance().time).toString()
}