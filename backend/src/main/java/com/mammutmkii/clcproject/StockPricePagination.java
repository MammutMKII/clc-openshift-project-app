package com.mammutmkii.clcproject;

import java.util.Collection;

public class StockPricePagination {
    private Collection<StockPrice> stockPrices;
    private Long length;

    public Collection<StockPrice> getStockPrices() {
        return stockPrices;
    }

    public void setStockPrices(Collection<StockPrice> stockPrices) {
        this.stockPrices = stockPrices;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }
}
