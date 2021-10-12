package com.anotherclass.bitcamp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.anotherclass.bitcamp.dao.ClassDetailPageDAO;
import com.anotherclass.bitcamp.vo.ClassVO;
@Service
public class ClassDetailPageServiceImp implements ClassDetailPageService {

	@Inject
	ClassDetailPageDAO classDetailPageDAO;
	
	@Override
	public List<ClassVO> temporarylistAllSelect() {
		
		return classDetailPageDAO.temporarylistAllSelect();
	}

	

}
