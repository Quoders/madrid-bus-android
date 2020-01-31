package com.quoders.android.app.madridbus.ui.lines

import android.os.Bundle
import androidx.navigation.NavDirections
import com.quoders.android.app.madridbus.R

class LinesFragmentDirections private constructor() {
    private data class ActionLineListToLineDetail(
        val lineNumber: String,
        val lineName: String
    ) : NavDirections {
        override fun getActionId(): Int = R.id.action_to_livenessEducationalGuidelineFragment

        override fun getArguments(): Bundle {
            val result = Bundle()
            result.putString("lineName", this.lineName)
            result.putString("lineNumber", this.lineNumber)
            return result
        }
    }

    companion object {
        fun actionAlbumListToAlbumDetail(
            lineName: String,
            lineNumber: String
        ): NavDirections = ActionLineListToLineDetail(lineName, lineNumber)
    }
}