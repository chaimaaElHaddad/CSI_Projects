import { User } from './user';
import { Element } from './element';
import { Evaluation } from './evaluation';
import { UserElementInscriptionId } from './userElementInscriptionId';
import { Localisation } from './localisation';

export class UserElementInscription{
    id: UserElementInscriptionId;
    beneficiaire: User;
    element: Element;

    email: string;
    phone: string;
    localisation: Localisation;
    evaluation: Evaluation;
    dateInscription: Date;

}