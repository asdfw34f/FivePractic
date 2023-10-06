package Five.News.Helper

import Five.News.Data.Rates
import javax.inject.Inject

class RateRemover @Inject constructor(){
    fun removeRate(rates: Rates, name:String): Rates {
        rates.rates.removeIf { it.name == name }
        return rates
    }
}