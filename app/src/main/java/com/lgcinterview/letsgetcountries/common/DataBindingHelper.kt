package com.lgcinterview.letsgetcountries.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

class DataBindingHelper {

    companion object{

        @JvmStatic
        @BindingAdapter(value = ["setRvAdapter"])
        fun RecyclerView.setRvAdapter(adapter: RecyclerView.Adapter<*>){
            this.run {
                this.adapter = adapter
            }
        }
    }
}