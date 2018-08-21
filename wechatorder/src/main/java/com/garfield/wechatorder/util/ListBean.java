package com.garfield.wechatorder.util;

import java.io.Serializable;
import java.util.List;

/**
 * 封装列表
 * Created by konie on 16-9-14.
 */
public class ListBean<T> implements Serializable {

	public ListBean() {
	}

	public ListBean(int total) {
		this.total = total;
	}

	public ListBean(int total, List<T> data) {
		this.total = total;
		this.data = data;
	}

	public ListBean(long total, List<T> data) {
		this((int) total, data);
	}

	public int total;

	public List<T> data;
}
