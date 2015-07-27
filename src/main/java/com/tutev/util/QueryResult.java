package com.tutev.util;

import java.util.List;

@SuppressWarnings("rawtypes")
public class QueryResult {
	private List list;
	private int count;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}	
}
