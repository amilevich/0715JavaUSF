import { Component, OnInit, Input } from '@angular/core';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private _searchService: SearchService) { }

  _searchTerm: string;
  id = '';
  image = '';
  type = '';

  set searchTerm(search: string) {
    this._searchTerm = search;
  }

  get searchTerm() {
    return this._searchTerm;
  }

  onSearch() {
    this._searchService.searchPokemon(this._searchTerm).subscribe(data => {
      this.id = data['id'];
      this.image = data['sprites']['front_default'];
      this.type = data['types']['0']['type']['name'];
    });
  }

  clickSearch(): void {
    this.onSearch();
  }

  ngOnInit() {
  }

}
