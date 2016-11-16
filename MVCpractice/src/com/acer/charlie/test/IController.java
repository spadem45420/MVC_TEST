package com.acer.charlie.test;

import java.util.List;
import java.util.Map;

import com.acer.charlie.test.UserVo;

public interface IController {
	
	/**
	 * ���oCitys
	 * @author USER
	 * @date 2016�~11��9��U��2:32:28
	 * @return List<String>
	 * @param id
	 * @return
	 */
	public List<String> getCitys();

	/**
	 * �d��Towns by city
	 * @author USER
	 * @date 2016�~11��9��U��1:41:38
	 * @return List<String>
	 * @param id
	 * @return
	 */
	public List<String> getTowns(String id);
	
	/**
	 * �e�X�����
	 * @author USER
	 * @date 2016�~11��9��U��1:39:21
	 * @return Map<String,String>
	 * @param UserVo vo
	 * @return
	 */
	public Map<String, String> doSubmit(UserVo vo);

}
