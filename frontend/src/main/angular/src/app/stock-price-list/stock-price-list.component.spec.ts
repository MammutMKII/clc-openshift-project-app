import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockPriceListComponent } from './stock-price-list.component';

describe('StockPriceListComponent', () => {
  let component: StockPriceListComponent;
  let fixture: ComponentFixture<StockPriceListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockPriceListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockPriceListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
