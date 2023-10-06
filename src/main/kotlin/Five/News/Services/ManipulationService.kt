package Five.News.Services

import Five.News.Data.Rate
import Five.News.Data.Rates
import Five.News.Helper.*
import Five.News.Types.BroadCast
import Five.News.Types.TypeEdit
import Five.News.Types.TypeSearch
import javax.inject.Inject

class ManipulationService @Inject constructor(
    override var editor: RateEditor,
    override var adder: RateAdder,
    override var remover: RateRemover,
    override var sorter: RatesSorter,
    override var searcher: RateSearcher,
    override var printer: RatesPrinter
) : IService {

    override fun print(rates: Rates) {
        println(printer.printRates(rates))
    }
    override fun search(rates: Rates, search:TypeSearch, name:String, vararg index: Int, type: BroadCast, access: Boolean): Rates {
            val res = when(search) {
            TypeSearch.Name -> {
                if (name.isNotBlank() && name != "")
                    searcher.searchRateName(rates, name)
                else null
            }

            TypeSearch.Access -> {
                searcher.searchRateAccess(rates, access)
            }

            TypeSearch.BroadCast -> {
                searcher.searchRateBradCast(rates, type)
            }

            TypeSearch.Index -> {

                searcher.searchRateIndex(rates, index.toList())
            }
        }


        return if (res != null) {
            res
        } else {
            println("Rate wasn't fund")
            rates
        }
    }
    override fun sort(rates: Rates, sort: TypeEdit): Rates {
            val res = when (sort){
            TypeEdit.Name -> {
                sorter.sortRateName(rates)
            }
            TypeEdit.Access -> {
                sorter.sortRateAccess(rates)
            }
            TypeEdit.BroadCast -> {
                sorter.sortRateBroadCast(rates)

            }
        }
        return res
    }
    override fun edit(rates: Rates, index:Int, edit: TypeEdit, newName:String, newBroadCast: BroadCast, newAccess:Boolean): Rates {
        val res: Rates? =  when (edit){
            TypeEdit.BroadCast ->{
                editor.editRateType(rates, index, newBroadCast)
            }
            TypeEdit.Access ->{
                editor.editRateAccess(rates, index, newAccess)
            }
            TypeEdit.Name -> {
                if (newName!="" && newName.isNotBlank())
                    editor.editRateName(rates, index, newName)
                else null
            }
        }
        return if (res != null) {
            res
        } else {
            println("Rate wasn't edit")
            rates
        }
    }
    override fun add(rates: Rates, name:String, type: BroadCast, access:Boolean): Rates {
        if (name != "" && name.isNotBlank()) {
            return adder.addRate(rates, Rate(name, type, access))
        }
        println("Rate wasn't add")
        return rates

    }
    override fun remove(rates: Rates, name: String): Rates {
        if (name != "" && name.isNotBlank()) {
            return remover.removeRate(rates, name)
        }
            println("Rate wasn't remove")
            return rates
    }
}