import { Component, OnInit } from '@angular/core';
import { StockPriceService } from '../shared/stock-price/stock-price.service';
import {PageEvent} from "@angular/material";

@Component({
  selector: 'app-stock-price-list',
  templateUrl: './stock-price-list.component.html',
  styleUrls: ['./stock-price-list.component.css']
})
export class StockPriceListComponent implements OnInit {
  symbols: Array<any>;
  currentSymbol: any;

  length: any;
  pageSize: any;
  pageSizeOptions = [5, 10, 20, 100];

  stockPrices: Array<any>;

  pageEvent: PageEvent;

  constructor(private stockPriceService: StockPriceService) { }

  ngOnInit() {
    this.pageSize = this.pageSizeOptions[0];
    this.updateSymbols();
  }

  updateSymbols() {
    this.stockPriceService.getSymbols().subscribe(symbols => {
      console.log(symbols);
      this.symbols = symbols;
    });
  }

  updateStockPrices(symbol: any, limit: any, offset:any) {
    this.stockPriceService.getStockPricesPagination(symbol, limit, offset).subscribe(stockPricePagination => {
      console.log(stockPricePagination);
      this.length = stockPricePagination.length;
      this.stockPrices = stockPricePagination.stockPrices;
    })
  }

  goToPage(event: PageEvent) {
    this.pageEvent = event;
    console.log(event);
    this.updateStockPrices(this.currentSymbol, event.pageSize, event.pageIndex*event.pageSize);
  }
}
