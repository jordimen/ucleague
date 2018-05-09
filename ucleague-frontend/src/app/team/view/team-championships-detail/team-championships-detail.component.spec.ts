import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamChampionshipsDetailComponent } from './team-championships-detail.component';

describe('TeamChampionshipsDetailComponent', () => {
  let component: TeamChampionshipsDetailComponent;
  let fixture: ComponentFixture<TeamChampionshipsDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamChampionshipsDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamChampionshipsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
