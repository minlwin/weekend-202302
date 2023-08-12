import { Component, EventEmitter, Input, Output } from "@angular/core";
import { Pager } from "../api/model/page-result";

@Component({
  selector: 'pager',
  templateUrl: './pagination.component.html'
})
export class PaginationComponent {

  @Input()
  sizes:number[] = []

  @Input()
  alighment: 'start' | 'end' = 'start'

  @Output()
  onPageLinkClick = new EventEmitter

  @Output()
  onPageSizeChange = new EventEmitter

  pages:number[] = []
  lastPage = 0
  current = 0

  get showFirst() {
    return this.pages.length > 0 && this.pages[0] > 1
  }

  get showLast() {
    return this.pages.length > 0 && this.pages[this.pages.length - 1] < this.lastPage
  }

  @Input()
  set pager(pager:Pager | undefined) {
    this.pages = []

    if(pager && pager.pageSize > 1) {

      this.lastPage = pager.totalPage - 1
      this.current = pager.currentPage

      this.pages.push(pager.currentPage)

      while(this.pages.length < Math.min(3, pager.totalPage)) {
        let target = this.pages[0] - 1
        if(target <= -1) {
          break
        }
        this.pages.unshift(target)
      }

      while(this.pages.length < Math.min(5, pager.totalPage)) {
        let target = this.pages[this.pages.length - 1] + 1
        if(target > pager.pageSize) {
          break
        }
        this.pages.push(target)
      }

      while(this.pages.length < Math.min(5, pager.totalPage)) {
        let target = this.pages[0] - 1
        if(target <= 0) {
          break
        }
        this.pages.unshift(target)
      }
    }
  }

  clickLink(page:number) {
    if(page != this.current) {
      this.onPageLinkClick.emit(page)
    }
  }

  changePageSize(size:any) {
    this.onPageSizeChange.emit(size)
  }
}
