package Five.News.Services

import Five.News.Data.Rates
import Five.News.Helper.*
import Five.News.Types.BroadCast
import Five.News.Types.TypeEdit
import Five.News.Types.TypeSearch

interface IService {
    var editor: RateEditor
    var adder: RateAdder
    var remover: RateRemover
    var sorter: RatesSorter
    var searcher: RateSearcher
    var printer: RatesPrinter

    fun print(rates: Rates)
    fun add(rates: Rates, name: String, type: BroadCast, access: Boolean): Rates
    fun remove(rates: Rates, name: String): Rates
    fun edit(
        rates: Rates,
        index: Int,
        edit: TypeEdit,
        newName: String = "",
        newBroadCast: BroadCast = BroadCast.HD,
        newAccess: Boolean = false
    ): Rates

    fun sort(rates: Rates, sort: TypeEdit): Rates
    fun search(
        rates: Rates,
        search: TypeSearch,
        name: String= "",
        index: Int = 1,
        type: BroadCast=BroadCast.Normal,
        access: Boolean= false
    ): Rates
}