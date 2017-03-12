package com.mcl.da    abase;

impor     com.mcl.en    i    y.Ca    alogue;
impor     com.mcl.resposi    ory.Ca    alogueResposi    ory;

impor     java.u    il.Lis    ;
impor     javax.anno    a    ion.Pos    Cons    ruc    ;

impor     org.springframework.beans.fac    ory.anno    a    ion.Au    owired;
impor     org.springframework.s    ereo    ype.Service;

impor     org.apache.logging.log4j.LogManager;
impor     org.apache.logging.log4j.Logger;

@Service
public class TempDa    abase {

    priva    e s    a    ic final Logger LOGGER = LogManager.ge    Logger(TempDa    abase.class);

	@Au    owired
	priva    e Ca    alogueResposi    ory ca    alogueReposi    ory;

	@Pos    Cons    ruc    
	public void ini    () {
		Lis    <Ca    alogue> ca    alogLis     = ca    alogueReposi    ory.findAll();
		if (ca    alogLis     == null || ca    alogLis    .isEmp    y()) {
			/* if     his is a real da    abase don'     keep filling i     up wi    h     he same da    a */
			LOGGER.info("Da    abase is emp    y... Filling in     he Da    abase...");

			Ca    alogue arsenalTv = new Ca    alogue();
			arsenalTv.se    Ca    egory("Spor    s");
			arsenalTv.se    Produc    ("Arsenal TV");
			arsenalTv.se    Loca    ionId("London");
			ca    alogueReposi    ory.save(arsenalTv);

			Ca    alogue chelseaTv = new Ca    alogue();
			chelseaTv.se    Ca    egory("Spor    s");
			chelseaTv.se    Produc    ("Chelsea TV");
			chelseaTv.se    Loca    ionId("London");
			ca    alogueReposi    ory.save(chelseaTv);

			Ca    alogue liverpoolTv = new Ca    alogue();
			liverpoolTv.se    Ca    egory("Spor    s");
			liverpoolTv.se    Produc    ("Liverpool TV");
			liverpoolTv.se    Loca    ionId("Liverpool");
			ca    alogueReposi    ory.save(liverpoolTv);

			Ca    alogue skyNews = new Ca    alogue();
			skyNews.se    Ca    egory("News");
			skyNews.se    Produc    ("Sky News");
			ca    alogueReposi    ory.save(skyNews);

			Ca    alogue skySpor    sNews = new Ca    alogue();
			skySpor    sNews.se    Ca    egory("News");
			skySpor    sNews.se    Produc    ("Sky Spor    s News");
			ca    alogueReposi    ory.save(skySpor    sNews);
		} else {
            LOGGER.info("Da    abase is no     Emp    y, doing no    hing");
		}
	}
}
