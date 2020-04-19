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
import { CvFormateurComponent } from './_beneficier/cv-formateur/cv-formateur.component';
import { EvaluationFormationComponent } from './_beneficier/evaluation-formation/evaluation-formation.component';
import { SocialLoginModule,GoogleLoginProvider, AuthServiceConfig, FacebookLoginProvider } from 'angularx-social-login';
import {MatExpansionModule} from '@angular/material/expansion';






const config = new AuthServiceConfig([
  {
    id: FacebookLoginProvider.PROVIDER_ID,
    provider: new FacebookLoginProvider('217776902659926')
  },
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider('644975908506-elijbc79q1ka1iadrmsi3gvo8tk3qrcn.apps.googleusercontent.com')
  }
]);
export function provideConfig() {
  return config;
}




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    BeneficiaryComponent,
    UpdateCvComponent,
    FormateurComponent,
    CreateTrainingComponent,
    UpdateTrainingComponent,
    HeaderComponent,
    DetailsTrainingComponent,
    PlanTrainingComponent,
    CvDetailsComponent,
    ProfileComponent,
    CvFormateurComponent,
    EvaluationFormationComponent,
  
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
    HttpClientModule,
    SocialLoginModule,
    MatExpansionModule
   
  ],
  exports: [
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
    HttpClientModule,
    MatExpansionModule
  ],
  providers: [
    {provide: MAT_CHECKBOX_CLICK_ACTION, useValue: 'check'},
    ,
    {
      provide: AuthServiceConfig,
      useFactory: provideConfig
    }

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
