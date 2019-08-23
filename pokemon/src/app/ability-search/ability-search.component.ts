import { Component, OnInit } from '@angular/core';
import { StatsServiceService } from '../stats-service.service';

@Component({
  selector: 'app-ability-search',
  templateUrl: './ability-search.component.html',
  styleUrls: ['./ability-search.component.css']
})
export class AbilitySearchComponent implements OnInit {

  constructor(private _statsService: StatsServiceService) { }

  _searchTerm: string;
  data: any;

  set searchTerm(search: string){
    this._searchTerm = search;
  }

  get searchTerm(){
    return this._searchTerm;
  }

  onSearch(){
    this._statsService.getAbility(this._searchTerm).subscribe(data => {
      this.data = data['abilities'];
    })
  }

  ngOnInit() {
  }

}
