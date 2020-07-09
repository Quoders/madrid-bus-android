package com.quoders.android.app.madridbus.domain.lines

class GetAllLinesInteractor constructor(private val linesRepository: ILinesRepository) {

    fun getAllLines(): List<Line> {
        val lineList = mutableListOf<Line>()


        return lineList
    }
}