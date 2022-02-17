import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZeleniSertifikatComponent } from './zeleni-sertifikat.component';

describe('ZeleniSertifikatComponent', () => {
  let component: ZeleniSertifikatComponent;
  let fixture: ComponentFixture<ZeleniSertifikatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZeleniSertifikatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZeleniSertifikatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
