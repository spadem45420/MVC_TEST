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
	 * 建構子
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
	 * 取的區域的資料
	 * 
	 * @param id
	 *            城市名稱
	 * @return 區域清單
	 */
	public List<String> getTowns(String id) {
		System.out.println("id = " + id);
		return dataModel.getTowns(id);
	}

	/**
	 * 處理使用者提交的資訊
	 * 
	 * @param vo
	 * @return
	 */
	public Map<String, String> doSubmit(UserVo vo) {
		return this.doValidate(vo);
	}

	/**
	 * 驗證的部份，目前只驗email 及 phone(手機)如果還要在加驗別的項目的話要在加
	 * 
	 * @param vo
	 * @return Map<String,String> key: Vo的變數名稱 value: 錯誤訊息
	 */
	private Map<String, String> doValidate(UserVo vo) {
		Map<String, String> map = new HashMap<String, String>();

		// if (!EMAIL_PATTERN.matcher(vo.getEmail()).matches()) {
		// map.put("email", "email輸入格式錯誤");
		// }
		System.out.println(">> vo.getEmail() = " + vo.getEmail());
		if (!EmailValidator.validate(vo.getEmail())) {
			map.put("email", "email輸入格式錯誤");
		}

		// if (!MSISDN_PATTERN.matcher(vo.getPhone()).matches()) {
		// map.put("phone", "phone輸入格式錯誤");
		// }
		System.out.println(">> vo.getPhone() = " + vo.getPhone());
		if (!PhoneNumberValid.isPhoneNumberValid(vo.getPhone())) {
			map.put("phone", "手機號碼輸入格式錯誤");
		}
		
//		 if (!Age_PATTERN.matcher(vo.getAge()).matches()) {
//				 map.put("age", "age只可為數字");
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

		// if("台北市".equals(cityName)) {
		//
		// combo2 = new JComboBox(dataModel.getTowns(cityName).toArray());
		//
		// } else if ("新北市".equals(cityName)) {
		//
		//
		// }

	}
}
