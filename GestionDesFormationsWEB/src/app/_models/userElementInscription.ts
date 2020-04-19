import { User } from './user';
import { Element } from './element';
import { Evaluation } from './evaluation';

export class UserElementInscription{
    id;
    beneficiaire: User;
    element: Element;

    email: string;
    phone: string;
    localisation: string;
    evaluation: Evaluation;
    dateInscription;

}