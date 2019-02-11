import {StockPrice} from "./StockPrice";

export interface StockPricePagination {
  stockPrices: Array<StockPrice>;
  length: number;
}
