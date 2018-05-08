import { Country } from '../common-components/country-selector/country';

export class Team {
    id: number;
    name: string;
    country: Country;
    rival: number;
    logo: number;
}

export class TeamInput {
    id: number;
    name: string;
    countryCode: string;
    rivalId: number;
}
