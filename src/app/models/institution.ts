export class Institution {
    constructor(
        public id: string,
        public name: string,
        public contactNumber: string,
        public description: string,
        public address: string,
        public emailid: string,
        public websiteLink: string,
        public imageLink1: string,
        public imageLink2: string,
        public imageLink3: string,
        public type: string,
        public courses: string
    ){}
}