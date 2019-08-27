import { Injectable } from '@angular/core';
import { Food } from './Food';

@Injectable({
  providedIn: 'root'
})
export class FoodServiceService {

  foods:Array<Food>=[
    new Food("Burger", "Entree", "https://www.tasteofhome.com/wp-content/uploads/2018/01/Scrum-Delicious-Burgers_EXPS_CHMZ19_824_B10_30_2b.jpg", "Buns, Beef Patty, Cheese (Recommended), Bacon (Recommended)","Prepare ingreidients. Light grill (don't blow up or ignite self), and wait for grill to heat up. Grill beef patty to desired preparedness. Throw buns on grill shortly to toast. Put patty and all additional toppings between the buns. Eat"),
    new Food("Steak", "Entree", "https://www.omahasteaks.com/blog/wp-content/uploads/2014/09/Grilling-Flat-Irons-BP.jpg", "Steak","Prepare ingreidients. Light grill (don't blow up or ignite self), and wait for grill to heat up. Grill steak to desired preparedness (remember the palm rule). Eat"),
    new Food("Wedge Salad", "Salad", "https://stripedspatula.com/wp-content/uploads/2019/02/classic-wedge-salad-2.jpg", "Iceberg Lettuce, Dressing, Bacon (Reccomended), Blue Cheese (Reccomended)","Prepare ingreidients. Cut head of lettuce into quarters. Throw dressing and toppings on top. Eat"),
  ]

  constructor() { }
}
