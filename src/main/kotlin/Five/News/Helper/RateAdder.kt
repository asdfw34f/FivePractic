package Five.News.Helper

import Five.News.Data.Rate
import Five.News.Data.Rates
import javax.inject.Inject

class RateAdder @Inject constructor() {
    fun addRate(rates: Rates, rate: Rate): Rates {
        rates.rates.add(rate)
        return rates
    }
}