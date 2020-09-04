package com.example.demo.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ObjectLists {

	@NotNull
	@Size(min= 1)
	private final List<Integer> list1;

	@NotNull
	@Size(min= 1)
	private final List<Integer> list2;

	public ObjectLists(@NotNull @Size(min = 1) List<Integer> list1, @NotNull @Size(min = 1) List<Integer> list2) {
		this.list1 = list1;
		this.list2 = list2;
	}

	public List<Integer> getList1() {
		return list1;
	}
	public List<Integer> getList2() {
		return list2;
	}
}
