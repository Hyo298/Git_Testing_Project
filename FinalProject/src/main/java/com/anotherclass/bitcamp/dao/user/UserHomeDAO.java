package com.anotherclass.bitcamp.dao.user;

import java.util.List;

import com.anotherclass.bitcamp.register.RegisterVO;

public interface UserHomeDAO {
	// 인기 클래스 조회
	// 신규 클래스 조회
	// 후기 조회	
	public List<RegisterVO> popularCreator(); // 인기 크리에이터 조회
}