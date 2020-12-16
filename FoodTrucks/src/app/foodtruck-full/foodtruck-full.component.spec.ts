import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodtruckFullComponent } from './foodtruck-full.component';

describe('FoodtruckFullComponent', () => {
  let component: FoodtruckFullComponent;
  let fixture: ComponentFixture<FoodtruckFullComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodtruckFullComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodtruckFullComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
