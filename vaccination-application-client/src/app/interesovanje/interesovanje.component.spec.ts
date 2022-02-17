import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InteresovanjeComponent } from './interesovanje.component';

describe('InteresovanjeComponent', () => {
  let component: InteresovanjeComponent;
  let fixture: ComponentFixture<InteresovanjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InteresovanjeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InteresovanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
