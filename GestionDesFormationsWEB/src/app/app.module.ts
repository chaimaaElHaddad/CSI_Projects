import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';

import {MatCheckboxModule, MAT_CHECKBOX_CLICK_ACTION} from '@angular/material/checkbox';
import {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatTabsModule} from '@angular/material/tabs';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatDialogModule } from '@angular/material/dialog';
import {MatStepperModule} from '@angular/material/stepper';
import {MatTableModule} from '@angular/material/table';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { CreateCvComponent } from './_cv/create-cv/create-cv.component';
import { UpdateCvComponent } from './_cv/update-cv/update-cv.component';
import { FormateurComponent } from './_formateur/formateur/formateur.component';
import { CreateTrainingComponent } from './_formateur/create-training/create-training.component';
import { UpdateTrainingComponent } from './_formateur/update-training/update-training.component';
import { DetailsTrainingComponent } from './_formateur/details-training/details-training.component';
import { BeneficiaryComponent } from './_beneficier/beneficiary/beneficiary.component';
import { PlanTrainingComponent } from './_beneficier/plan-training/plan-training.component';

import { CvDetailsComponent } from './_cv/cv-details/cv-details.component';
import { ProfileComponent } from './profile/profile.component';
import { HeaderComponent } from './header/header.component';

import { HttpClientModule } from '@angular/common/http';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    BeneficiaryComponent,
    CreateCvComponent,
    UpdateCvComponent,
    FormateurComponent,
    CreateTrainingComponent,
    UpdateTrainingComponent,
    HeaderComponent,
    DetailsTrainingComponent,
    PlanTrainingComponent,
    CvDetailsComponent,
    ProfileComponent,
  
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTabsModule,
    MatInputModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatTooltipModule,
    MatIconModule ,
    MatTableModule,
    MatPaginatorModule,
    MatDialogModule,
    MatStepperModule,
    MatCheckboxModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
   
  ],
  providers: [
    {provide: MAT_CHECKBOX_CLICK_ACTION, useValue: 'check'}

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
