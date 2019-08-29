export class Recipe {
    name:string
    category:string
    picture:any
    ingredients:string
    directions:string

    constructor(name:string = '', category:string = '', picture:any = '', ingredients:string = '', directions:string = '' ){
        this.name = name
        this.category = category
        this.picture = picture
        this.ingredients = ingredients
        this.directions = directions
    }
}
