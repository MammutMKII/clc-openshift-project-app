import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class StockPriceService {

  constructor(private http: HttpClient) {
  }

  getSymbols(): Observable<any> {
    return this.http.get('symbols');
  }

  getStockPrices(symbol: string): Observable<any> {
    return this.http.get('stockPrices/'+symbol);
  }

  getStockPricesPagination(symbol: string, limit: number, offset: number): Observable<any> {
    return this.http.get('stockPrices/'+symbol+'/limit/'+limit+'/offset/'+offset);
  }
}
