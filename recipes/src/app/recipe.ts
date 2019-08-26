export class Recipe {
    name: string
    category: string
    pictureUrl: string
    ingredients: Array<string>
    directions: string

    constructor(name: string, category: string, pictureUrl: string, ingredients: Array<string>, directions: string)
    {
        this.name = name
        this.category = category
        this.pictureUrl = pictureUrl
        this.ingredients = ingredients
        this.directions = directions
    }
}
