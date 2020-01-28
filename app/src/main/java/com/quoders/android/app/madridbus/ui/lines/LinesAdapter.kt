package com.quoders.android.app.madridbus.ui.lines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quoders.android.app.madridbus.R
import com.quoders.android.app.madridbus.core.functional.observer
import kotlinx.android.synthetic.main.line_list_item.view.*

internal class LinesAdapter : RecyclerView.Adapter<LinesAdapter.MyViewHolder>() {

    var lines: List<LineViewData> by observer(listOf()) {
        notifyDataSetChanged()
    }

    private var clickListener: (LineViewData) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.line_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = lines.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lines[position], clickListener)
    }

    fun setClickListener(listener: (line: LineViewData) -> Unit) {
        this.clickListener = listener
    }

    internal inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: LineViewData, clickListener: (LineViewData) -> Unit) {
            itemView.textViewLineName.text = item.name
        }
    }
}