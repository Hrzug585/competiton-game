import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'competition-game';
  url = "http://localhost:8080/v1/challenge"

  profileForm = new FormGroup({
    name: new FormControl(''),
    solution: new FormControl(''),
    taskName: new FormControl(''),
    taskId: new FormControl(''),
  });


  constructor(private http: HttpClient) { }

  onSubmit() {
    const headers = { 'content-type': 'application/json'};

    const body=JSON.stringify(this.profileForm.value);
    this.http.post<Submition>(this.url, body, { headers }).subscribe(data => {
    console.log(data);
    })
  }

  
 
}

interface Submition {
  submitter: string;
  script: string;
  taskName: string;
  taskId: number;
}
