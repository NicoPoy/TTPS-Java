import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActFoodtruckComponent } from './act-foodtruck.component';

describe('ActFoodtruckComponent', () => {
  let component: ActFoodtruckComponent;
  let fixture: ComponentFixture<ActFoodtruckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActFoodtruckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActFoodtruckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
