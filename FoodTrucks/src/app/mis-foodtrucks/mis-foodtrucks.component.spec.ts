import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MisFoodtrucksComponent } from './mis-foodtrucks.component';

describe('MisFoodtrucksComponent', () => {
  let component: MisFoodtrucksComponent;
  let fixture: ComponentFixture<MisFoodtrucksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MisFoodtrucksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MisFoodtrucksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
