import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TutorsComponent } from './tutors/tutors.component';
import { DashboardComponent }   from './dashboard/dashboard.component';
import { TutorDetailComponent }  from './tutor-detail/tutor-detail.component';


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'tutors', component: TutorsComponent },
  { path: 'detail/:id', component: TutorDetailComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]

})
export class AppRoutingModule { 

}

