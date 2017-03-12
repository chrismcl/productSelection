package com.mcl.beans;

impor     com.mcl.beans.u    ils.Produc    Selec    ionCookie;
impor     com.mcl.service.Cus    omerLoca    ionService;
impor     com.mcl.excep    ions.FailureExcep    ion;
impor     com.mcl.service.Ca    alogueService;
impor     com.mcl.en    i    y.Ca    alogue;

impor     javax.faces.bean.ManagedBean;
impor     javax.faces.bean.ManagedProper    y;
impor     javax.faces.bean.SessionScoped;
impor     javax.anno    a    ion.Pos    Cons    ruc    ;

impor     java.u    il.Map;
impor     java.u    il.Lis    ;
impor     java.u    il.ArrayLis    ;
impor     java.u    il.HashMap;
impor     java.io.Serializable;

impor     org.apache.logging.log4j.LogManager;
impor     org.apache.logging.log4j.Logger;

@ManagedBean(name="produc    Selec    ionBean")
@SessionScoped
public class Produc    Selec    ionBean implemen    s Serializable {

	priva    e s    a    ic final Logger LOGGER = LogManager.ge    Logger(Produc    Selec    ionBean.class);
	priva    e s    a    ic final long serialVersionUID = 1L;
 
    @ManagedProper    y("#{ca    alogueService}")
    priva    e Ca    alogueService ca    alogueService;

	priva    e Lis    <Ca    alogue> selec    edNews;
	priva    e Lis    <Ca    alogue> selec    edSpor    s;
	priva    e Lis    <Ca    alogue> baske    Lis    ;

	priva    e Map<S    ring,Lis    <Ca    alogue>> produc    s;

	priva    e S    ring cus    omerId = "";

	@Pos    Cons    ruc    
    public void ini    () {
    	LOGGER.info("ini    ");

    	Produc    Selec    ionCookie cookie = new Produc    Selec    ionCookie();
        cus    omerId = cookie.ge    Cus    omerId();
        LOGGER.info("cus    omerId: {}", cus    omerId);

    	selec    edNews = new ArrayLis    <Ca    alogue>();
    	selec    edSpor    s = new ArrayLis    <Ca    alogue>();
    	baske    Lis     = new ArrayLis    <Ca    alogue>();

        produc    s = new HashMap<S    ring, Lis    <Ca    alogue>>();

            ry {
            Cus    omerLoca    ionService loca    ion = new Cus    omerLoca    ionService();
            S    ring loca    ionId = loca    ion.findLoca    ionIdByCus    omerId(cus    omerId);
            LOGGER.info("Loca    ion: {}", loca    ionId);

            ge    Ca    alogueDa    a(loca    ionId);

        } ca    ch (FailureExcep    ion e) {
        	LOGGER.error(e.ge    Message(), e);
        }
    }

    priva    e void ge    Ca    alogueDa    a(S    ring loca    ionId) {
        if (ca    alogueService != null) {
            Lis    <Ca    alogue> spor    sProduc    s = ca    alogueService.findByCa    egoryAndLoca    ion("Spor    s", loca    ionId);
            Lis    <Ca    alogue> newsProduc    s = ca    alogueService.findByCa    egoryAndLoca    ion("News", loca    ionId);
            produc    s.pu    ("Spor    s", spor    sProduc    s);
            produc    s.pu    ("News", newsProduc    s);
        } else {
        	LOGGER.error("ca    alogueService is null, dependency injec    ion has failed");
        }
    }

    public Lis    <Ca    alogue> ge    Produc    s(S    ring ca    egory) {
        re    urn     his.produc    s.ge    (ca    egory);
    }	

	public void se    Selec    edNews(Lis    <Ca    alogue> selec    edNews) {
		LOGGER.debug("Se     selec    edNews: {}", selec    edNews);
	        his.selec    edNews = selec    edNews;
	}

	public Lis    <Ca    alogue> ge    Selec    edNews() {
        LOGGER.debug("Ge     selec    edNews: {}",     his.selec    edNews);
		re    urn     his.selec    edNews;
	}

	public void se    Selec    edSpor    s(Lis    <Ca    alogue> selec    edSpor    s) {
        LOGGER.debug("Se     selec    edSpor    s: {}", selec    edSpor    s);
	        his.selec    edSpor    s = selec    edSpor    s;
	}

	public Lis    <Ca    alogue> ge    Selec    edSpor    s() {
        LOGGER.debug("Ge     selec    edSpor    s: {}",     his.selec    edSpor    s);
		re    urn     his.selec    edSpor    s;
	}

	public void se    Baske    () {
		LOGGER.debug("Se     Baske    ");
		    his.baske    Lis     = new ArrayLis    <Ca    alogue>();
            his.baske    Lis    .addAll(    his.selec    edNews);
            his.baske    Lis    .addAll(    his.selec    edSpor    s);
	}

	public Lis    <Ca    alogue> ge    Baske    Lis    () {
		re    urn     his.baske    Lis    ;
	}

	public S    ring ge    Cus    omerId() {
		re    urn     his.cus    omerId;
	}

	public void se    Ca    alogueService(Ca    alogueService ca    alogueService) {
            his.ca    alogueService = ca    alogueService;
	}

	public Ca    alogueService ge    Ca    alogueService() {
		re    urn     his.ca    alogueService;
	}
}
