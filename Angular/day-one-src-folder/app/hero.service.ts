import { Injectable } from '@angular/core';
import { Hero } from './hero';

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  heroes: Array<Hero> = [
    new Hero(1, 'Spider-Man', 'https://cnet3.cbsistatic.com/img/Z9sw9A3lDMDh0W3KyAc7rScxOiA=/2019/03/26/13d0a566-7355-4381-be24-dee281227504/spider-man-far-from-home-promo-image-1.jpg', 80),
    new Hero(2, 'Goku', 'https://vignette.wikia.nocookie.net/vsbattles/images/5/56/Goku_%28Base%29.png/revision/latest?cb=20160315175220', 9000),
    new Hero(3, 'IronMan', 'https://images-na.ssl-images-amazon.com/images/I/61d6m8%2BIjTL._SX425_.jpg', 0),
    new Hero(4, 'Thor', 'https://upload.wikimedia.org/wikipedia/en/thumb/3/3c/Chris_Hemsworth_as_Thor.jpg/220px-Chris_Hemsworth_as_Thor.jpg', 100)
  ]

  constructor() { }
}
