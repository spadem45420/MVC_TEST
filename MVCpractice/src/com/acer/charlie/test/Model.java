package com.acer.charlie.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

	// ���oCity����T
	public List<String> getCitys() {
		List<String> citys = new ArrayList<String>();
		citys.add("�x�_��");
		citys.add("�s�_��");
		return citys;
	}

	// ���oTown����T
	public List<String> getTowns(String id) {

		String[] taipei = { "�j�P��", "�H�q��", "������", "�j�w��" };
		String[] newTaipei = { "Ī�w��", "���M��", "�éM��", "�L�f��" };

		List<String> towns = null;

		if ("�x�_��".equals(id)) {
			towns = Arrays.asList(taipei);
		} else if ("�s�_��".equals(id)) {
			towns = Arrays.asList(newTaipei);
		}
		return towns;
	}
}
