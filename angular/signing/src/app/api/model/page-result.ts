export interface PageResult {
  content:any[]
  page: Pager
}

export interface Pager {
  currentPage: number
  pageSize:number
  totalPage:number
  totalSize:number
}
