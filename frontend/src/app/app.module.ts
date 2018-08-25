import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler,NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { TutorsComponent } from './tutors/tutors.component';
import { FormsModule } from '@angular/forms';
import { TutorDetailComponent } from './tutor-detail/tutor-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { AppRoutingModule } from './/app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TutorSearchComponent } from './tutor-search/tutor-search.component'; 
import { TutorService } from './tutor.service';

@NgModule({
  declarations: [ 
    AppComponent,
    TutorsComponent,
    TutorDetailComponent,
    MessagesComponent,
    DashboardComponent,
    TutorSearchComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [TutorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
