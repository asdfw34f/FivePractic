package Five.News.Helper

import Five.News.Data.Rates
import javax.inject.Inject

class RatesPrinter @Inject constructor(){
    fun printRates(rates: Rates):String{
        var resultString = "| Name\t| Type of BroadCast\t| Access|\n"
        for (rate in rates.rates) {
            resultString += "${rate.name}\t${rate.type}\t${if (rate.access) "Yes" else "No"}\n"
        }
        return if( resultString == "| Name\t| Type of BroadCast\t| Access|\n") "the list is empty"
        else resultString
    }
}