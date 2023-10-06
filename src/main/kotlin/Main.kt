import Five.News.DaggerDaggerComponent
import Five.News.Services.ManipulationService

fun main(args: Array<String>) {
    val d = DaggerDaggerComponent.builder().build()
    val manipulationService = d.getManipulationService()

}