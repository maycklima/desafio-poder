import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
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
    AppRoutingModule,
    HttpClientModule    
  ],
  providers: [PokerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
