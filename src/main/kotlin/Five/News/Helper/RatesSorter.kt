package Five.News.Helper

import Five.News.Data.Rates
import javax.inject.Inject

class RatesSorter @Inject constructor(){
    fun sortRateName(rates: Rates): Rates {
        rates.rates.sortBy { it.name }
        return rates
    }

    fun sortRateBroadCast(rates: Rates): Rates {
        rates.rates.sortBy { it.type }
        return rates
    }

    fun sortRateAccess(rates: Rates): Rates {
        rates.rates.sortBy { it.access }
        return rates
    }
}