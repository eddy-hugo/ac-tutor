import { Component, OnInit } from '@angular/core';
import { Tutor } from '../tutor';
import { TutorService } from '../tutor.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  tutors: Tutor[] = [];

  constructor(private tutorService: TutorService) { }

  ngOnInit() {
    this.getTutors()
  }
  getTutors(): void {
    this.tutorService.getTutors()
      .subscribe(tutors => this.tutors = tutors.slice(1, 5));
  }
}
