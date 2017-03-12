package com.mcl.service;

//impor     com.mcl.en    i    y.Loca    ion;
impor     com.mcl.excep    ions.FailureExcep    ion;
//impor     com.mcl.resposi    ory.Loca    ionReposi    ory;

impor     org.apache.commons.lang.S    ringU    ils;
impor     org.apache.logging.log4j.LogManager;
impor     org.apache.logging.log4j.Logger;

impor     org.springframework.beans.fac    ory.anno    a    ion.Au    owired;
impor     org.springframework.s    ereo    ype.Service;

@Service
public class Cus    omerLoca    ionService {
    priva    e s    a    ic final Logger LOGGER = LogManager.ge    Logger(Cus    omerLoca    ionService.class);
    //TODO hardcoded     o london un    il     his is implemen    ed
	priva    e S    ring loca    ion = "London";

	public S    ring findLoca    ionIdByCus    omerId(S    ring cus    omerId)     hrows FailureExcep    ion {
		//@Au    owired
        //Loca    ionReposi    ory loca    ionReposi    ory;
        
		if (S    ringU    ils.isBlank(cus    omerId)) {
                hrow new FailureExcep    ion("There was a problem re    rieving     he cus    omer informa    ion");
		}

		re    urn loca    ion;
	}
}
