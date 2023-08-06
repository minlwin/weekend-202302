import { AfterContentInit, Component, DoCheck, Input, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-lifecycle-child',
  templateUrl: './lifecycle-child.component.html'
})
export class LifecycleChildComponent implements
OnChanges,
OnInit,
DoCheck,
AfterContentInit,
OnDestroy {

  @Input()
  username?: string

  constructor() {
    this.log('Child Constructor')
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.log('Child onChange')
  }

  ngOnInit(): void {
    this.log('Child onInit')
  }

  ngDoCheck(): void {
    this.log('Child doCheck')
  }

  ngAfterContentInit(): void {
    this.log('Child afterContentInit')
  }

  ngOnDestroy(): void {
    this.log('Child onDestroy')
  }

  updateUsername(value: string) {
    this.username = 'Chris'
  }

  private log(name: string) {
    console.log(`${name} called.`)
  }

}
