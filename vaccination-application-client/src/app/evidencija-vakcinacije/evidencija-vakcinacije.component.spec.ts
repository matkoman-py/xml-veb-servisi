import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EvidencijaVakcinacijeComponent } from './evidencija-vakcinacije.component';

describe('EvidencijaVakcinacijeComponent', () => {
  let component: EvidencijaVakcinacijeComponent;
  let fixture: ComponentFixture<EvidencijaVakcinacijeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EvidencijaVakcinacijeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EvidencijaVakcinacijeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
