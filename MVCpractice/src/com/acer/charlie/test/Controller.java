package com.acer.charlie.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acer.charlie.test.EmailValidator;
import com.acer.charlie.test.PhoneNumberValid;
import com.acer.charlie.test.UserVo;

public class Controller implements IController {
	
	public Model model = new Model();

	@Override
	public List<String> getTowns(String id) {
		return model.getTowns(id);
	}

	@Override
	public Map<String, String> doSubmit(UserVo vo) {
		return this.doValidate(vo);
	}
	
	@Override
	public List<String> getCitys() {
		return model.getCitys();
	}

	/**
	 * 驗證的部份，目前只驗email 及 phone(手機)如果還要在加驗別的項目的話要在加
	 * 
	 * @param vo
	 * @return Map<String,String> key: Vo的變數名稱 value: 錯誤訊息
	 */
	private Map<String, String> doValidate(UserVo vo) {
		System.out.println("doValidate Controller");
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
}
