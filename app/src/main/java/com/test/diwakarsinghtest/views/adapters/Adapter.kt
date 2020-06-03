package com.test.diwakarsinghtest.view.adapters

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.test.diwakarsinghtest.R
import com.test.diwakarsinghtest.pojo.Model
import com.test.diwakarsinghtest.views.MainActivity


class Adapter(
    private val list: List<Model>,
    private val context: Context
) :
    RecyclerView.Adapter<Adapter.RecViewHolder>() {

    private var mExpandedPosition = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_parent, parent, false)
        return RecViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        val Model = list!![position]
        Model.expanded = position == mExpandedPosition
        holder.bind(Model)
        holder.itemView.setOnClickListener {
            mExpandedPosition = if (Model.expanded) -1 else position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        Log.e("list",""+list.size)
        return list?.size ?: 0
    }

    inner class RecViewHolder(itemView: View) : ViewHolder(itemView) {
        private val name: TextView
        private val description: TextView
        private val license: TextView
        private val issue_counts: TextView
        private val admindot: ImageView
        private val pushdot: ImageView
        private val pulldot: ImageView
        private val subItem: View
        private val seperator: View

        fun bind(Model: Model) {
            subItem.visibility = if (Model.expanded) View.VISIBLE else View.GONE
            seperator.visibility = if (Model.expanded) View.GONE else View.VISIBLE
            name.text = Model.name
            description.text = Model.description
            license.text = "License: "+Model.license?.name
            issue_counts.text = Model.open_issues_count

            if (Model.permissions?.admin.equals("false")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    admindot.setColorFilter(context.getColor(R.color.red))
                }
                else{
                    admindot.setColorFilter(Color.RED)
                }
            }
            if (Model.permissions?.push.equals("false")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    pushdot.setColorFilter(context.getColor(R.color.red))
                }
                else{
                    pushdot.setColorFilter(Color.RED)
                }
            }
            if (Model.permissions?.pull.equals("false")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    pulldot.setColorFilter(context.getColor(R.color.red))
                }
                else{
                    pulldot.setColorFilter(Color.RED)
                }
            }

        }

        init {
            name = itemView.findViewById(R.id.name)
            description = itemView.findViewById(R.id.description)
            license = itemView.findViewById(R.id.license)
            admindot = itemView.findViewById(R.id.admindot)
            pushdot = itemView.findViewById(R.id.pushdot)
            pulldot = itemView.findViewById(R.id.pulldot)
            issue_counts = itemView.findViewById(R.id.issue_counts)
            subItem = itemView.findViewById(R.id.child)
            seperator = itemView.findViewById(R.id.seperator)
        }
    }



}