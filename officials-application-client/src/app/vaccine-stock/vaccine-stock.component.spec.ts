import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccineStockComponent } from './vaccine-stock.component';

describe('VaccineStockComponent', () => {
  let component: VaccineStockComponent;
  let fixture: ComponentFixture<VaccineStockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccineStockComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccineStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
