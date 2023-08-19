package com.example.simpleassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simpleassignment.model.Dogs


class ViewPagerAdapter(
    private val context: Context,
    private val imageList: List<Dogs>,
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_holder,parent,false)
        return ViewPagerHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val item = imageList[position]
        holder.bind(item,context)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    class ViewPagerHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        private val dogImage : ImageView = view.findViewById(R.id.allDogs)
        fun bind(item : Dogs,context: Context) {
          //  dogImage.setImageResource(getResources().getIdentifier(item.message,"drawable",getPackageName()));
            Glide.with(context)
                .load(item.message)
                .fitCenter()
                .into(dogImage)
        }
    }
}
