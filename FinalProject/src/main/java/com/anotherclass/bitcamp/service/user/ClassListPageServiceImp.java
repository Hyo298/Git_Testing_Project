package com.anotherclass.bitcamp.service.user;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.anotherclass.bitcamp.dao.user.ClassListDAO;
import com.anotherclass.bitcamp.vo.user.ClassListVO;

@Service
public class ClassListPageServiceImp implements ClassListPageService {
	@Inject
	ClassListDAO classListDao;
	@Override
	public List<ClassListVO> ClassList() {
		return classListDao.ClassList();
	}

}