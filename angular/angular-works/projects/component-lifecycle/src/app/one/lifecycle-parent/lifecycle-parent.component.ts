import { AfterContentInit, Component, ContentChild, DoCheck, ElementRef, OnChanges, OnDestroy, OnInit, SimpleChanges, ViewChild } from '@angular/core';

@Component({
  selector: 'app-lifecycle-parent',
  templateUrl: './lifecycle-parent.component.html'
})
export class LifecycleParentComponent implements
OnChanges,
OnInit,
DoCheck,
AfterContentInit,
OnDestroy {

  username = 'Maria'

  @ViewChild('wrapper')
  wrapper!: ElementRef

  @ContentChild('content')
  content!: ElementRef

  constructor() {
    this.log('Parent Constructor')
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.log('Parent onChange')
  }

  ngOnInit(): void {
    this.log('Parent onInit')
  }

  ngDoCheck(): void {
    this.log('Parent doCheck')
  }

  ngAfterContentInit(): void {
    this.log('Parent afterContentInit')
    console.log(this.wrapper)
    console.log(this.content)
  }

  ngOnDestroy(): void {
    this.log('Parent onDestroy')
  }

  updateUsername() {
    this.username = 'Chris'
  }

  private log(name: string) {
    console.log(`${name} called.`)
  }

}
