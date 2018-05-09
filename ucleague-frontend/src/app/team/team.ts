import { Country } from '../common/country';

export class Team {
    id: number;
    name: string;
    country: Country;
    rival: Team;
    logo: number;
    championships: Championship[];
}

export class Championship {
    year: number;

    constructor(year: number) {
        this.year = year;
    }
}

export class TeamInput {
    id: number;
    name: string;
    countryCode: string;
    rivalId: number;
}
