package com.church.library.condition;

import java.io.Serializable;

import com.church.library.utils.StrUtils;

public class BaseCond implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private enum DIR{
		DESC("desc"), ASC("asc");
		
		private String dir;
		
		private DIR(String dir){
			this.dir = dir;
		}
		@Override
		public String toString(){
			return this.dir;
		}
	}
	
	public final static int DEFAULT_START = 0;//默认起始记录位置
	public final static int DEFAULT_LIMIT = 20;//默认页面大小
	
	private Integer totals;// 总行数
	private Integer start;// 页起始记录
	private Integer limit;//页面大小（每页最大显示的数据条数)
	private String sort;//排序字段名称
	private String dir;//排序规则［asc/desc］
	
	public Integer getTotals() {
		return totals;
	}
	public void setTotals(Integer totals) {
		this.totals = totals;
	}
	public Integer getStart() {
		if(start==null){
			start=DEFAULT_START;
		}
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		if(limit==null){
			limit = DEFAULT_LIMIT;
		}
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDir() {
		if(StrUtils.isEmpty(dir)){
			return DIR.DESC.toString();
		}
		for(DIR d: DIR.values()){
			if(dir.equalsIgnoreCase(d.dir)){
				return dir;
			}
		}
		return DIR.DESC.toString();
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	
}