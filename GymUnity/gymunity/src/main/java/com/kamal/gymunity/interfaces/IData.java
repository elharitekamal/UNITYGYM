package com.kamal.gymunity.interfaces;


public interface IData<DTOreq,DTOres,idType>{
    DTOres findById(idType primarykey);
    DTOres save(DTOreq DTOreq);
    DTOres deleteById(idType primarykey);
    DTOres update(DTOreq DTOreq);
}
