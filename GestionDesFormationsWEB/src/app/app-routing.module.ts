import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FormateurComponent } from './_formateur/formateur/formateur.component';
import { RegistrationComponent } from './registration/registration.component';
import { CreateTrainingComponent } from './_formateur/create-training/create-training.component';
import { UpdateTrainingComponent } from './_formateur/update-training/update-training.component';
import { UpdateCvComponent } from './_cv/update-cv/update-cv.component';
import { BeneficiaryComponent } from './_beneficier/beneficiary/beneficiary.component';
import { CvDetailsComponent } from './_cv/cv-details/cv-details.component';
import { ProfileComponent } from './profile/profile.component';



const routes: Routes = [
  
  {path: '' ,redirectTo: 'gestionDeFormation/login', pathMatch:'full'},
  {path: 'gestionDeFormation/login' , component: LoginComponent},
  {path: 'registration' , component: RegistrationComponent},
  {path: 'beneficiaire' , component: BeneficiaryComponent},
  {path: 'formateur' , component: FormateurComponent},
  {path: 'createTraining' , component: CreateTrainingComponent},
  {path: 'updateTraining' , component: UpdateTrainingComponent},
  {path: 'updateCv' , component: UpdateCvComponent},
  {path: 'detailsCv' , component: CvDetailsComponent},
  {path: 'profile' , component: ProfileComponent},
  {path: 'beneficier' , component: BeneficiaryComponent},
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
