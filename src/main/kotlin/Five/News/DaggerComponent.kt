package Five.News

import Five.News.Helper.*
import Five.News.Services.ManipulationService
import dagger.Component

@Component
interface DaggerComponent {
//    fun getAdder(): RateAdder
//    fun getEditor(): RateEditor
//    fun getRemover(): RateRemover
//    fun getSearcher(): RateSearcher
//    fun getPrinter(): RatesPrinter
//    fun getSorter(): RatesSorter
    fun getManipulationService():ManipulationService
}