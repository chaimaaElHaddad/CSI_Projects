import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { BeneficiaryComponent } from './_dashboard/beneficiary/beneficiary.component';
import { FormateurComponent } from './_dashboard/formateur/formateur.component';
import { RegistrationComponent } from './registration/registration.component';
import { RegistrationTrainingComponent } from './registration-training/registration-training.component';
import { PlanTrainingComponent } from './plan-training/plan-training.component';
import { CreateTrainingComponent } from './_create/create-training/create-training.component';
import { UpdateTrainingComponent } from './_update/update-training/update-training.component';
import { CreateCvComponent } from './_create/create-cv/create-cv.component';
import { UpdateCvComponent } from './_update/update-cv/update-cv.component';


const routes: Routes = [
  {path: '' ,redirectTo: 'login', pathMatch:'full'},
  {path: 'login' , component: LoginComponent},
  {path: 'registration' , component: RegistrationComponent},
  {path: 'beneficiary' , component: BeneficiaryComponent},
  {path: 'formateur' , component: FormateurComponent},
  {path: 'registrationTraining' , component: RegistrationTrainingComponent},
  {path: 'planTraining' , component: PlanTrainingComponent},
  {path: 'createTraining' , component: CreateTrainingComponent},
  {path: 'updateTraining' , component: UpdateTrainingComponent},
  {path: 'createCv' , component: CreateCvComponent},
  {path: 'updateCv' , component: UpdateCvComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
