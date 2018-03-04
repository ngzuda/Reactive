package project.crypto.binance.service

import io.reactivex.Observable
import project.crypto.binance.model.MarketData
import java.net.URL
import java.util.concurrent.TimeUnit

class MarketDataService {
    val endpoint = "https://api.binance.com"
    val depthPath = "/api/v1/depth"
    val symbols = arrayListOf("ETHBTC")

    fun marketDataSource(): Observable<MutableList<MarketData>>? {
        return Observable.fromCallable { pollForMarketData() }.repeatWhen { it.concatMap { Observable.timer(5, TimeUnit.SECONDS) } }
    }

    private fun pollForMarketData(): MutableList<MarketData> {
        val marketDataSnapshot = mutableListOf<MarketData>()
        symbols.forEach {
            val url = URL("$endpoint$depthPath?symbol=$it")
            val content = url.openConnection().content as MarketData
            marketDataSnapshot.add(content)
        }
        println(marketDataSnapshot)
        return marketDataSnapshot
    }
}
