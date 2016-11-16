package com.acer.nina.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.regex.Pattern;



import javax.swing.JComboBox;

import com.acer.nina.test.Model;
import com.acer.nina.test.UserVo;

public class Controller implements ActionListener {

	private Model dataModel;
	private JComboBox<String> combo2;
//	private GridLayoutFrame gridLayoutFrame;
//	private EmailValidator emailValidator;

//	public static final Pattern EMAIL_PATTERN = Pattern
//			.compile("^\\w+\\.*\\w+@(\\w+\\.){1,5}[a-zA-Z]{2,3}$");
//	public static final Pattern MSISDN_PATTERN = Pattern
//			.compile("((/(/d{3}/)|/d{3}-)|(/(/d{4}/)|/d{4}-))?(/d{8}|/ d{7}) ");
//	public static final Pattern Age_PATTERN = Pattern
//			.compile("^[0-9]*$");

	/**
	 * �غc�l
	 */
	public Controller() {
		this.dataModel = new Model();

	}

	public Controller(Model model, JComboBox<String> combo2) {
		this.dataModel = model;
		this.combo2 = combo2;
	}

//	public Controller(GridLayoutFrame gridLayoutFrame) {
//		this.gridLayoutFrame = gridLayoutFrame;
//
//	}

	/**
	 * �����ϰ쪺���
	 * 
	 * @param id
	 *            �����W��
	 * @return �ϰ�M��
	 */
	public List<String> getTowns(String id) {
		System.out.println("id = " + id);
		return dataModel.getTowns(id);
	}

	/**
	 * �B�z�ϥΪ̴��檺��T
	 * 
	 * @param vo
	 * @return
	 */
	public Map<String, String> doSubmit(UserVo vo) {
		return this.doValidate(vo);
	}

	/**
	 * ���Ҫ������A�ثe�u��email �� phone(���)�p�G�٭n�b�[��O�����ت��ܭn�b�[
	 * 
	 * @param vo
	 * @return Map<String,String> key: Vo���ܼƦW�� value: ���~�T��
	 */
	private Map<String, String> doValidate(UserVo vo) {
		Map<String, String> map = new HashMap<String, String>();

		// if (!EMAIL_PATTERN.matcher(vo.getEmail()).matches()) {
		// map.put("email", "email��J�榡���~");
		// }
		System.out.println(">> vo.getEmail() = " + vo.getEmail());
		if (!EmailValidator.validate(vo.getEmail())) {
			map.put("email", "email��J�榡���~");
		}

		// if (!MSISDN_PATTERN.matcher(vo.getPhone()).matches()) {
		// map.put("phone", "phone��J�榡���~");
		// }
		System.out.println(">> vo.getPhone() = " + vo.getPhone());
		if (!PhoneNumberValid.isPhoneNumberValid(vo.getPhone())) {
			map.put("phone", "������X��J�榡���~");
		}
		
//		 if (!Age_PATTERN.matcher(vo.getAge()).matches()) {
//				 map.put("age", "age�u�i���Ʀr");
//		 }
		return map;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {

		
		JComboBox<String> cb = (JComboBox<String>) e.getSource();
		String cityName = (String) cb.getSelectedItem();

		System.out.println(">> cityName = " + cityName);

//		this.dataModel.getCitys();

		combo2.removeAllItems();
		for (String town : dataModel.getTowns(cityName)) {
			combo2.addItem(town);
		}

		// this.gridLayoutFrame.getCombo3().removeAllItems();

		// if("�x�_��".equals(cityName)) {
		//
		// combo2 = new JComboBox(dataModel.getTowns(cityName).toArray());
		//
		// } else if ("�s�_��".equals(cityName)) {
		//
		//
		// }

	}
}
