import Five.News.DaggerDaggerComponent
import Five.News.Services.ManipulationService

fun main(args: Array<String>) {
    val d = DaggerDaggerComponent.create()
    var ms = ManipulationService(
        d.getEditor(),
        d.getAdder(),
        d.getRemover(),
        d.getSorter(),
        d.getSearcher(),
        d.getPrinter()
    )
}