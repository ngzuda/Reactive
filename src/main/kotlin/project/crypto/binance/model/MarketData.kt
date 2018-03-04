package project.crypto.binance.model

data class MarketData(
        val lastUpdateId: Long,
        val bids: List<Price>,
        val asks: List<Price>
)


data class Price(
        val price: Double,
        val quantity: Double)
