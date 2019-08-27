export class Food{
    name:string;
    category: string;
    imageUrl: string;
    ingredients: string;
    directions: string;

    constructor(name:string="", category:string="", imageUrl:string="", ingredients: string="", directions: string=""){
        this.name=name;
        this.category=category;
        this.imageUrl=imageUrl;
        this.ingredients=ingredients;
        this.directions=directions;
    }
}