package com.lgcinterview.letsgetcountries.ui.main.fragments.countrydetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.lgcinterview.letsgetcountries.R
import com.lgcinterview.letsgetcountries.data.models.Country
import com.lgcinterview.letsgetcountries.databinding.CountryDetailsFragmentBinding
import com.lgcinterview.letsgetcountries.di.kodeinViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein



class CountryDetailsFragment : Fragment(), KodeinAware {

    companion object {

        private const val COUNTRY_ENTITY = "country_entity"

        fun newInstance(country : Country) : CountryDetailsFragment {
            val args = Bundle()
            args.putSerializable(COUNTRY_ENTITY, country)

            val countryDetailsFragment = CountryDetailsFragment()
            countryDetailsFragment.arguments = args

            return countryDetailsFragment
        }
    }

    override val kodein by kodein()

    private val viewModel: CountryDetailsViewModel by kodeinViewModel()

    private lateinit var binding : CountryDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.country_details_fragment,
            container,
            false)

        binding.apply {
            lifecycleOwner = this@CountryDetailsFragment
        }

        binding.viewModel = viewModel

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.selectedCountry = arguments?.getSerializable(COUNTRY_ENTITY) as Country
    }

}