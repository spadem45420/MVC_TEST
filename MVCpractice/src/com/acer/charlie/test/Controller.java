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
	 * ���Ҫ������A�ثe�u��email �� phone(���)�p�G�٭n�b�[��O�����ت��ܭn�b�[
	 * 
	 * @param vo
	 * @return Map<String,String> key: Vo���ܼƦW�� value: ���~�T��
	 */
	private Map<String, String> doValidate(UserVo vo) {
		System.out.println("doValidate Controller");
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
}
