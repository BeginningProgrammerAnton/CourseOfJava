import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookAvailableComponent } from './book-available.component';

describe('BookAvailableComponent', () => {
  let component: BookAvailableComponent;
  let fixture: ComponentFixture<BookAvailableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookAvailableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookAvailableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
