import { Component, OnInit,Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { TutorService }  from '../tutor.service';
import { Tutor } from '../tutor';

@Component({
  selector: 'app-tutor-detail',
  templateUrl: './tutor-detail.component.html',
  styleUrls: ['./tutor-detail.component.css']
})
export class TutorDetailComponent implements OnInit {

  @Input() tutor: Tutor;
  constructor(
    private route: ActivatedRoute,
    private tutorService: TutorService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getTutor();
  }

  getTutor(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.tutorService.getTutor(id).subscribe(tutor => this.tutor = tutor);
 }

 goBack(): void {
  this.location.back();
}

}
