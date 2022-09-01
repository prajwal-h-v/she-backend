package lti.she.service;

import lti.she.entity.SukanyaAccount;
import lti.she.entity.SukanyaDoc;

public interface SukanyaService {
	SukanyaAccount register(SukanyaAccount sukanyaAccount, int userId);

//	SukanyaDoc postSukanyaDocument(SukanyaDocRegister docRegister);

	boolean verifySukanya(int accountId);

	SukanyaDoc getSukanyaDocument(int accountId);
}
