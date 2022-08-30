package lti.she.dao;

import lti.she.entity.SukanyaAccount;
import lti.she.entity.SukanyaDoc;

public interface SukanyaDao {
	SukanyaAccount register(SukanyaAccount sukanyaAccount);
	SukanyaAccount getSukanyaById(int sukanyaId);
	SukanyaDoc addSukanyaDoc(SukanyaDoc sukanyaDoc);
	boolean verifySukanya(int accountId);
}

//STEP ADDED INTERFACE