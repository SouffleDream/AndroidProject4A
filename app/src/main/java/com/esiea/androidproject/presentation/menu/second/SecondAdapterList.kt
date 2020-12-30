package com.esiea.androidproject.presentation.menu.second

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.esiea.androidproject.R
import com.esiea.androidproject.data.local.models.AndroidModel

class SecondAdapterList (
    private var mContext: Context,
    private var resources: Int,
    private var items: List<AndroidModel>
) : ArrayAdapter<AndroidModel>(mContext, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val rowView = layoutInflater.inflate(resources, parent, false)

        val imageView = rowView.findViewById(R.id.image) as ImageView
        val versionTextView = rowView.findViewById(R.id.title) as TextView
        val dateTextView = rowView.findViewById(R.id.description) as TextView

        val getItemPosition: AndroidModel = items[position]
        imageView.setImageResource(getItemPosition.img)
        versionTextView.text = getItemPosition.version
        dateTextView.text = getItemPosition.date

        return rowView
    }
}