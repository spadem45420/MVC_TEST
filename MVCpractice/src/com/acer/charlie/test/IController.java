package com.acer.charlie.test;

import java.util.List;
import java.util.Map;

import com.acer.charlie.test.UserVo;

public interface IController {
	
	/**
	 * 取得Citys
	 * @author USER
	 * @date 2016年11月9日下午2:32:28
	 * @return List<String>
	 * @param id
	 * @return
	 */
	public List<String> getCitys();

	/**
	 * 查詢Towns by city
	 * @author USER
	 * @date 2016年11月9日下午1:41:38
	 * @return List<String>
	 * @param id
	 * @return
	 */
	public List<String> getTowns(String id);
	
	/**
	 * 送出表單資料
	 * @author USER
	 * @date 2016年11月9日下午1:39:21
	 * @return Map<String,String>
	 * @param UserVo vo
	 * @return
	 */
	public Map<String, String> doSubmit(UserVo vo);

}
