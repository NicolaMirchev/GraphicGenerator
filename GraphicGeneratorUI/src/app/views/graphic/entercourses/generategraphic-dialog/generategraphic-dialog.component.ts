import { Component, OnInit } from '@angular/core';
import { GraphicService } from 'src/app/services/graphic.service';

@Component({
  selector: 'app-generategraphic-dialog',
  templateUrl: './generategraphic-dialog.component.html',
  styleUrls: ['./generategraphic-dialog.component.css'],
})
export class GenerategraphicDialogComponent implements OnInit {
  duration: number = 90;
  selectedAlgorithm: string = '';

  constructor(private readonly graphicService: GraphicService) {}

  ngOnInit(): void {}

  generateGraphic() {
    // await data from backend and visualize it.
    console.log(this.duration + ' ' + this.selectedAlgorithm);
  }
}
