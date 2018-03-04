package project.crypto.binance

import io.reactivex.rxkotlin.subscribeBy
import project.crypto.binance.service.MarketDataService

fun main(args: Array<String>) {
    val marketDataSource = MarketDataService()
    marketDataSource.marketDataSource()?.subscribeBy(
            onError = { println("ERROR! $it") },
            onComplete = { println("Completed") },
            onNext = { println("$it") }
    )


}