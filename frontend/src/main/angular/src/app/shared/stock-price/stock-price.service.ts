import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {map} from "rxjs/operators";
import {StockPrice} from "../../dto/StockPrice";
import {StockPricePagination} from "../../dto/StockPricePagination";

@Injectable({providedIn: 'root'})
export class StockPriceService {

  constructor(private http: HttpClient) {
  }

  getSymbols(): Observable<Array<string>> {
    return this.http.get('symbols').pipe(map((value, index) => {
      return value as Array<string>;
    }));
  }

  getStockPrices(symbol: string): Observable<Array<StockPrice>> {
    return this.http.get('stockPrices/'+symbol).pipe(map((value, index) => {
      let result = value as Array<StockPrice>;
      result.forEach(this.convertStockPrice);
      return result;
    }));
  }

  getStockPricesPagination(symbol: string, limit: number, offset: number): Observable<StockPricePagination> {
    return this.http.get('stockPrices/'+symbol+'/limit/'+limit+'/offset/'+offset)
      .pipe<StockPricePagination>(map((value, index) => {
        let result = value as StockPricePagination;
        result.stockPrices.forEach(this.convertStockPrice);
        return result;
    }));
  }

  convertStockPrice(stockPrice: StockPrice) {
    stockPrice.time = new Date(stockPrice.time);
  }
}
