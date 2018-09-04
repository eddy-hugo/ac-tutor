import { Component, OnInit } from '@angular/core';
import { Tutor } from '../tutor';
import { TutorService } from '../tutor.service';

@Component({
  selector: 'app-tutors',
  templateUrl: './tutors.component.html',
  styleUrls: ['./tutors.component.css']
})
export class TutorsComponent implements OnInit {
  //tutors = TUTORS;
  tutors: Tutor[];
 // selectedTutor: Tutor;
  constructor(private tutorService: TutorService) { 
  }

  ngOnInit() {
    this.getTutors()
  }

  getTutors(): void {
     this.tutorService.getTutors().subscribe(tutors => this.tutors = tutors);
  }


  delete(tutor: Tutor): void {
    this.tutors = this.tutors.filter(h => h !== tutor);
    this.tutorService.deleteTutor(tutor).subscribe();
  }

 // onSelect(tutor: Tutor): void {
 //   this.selectedTutor = tutor;
 // }

}
