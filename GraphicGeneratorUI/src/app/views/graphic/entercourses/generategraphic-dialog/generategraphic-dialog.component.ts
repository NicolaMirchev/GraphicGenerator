import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { GraphicService } from 'src/app/services/graphic.service';

@Component({
  selector: 'app-generategraphic-dialog',
  templateUrl: './generategraphic-dialog.component.html',
  styleUrls: ['./generategraphic-dialog.component.css'],
})
export class GenerategraphicDialogComponent implements OnInit {
  duration: number = 90;
  selectedAlgorithm: string = '';

  constructor(
    private readonly graphicService: GraphicService,
    private readonly router: Router
  ) {}

  ngOnInit(): void {}

  generateGraphic() {
    // await data from backend and visualize it.
    this.graphicService
      .getBestGraphic(this.selectedAlgorithm, this.duration)
      .subscribe({
        next: (result) => {
          this.graphicService.assignBestGraphicToLC(result);
          this.router.navigateByUrl('/mygraphic');
        },
      });
    console.log(this.duration + ' ' + this.selectedAlgorithm);
  }
}
