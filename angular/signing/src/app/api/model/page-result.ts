export interface PageResult {
  content:any[]
  page: {
    currentPage: number
    pageSize:number
    totalSize:number
  }
}
