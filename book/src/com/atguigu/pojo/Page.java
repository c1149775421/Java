package com.atguigu.pojo;

import java.util.List;

/***
 * Page是分页的模型对象
 * @param <T>是具体的 模块的JavaBean类
 */
public class Page<T> {
    //final就是 修饰类，属于 不能继承的 内部类
    public static final Integer PAGE_SIZE = 4;

    //当前页码
    private Integer pageNo;

    //总页码
    private Integer pageTotal;

    //当前页显示数量
    private Integer pageSize = PAGE_SIZE;

    //总记录数
    private Integer pageTotalCount;

    //当前页数据
    private List<T> items;

    //分页条的请求地址
    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //数据边界的有效性检查
        if(pageNo < 1){
            pageNo = 1;
        }
        if(pageNo > pageTotal){
            pageNo = pageTotal;
        }

        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

}
