package com.mammutmkii.clcproject;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class StockPriceController {
    private RedisTemplate<String, StockPrice> template;

    public StockPriceController(RedisTemplate<String, StockPrice> template) {
        this.template = template;
    }

    @GetMapping("/symbols") //fix openshift access
    @ResponseBody
    public Collection<String> getSymbols() {
        return template.keys("*");
    }

    @GetMapping("/stockPrices/{symbol}")
    @ResponseBody
    public Collection<StockPrice> getStockPrices(@PathVariable("symbol") String symbol) {
        return template.opsForZSet().range(symbol, 0, -1);
    }

    @GetMapping("/stockPrices/{symbol}/limit/{limit}/offset/{offset}")
    @ResponseBody
    public StockPricePagination getStockPrices(@PathVariable("symbol") String symbol,
                                                 @PathVariable("limit") int limit,
                                                 @PathVariable("offset") int offset) {
        StockPricePagination result = new StockPricePagination();
        result.setLength(template.opsForZSet().size(symbol));
        result.setStockPrices(template.opsForZSet().range(symbol, offset, offset+limit-1));
        return result;
    }
}