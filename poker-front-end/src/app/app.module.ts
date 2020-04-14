import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { PokerComponent } from './poker/poker.component';
import { PokerService } from './poker/poker.service';


@NgModule({
  declarations: [
    AppComponent,
    PokerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [PokerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
