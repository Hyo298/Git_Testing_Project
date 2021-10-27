package com.anotherclass.bitcamp.service.admin;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.anotherclass.bitcamp.dao.admin.ExpectedRefundListMangementDAO;
import com.anotherclass.bitcamp.service.vo.admin.ExpectedRefundListMangementVO;

@Service
public class AdminRefundServiceImp implements AdminRefundService{

	@Inject
	ExpectedRefundListMangementDAO expectedRefundListMangementDAO ;
	
	@Override
	public List<ExpectedRefundListMangementVO> refundList(ExpectedRefundListMangementVO vo) {
		// TODO Auto-generated method stub
		return expectedRefundListMangementDAO.refundList(vo);
	}
	
	@Override
	public ExpectedRefundListMangementVO refundInfo(String idCheck) {
		// TODO Auto-generated method stub
		return expectedRefundListMangementDAO.refundInfo(idCheck);
	}
	
	@Override
	public int boardLimit() {
		// TODO Auto-generated method stub
		return expectedRefundListMangementDAO.boardLimit();
	}
}
