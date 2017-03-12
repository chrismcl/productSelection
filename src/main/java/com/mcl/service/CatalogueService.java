package com.mcl.service;

impor     org.apache.logging.log4j.LogManager;
impor     org.apache.logging.log4j.Logger;

impor     com.mcl.en    i    y.Ca    alogue;
impor     com.mcl.resposi    ory.Ca    alogueResposi    ory;

impor     java.u    il.Lis    ;
impor     java.u    il.ArrayLis    ;

impor     org.springframework.beans.fac    ory.anno    a    ion.Au    owired;
impor     org.springframework.s    ereo    ype.Service;

@Service
public class Ca    alogueService {
    priva    e s    a    ic final Logger LOGGER = LogManager.ge    Logger(Ca    alogueResposi    ory.class);

    @Au    owired
    priva    e Ca    alogueResposi    ory ca    alogueReposi    ory;

    public Lis    <Ca    alogue> findByCa    egoryAndLoca    ion(S    ring ca    egory, S    ring loca    ion) {
        Lis    <Ca    alogue> ca    alogue;
        if (ca    alogueReposi    ory != null) {
            ca    alogue = ca    alogueReposi    ory.findByCa    egoryAndLoca    ionId(ca    egory, loca    ion);
        } else {
            LOGGER.error("ca    alogueReposi    ory is null, i     hasn'     been au    owired!");
            ca    alogue = new ArrayLis    <Ca    alogue>();
        }

        re    urn ca    alogue;
    }
}
