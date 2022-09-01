package lti.she.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.she.dao.SukanyaDao;
import lti.she.dao.UserDao;
import lti.she.entity.SukanyaAccount;
import lti.she.entity.SukanyaDoc;

@Service
public class SukanyaServiceImpl implements SukanyaService {

	@Autowired
	SukanyaDao dao;
	@Autowired
	UserDao userDao;

	@Override
	public SukanyaAccount register(SukanyaAccount sukanyaAccount, int userId) {
		// TODO Auto-generated method stub
		sukanyaAccount.setUser(userDao.getUserById(userId));
		return dao.register(sukanyaAccount);
	}

//	@Override
//	public SukanyaDoc postSukanyaDocument(SukanyaDocRegister docRegister) {
//		SukanyaDoc sukanyaDoc = new SukanyaDoc();
//		sukanyaDoc.setAadhaarLink(docRegister.getAadhaarLink());
//		sukanyaDoc.setAadhaarNo(docRegister.getAadhaarNo());
//
//		SukanyaAccount sukanyaAccount = dao.getSukanyaById(docRegister.getSukanyaAccoutnId());
//		sukanyaDoc.setSukanyaAccount(sukanyaAccount);
//
//		SukanyaDoc savedDoc = dao.addSukanyaDoc(sukanyaDoc);
//		savedDoc.getSukanyaAccount().setSukanyaDoc(null);
//
//		return savedDoc;
//	}

	public boolean verifySukanya(int accountId) {
		return dao.verifySukanya(accountId);
	}

	public SukanyaDoc getSukanyaDocument(int accountId) {
		dao.getSukanyaById(accountId);
		return dao.getSukanyaById(accountId).getSukanyaDoc();
	}
}
