package com.pknufinal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknufinal.dao.PknuDao;
import com.pknufinal.service.PknuService;
import com.pknufinal.vo.PknuVo;

@Service("PknuService")
public class PknuServiceImpl implements PknuService {

	@Autowired
	private PknuDao PknuDao;

	@Override
	public void insertMenuButton(HashMap<String, Object> map) {
		PknuDao.insertMenuButton(map);	
	}
	
	@Override
	public void deleteMenuButton(HashMap<String, Object> map) {
		System.out.println("deleteMenuButton : "+ map);
		
		
		
		int check_count =  Integer.parseInt((String) map.get("check_count"));
		HashMap<String,Object> reverseMap = new HashMap();
		
		String MN_id =  (String) map.get("mn_id");
		
		String[] GetMN_id = MN_id.split("\",\"");
		
		for (int i = 0; i < check_count; i++) {
			GetMN_id[i] = GetMN_id[i].replace("[\"" , "" );
			GetMN_id[i] = GetMN_id[i].replace("\"]" , "" );
			System.out.println(GetMN_id[i]);
		}
		
		for (int i = check_count-1 ; i >= 0; i--) {
			reverseMap.put("mn_gbn", map.get("mn_gbn"));
			reverseMap.put("mn_id", GetMN_id[i]);
			System.out.println("확인하고 싶은 reverseMap의 값 : " + reverseMap);
			PknuDao.deleteMenuButton(reverseMap);
		}
	
		
	}

	@Override
	public void updateMenuButton(HashMap<String, Object> map) {

		System.out.println("QuestionDelete에 넘어온 값 : " + map);
		int check_count =  Integer.parseInt((String) map.get("check_count"));
		System.out.println("도착");
		String MN_name  =  (String) map.get("mn_name");
		String MN_url   =  (String) map.get("mn_url");
		String MN_id    =  (String) map.get("mn_id");
		
		if(check_count == 1) {
			for (int i = 0; i < check_count; i++) {
				MN_name  = MN_name.replace("[\"" , "" );
				MN_name  = MN_name.replace("\"]" , "" );
				MN_url   = MN_url.replace("[\"" , "" );
				MN_url   = MN_url.replace("\"]" , "" );
				MN_id    = MN_id.replace("[\"" , "" );
				MN_id    = MN_id.replace("\"]" , "" );
				map.put("mn_name",MN_name);
				map.put("mn_url",MN_url);
				map.put("mn_id",MN_id);
				PknuDao.updateMenuButton(map);	
				}//for end
		}
		
		if(check_count > 1) {
		String[] GetMN_name  = MN_name.split("\",\"");
		String[] GetMN_url = MN_url.split("\",\"");
		String[] GetMN_id = MN_id.split("\",\"");
		
			for (int i = 0; i < check_count; i++) {
				GetMN_name[i] = GetMN_name[i].replace("[\"" , "" );
				GetMN_name[i] = GetMN_name[i].replace("\"]" , "" );
				GetMN_url[i]  = GetMN_url[i].replace("[\"" , "" );
				GetMN_url[i]  = GetMN_url[i].replace("\"]" , "" );
				GetMN_id[i]   = GetMN_id[i].replace("[\"" , "" );
				GetMN_id[i]   = GetMN_id[i].replace("\"]" , "" );
				map.put("mn_name",GetMN_name[i] );
				map.put("mn_url",GetMN_url[i]);
				map.put("mn_id",GetMN_id[i]);
				PknuDao.updateMenuButton(map);	
				}//for end
		}// if end
		


		
		
		
		
		
		
		
		
		
		
		
		PknuDao.updateMenuButton(map);	
		
	}

	@Override
	public List<PknuVo> selectMenuButton(HashMap<String, Object> map) {
		List<PknuVo> selectMenuButton = PknuDao.selectMenuButton(map);
		return selectMenuButton;
	}
	
	



}
