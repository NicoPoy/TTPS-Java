import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodtruckThumbComponent } from './foodtruck-thumb.component';

describe('FoodtruckThumbComponent', () => {
  let component: FoodtruckThumbComponent;
  let fixture: ComponentFixture<FoodtruckThumbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodtruckThumbComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodtruckThumbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
