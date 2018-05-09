import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamChampionshipsSelectorComponent } from './team-championships-selector.component';

describe('TeamChampionshipsSelectorComponent', () => {
  let component: TeamChampionshipsSelectorComponent;
  let fixture: ComponentFixture<TeamChampionshipsSelectorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamChampionshipsSelectorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamChampionshipsSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
