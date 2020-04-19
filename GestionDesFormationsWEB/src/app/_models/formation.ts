import { User } from './user';
import { Element } from './element';

export class Formation {

    id: number;
    nom : string;
    date : Date ;
    accueil : string;
    nombres_places: number;
    prix : number ;
    objectifs: string;
    prerequis: string;
    description: string;

    formateur: User;
    elementDeFormations: Element[] = [];
}