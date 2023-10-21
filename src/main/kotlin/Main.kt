import Five.News.DaggerDaggerComponent
import Five.News.Data.Rate
import Five.News.Data.Rates
import Five.News.Types.BroadCast
import Five.News.Types.TypeEdit
import Five.News.Types.TypeSearch

fun main() {
    val d = DaggerDaggerComponent.builder().build()
    val m = d.getManipulationService()

    val rate1 = Rate("MTS RUS", BroadCast.HD, false)
    val rate2 = Rate("Operator", BroadCast.HD, true)
    val rate3 = Rate("Megafone", BroadCast.Normal, false)
    val rate4 = Rate("Three Colors", BroadCast.HD, false)
    //var rate5: Rate = Rate("BeeLine", BroadCast.Normal, true)

    var rates = Rates(mutableListOf(rate1, rate2, rate3, rate4))

    m.print(rates)

    rates = m.add(rates,"BeeLine", BroadCast.Normal, true)
    m.print(rates)

    rates = m.remove(rates, "Megafone")
    m.print(rates)

    val r = m.search(rates, TypeSearch.BroadCast, type = BroadCast.Normal)
    m.print(r)

    rates = m.edit(rates,1, TypeEdit.Name, "MTS Line", BroadCast.HD, false)
    m.print(rates)


}