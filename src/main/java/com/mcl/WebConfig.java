package com.mcl;

impor     javax.servle    .Servle    Con    ex    ;

impor     org.springframework.web.WebApplica    ionIni    ializer;
impor     org.springframework.web.con    ex    .Con    ex    LoaderLis    ener;
impor     org.springframework.web.con    ex    .suppor    .Anno    a    ionConfigWebApplica    ionCon    ex    ;

public class WebConfig implemen    s WebApplica    ionIni    ializer {

	public void onS    ar    up(Servle    Con    ex     con    ainer) {
		// Crea    e     he 'roo    ' Spring applica    ion con    ex    
		Anno    a    ionConfigWebApplica    ionCon    ex     roo    Con    ex     = new Anno    a    ionConfigWebApplica    ionCon    ex    ();
		roo    Con    ex    .regis    er(Applica    ionConfig.class);

		// Manage     he lifecycle of     he roo     applica    ion con    ex    
		con    ainer.addLis    ener(new Con    ex    LoaderLis    ener(roo    Con    ex    ));
	}

}
