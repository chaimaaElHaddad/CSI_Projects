import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {MatTabsModule} from '@angular/material/tabs';
import {MatInputModule} from '@angular/material/input';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { BeneficiaryComponent } from './_dashboard/beneficiary/beneficiary.component';
import { CreateCvComponent } from './_create/create-cv/create-cv.component';
import { UpdateCvComponent } from './_update/update-cv/update-cv.component';
import { PlanTrainingComponent } from './plan-training/plan-training.component';
import { RegistrationTrainingComponent } from './registration-training/registration-training.component';
import { FormateurComponent } from './_dashboard/formateur/formateur.component';
import { CreateTrainingComponent } from './_create/create-training/create-training.component';
import { UpdateTrainingComponent } from './_update/update-training/update-training.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    BeneficiaryComponent,
    CreateCvComponent,
    UpdateCvComponent,
    PlanTrainingComponent,
    RegistrationTrainingComponent,
    FormateurComponent,
    CreateTrainingComponent,
    UpdateTrainingComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTabsModule,
    MatInputModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
