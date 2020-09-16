package com.lgcinterview.letsgetcountries.ui.main.fragments.allcountries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lgcinterview.letsgetcountries.R
import com.lgcinterview.letsgetcountries.common.SealedResources
import com.lgcinterview.letsgetcountries.data.models.Country
import com.lgcinterview.letsgetcountries.databinding.AllCountriesFragmentBinding
import com.lgcinterview.letsgetcountries.di.kodeinViewModel
import com.lgcinterview.letsgetcountries.ui.main.fragments.countrydetails.CountryDetailsFragment
import com.lgcinterview.letsgetcountries.ui.main.replaceFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

class AllCountriesFragment : Fragment(), KodeinAware, IRecycleViewItemClicked {

    companion object {
        fun newInstance() =
            AllCountriesFragment()
    }

    override val kodein by kodein()
    private val viewModel: AllCountriesViewModel by kodeinViewModel()

    private lateinit var binding : AllCountriesFragmentBinding

    private val listAdapter : CountryListAdapter = CountryListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.all_countries_fragment,
            container,
            false)

        binding.viewModel = viewModel

        binding.apply {
            lifecycleOwner = this@AllCountriesFragment
        }

        binding.adapter = listAdapter

        binding.countriesRecyclerView.apply {
            layoutManager = object : LinearLayoutManager(context){
                override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                    lp?.width = width
                    return true
                }
            }
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.listOfAllCountries.observe(
            activity as AppCompatActivity,
            Observer { result ->
                when (result) {
                    is SealedResources.Success<*> -> {
                        listAdapter.submitList(result.data)
                    }
                }
            }
        )
    }

    override fun onRecyclerViewItemClicked(country: Country) {
        (activity as AppCompatActivity).replaceFragment(CountryDetailsFragment.newInstance(country))
    }

}