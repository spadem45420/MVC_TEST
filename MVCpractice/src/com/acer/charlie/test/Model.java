package com.acer.charlie.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

	// 取得City的資訊
	public List<String> getCitys() {
		List<String> citys = new ArrayList<String>();
		citys.add("台北市");
		citys.add("新北市");
		return citys;
	}

	// 取得Town的資訊
	public List<String> getTowns(String id) {

		String[] taipei = { "大同區", "信義區", "中正區", "大安區" };
		String[] newTaipei = { "蘆洲區", "中和區", "永和區", "林口區" };

		List<String> towns = null;

		if ("台北市".equals(id)) {
			towns = Arrays.asList(taipei);
		} else if ("新北市".equals(id)) {
			towns = Arrays.asList(newTaipei);
		}
		return towns;
	}
}
