package com.android.layout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.android.layout.CrimeActivity
import com.android.layout.CrimeListFragment
import com.android.layout.R
import com.android.layout.bean.Crime

class CrimeAdapter(
    private val crimeList: List<Crime>,
    private val callbacks: CrimeListFragment.Callbacks?
) :
    RecyclerView.Adapter<CrimeAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTitle)
        val id: TextView = view.findViewById(R.id.tvId)
        val date: TextView = view.findViewById(R.id.tvDate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.crime_item, parent, false)
        val holder = ViewHolder(view)

        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
//            CrimeActivity.actionStart(parent.context, crimeList[position].id)
            Toast.makeText(
                parent.context,
                "${crimeList[position].title} clicked",
                Toast.LENGTH_SHORT
            ).show()

            callbacks?.onCrimeSelected(crimeList[position].id)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crime = crimeList[position]
        holder.title.text = crime.title
        holder.date.text = crime.date.toString()
        holder.id.text = crime.id.toString()
    }

    override fun getItemCount(): Int = crimeList.size
}
