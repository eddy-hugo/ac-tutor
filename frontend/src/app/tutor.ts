import { Subject } from './subject'
import { Datetime } from './datetime'

export class Tutor {
    id: number;
    userName: string;
    firstName: string;
    lastName: string;
    email: string;
    phone: string;
    subjects: Subject[];
    availableTime: Datetime[]

  }