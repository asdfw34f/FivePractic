package Five.News.Helper

import Five.News.Data.Rate
import Five.News.Data.Rates
import Five.News.Types.BroadCast
import javax.inject.Inject

class RateSearcher @Inject constructor(){
    fun searchRateName(rates: Rates, par: String): Rates {
        return Rates(rates.rates.filter { it.name == par }.toMutableList())
    }
    fun searchRateIndex(rates: Rates, par:List<Int>): Rates?{
        val res:MutableList<Rate> = mutableListOf()

            try {
                for (i in par) {
                    res.add(rates.rates[i])
                }
            }catch (i:IndexOutOfBoundsException){
                return null
            }
        return if (res.isNotEmpty())
            Rates(res)
        else null

    }
    fun searchRateAccess(rates: Rates, par:Boolean): Rates {
        return Rates(rates.rates.filter { it.access == par }.toMutableList())

    }
    fun searchRateBradCast(rates: Rates, par: BroadCast): Rates {
        return Rates(rates.rates.filter { it.type == par }.toMutableList())
    }
}


