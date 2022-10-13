import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerategraphicDialogComponent } from './generategraphic-dialog.component';

describe('GenerategraphicDialogComponent', () => {
  let component: GenerategraphicDialogComponent;
  let fixture: ComponentFixture<GenerategraphicDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenerategraphicDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GenerategraphicDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
