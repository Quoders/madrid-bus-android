package com.quoders.android.app.madridbus.domain.lines

import javax.inject.Inject

class GetAllLinesInteractor @Inject constructor(private val linesRepository: ILinesRepository) {

    fun getAllLines(): List<Line> {
        val lineList = mutableListOf<Line>()


        return lineList
    }
}