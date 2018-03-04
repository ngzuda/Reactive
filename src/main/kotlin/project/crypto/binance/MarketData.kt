package project.crypto.binance

import io.reactivex.Observable
import java.net.URL

class MarketData {
    val endpoint = "https://api.binance.com"
    val depthPath = "/api/v1/depth"
    val symbols = arrayListOf("ETHBTC")

    fun marketDataSource() {
        Observable.fromCallable { pollForMarketData() }
    }

    private fun pollForMarketData() {
        symbols.forEach {
            val url = URL("$endpoint$depthPath?symbol=$it")
            url.openConnection().getContent()
        }
    }
}
