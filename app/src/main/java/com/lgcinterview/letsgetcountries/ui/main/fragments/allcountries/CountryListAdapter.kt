package com.lgcinterview.letsgetcountries.ui.main.fragments.allcountries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lgcinterview.letsgetcountries.data.models.Country
import com.lgcinterview.letsgetcountries.databinding.RvItemCountryBinding

class CountryListAdapter( private val iRecycleViewItemClicked: IRecycleViewItemClicked) :
    ListAdapter<Country, CountryListAdapter.CountryViewHolder>(Companion){

    companion object: DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean =
            oldItem.name == newItem.name
    }

    class CountryViewHolder(val binding : RvItemCountryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindInterface(country: Country,
                          recyclerViewItemClickListener: IRecycleViewItemClicked){
            itemView.setOnClickListener {
                recyclerViewItemClickListener.onRecyclerViewItemClicked(country)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemCountryBinding.inflate(layoutInflater)

        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentCountry: Country = getItem(position)
        holder.binding.country = currentCountry
        holder.binding.executePendingBindings()

        holder.bindInterface(currentCountry, iRecycleViewItemClicked)
    }
}