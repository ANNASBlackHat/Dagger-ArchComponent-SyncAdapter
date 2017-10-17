package annasblackhat.com.daggerarchcomponentsyncadapter.view


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import annasblackhat.com.daggerarchcomponentsyncadapter.R
import annasblackhat.com.daggerarchcomponentsyncadapter.databinding.FragmentForecastHomeBinding
import annasblackhat.com.daggerarchcomponentsyncadapter.viewmodel.WeatherViewModel


/**
 * A simple [Fragment] subclass.
 */
class ForecastHomeFragment : BaseFragment<WeatherViewModel, FragmentForecastHomeBinding>() {

    override val layoutRes = R.layout.fragment_forecast_home
    override fun getViewModel() = WeatherViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = super.onCreateView(inflater, container, savedInstanceState)

        viewModel.getWeather()
                .observe(this, Observer { item ->
                    println("xxx data ")
                    println(item?.data)
                })

        return v
    }

}
