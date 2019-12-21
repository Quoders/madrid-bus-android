package com.quoders.android.app.madridbus.domain

import com.quoders.android.app.madridbus.domain.model.Line
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class GetAllLinesInteractor @Inject constructor(private val linesRepository: LinesRepository) {

    fun getAllLines(): List<Line> {
        val lineList = mutableListOf<Line>()

        return lineList
    }
}