import { DecimalPipe } from '@angular/common';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mmk'
})
export class MmkPipe implements PipeTransform {

  constructor(private df: DecimalPipe) {}

  transform(value: unknown, side?: string | number): string {
    let trans = typeof value == 'number' ? this.df.transform(value) : value
    let result = side && side == 'behind' ? 'behind' : 'front'
    return result == 'front' ? `MMK ${trans}` : `${trans} MMK`;
  }

}
