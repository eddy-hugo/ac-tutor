import { Component, OnInit } from '@angular/core';
import {
  debounceTime, distinctUntilChanged, switchMap
} from 'rxjs/operators';
import { Observable, Subject } from 'rxjs';
import { Tutor } from '../tutor';
import { TutorService } from '../tutor.service';
@Component({
  selector: 'app-tutor-search',
  templateUrl: './tutor-search.component.html',
  styleUrls: ['./tutor-search.component.css']
})
export class TutorSearchComponent implements OnInit {
  tutors$: Observable<Tutor[]>;
  private searchTerms = new Subject<string>();
  constructor(private tutorService: TutorService) { }

  ngOnInit() {
    this.tutors$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),
 
      // ignore new term if same as previous term
      distinctUntilChanged(),
 
      // switch to new search observable each time the term changes
      switchMap((term: string) => this.tutorService.searchTutors(term)),
    );
  }

  search(term: string): void {
    this.searchTerms.next(term);
  }

}
