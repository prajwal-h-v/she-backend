package lti.she.service;


import java.util.List;

import lti.she.entity.Ngo;

public interface NgoService {
    Ngo register(Ngo ngo);
   
    List<Ngo> getNgoList();
    List<Ngo> getNgoPendingList();
}
