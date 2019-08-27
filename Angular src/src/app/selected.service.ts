import { Injectable } from '@angular/core';
import { Food } from './Food';

@Injectable({
  providedIn: 'root'
})
export class SelectedService {

  selected: Food;

  constructor() { }
}
