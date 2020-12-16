import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DelFoodtruckComponent } from './del-foodtruck.component';

describe('DelFoodtruckComponent', () => {
  let component: DelFoodtruckComponent;
  let fixture: ComponentFixture<DelFoodtruckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DelFoodtruckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DelFoodtruckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
