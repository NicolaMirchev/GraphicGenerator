import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowGraphicComponent } from './show-graphic.component';

describe('ShowGraphicComponent', () => {
  let component: ShowGraphicComponent;
  let fixture: ComponentFixture<ShowGraphicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowGraphicComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowGraphicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
