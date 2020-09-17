package com.lgcinterview.letsgetcountries.common

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.lgcinterview.letsgetcountries.R

class DataBindingHelper {

    companion object{

        @JvmStatic
        @BindingAdapter(value = ["setRvAdapter"])
        fun RecyclerView.setRvAdapter(adapter: RecyclerView.Adapter<*>){
            this.run {
                this.adapter = adapter
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["setHeaderMsg"])
        fun TextView.setHeaderMsg(msg : String?){
            this.text = msg
        }

        @JvmStatic
        @BindingAdapter(value = ["setRecyclerViewVisibilityCase"])
        fun RecyclerView.setRecyclerViewVisibilityCase(countriesResultVisibilityCase: CountriesResultVisibilityCase?){
            countriesResultVisibilityCase.let {
                this.visibility = when(it?.visibilityCase){
                    CountriesResultVisibilityCase.VisibilityCase.DATA_LOADED -> View.VISIBLE
                    else -> View.INVISIBLE
                }
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["setVisibilityCase"])
        fun LottieAnimationView.setVisibilityCase(countriesResultVisibilityCase: CountriesResultVisibilityCase?){
            countriesResultVisibilityCase.let {
                when(this.id){
                    R.id.loading_lottie_animation_view -> {
                        this.visibility = when(it?.visibilityCase){
                            CountriesResultVisibilityCase.VisibilityCase.LOADING_DATA -> View.VISIBLE
                            else -> View.INVISIBLE
                        }
                        if (this.visibility == View.VISIBLE){
                            playAnimation()
                        }
                    }
                    R.id.error_lottie_animation_view -> {
                        this.visibility = when(it?.visibilityCase){
                            CountriesResultVisibilityCase.VisibilityCase.NO_DATA -> View.VISIBLE
                            else -> View.INVISIBLE
                        }
                        if (this.visibility == View.VISIBLE){
                            playAnimation()
                        }
                    }
                }
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["setVisibilityCase"])
        fun TextView.setVisibilityCase(countriesResultVisibilityCase: CountriesResultVisibilityCase?){
            countriesResultVisibilityCase.let {
                this.visibility = when(it?.visibilityCase){
                    CountriesResultVisibilityCase.VisibilityCase.DATA_LOADED -> View.INVISIBLE
                    else -> View.VISIBLE
                }
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["setVisibilityCase"])
        fun ConstraintLayout.setVisibilityCase(countriesResultVisibilityCase: CountriesResultVisibilityCase?){
            countriesResultVisibilityCase.let {
                this.visibility = when(it?.visibilityCase){
                    CountriesResultVisibilityCase.VisibilityCase.DATA_LOADED -> View.VISIBLE
                    else -> View.INVISIBLE
                }
            }
        }

    }
}