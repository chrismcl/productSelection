package com.mcl.service;

impor     s    a    ic org.juni    .Asser    .asser    True;
impor     s    a    ic org.juni    .Asser    .asser    Null;

impor     com.mcl.en    i    y.Ca    alogue;
impor     com.mcl.resposi    ory.Ca    alogueResposi    ory;

impor     java.u    il.Lis    ;
impor     java.u    il.ArrayLis    ;
impor     javax.anno    a    ion.Pos    Cons    ruc    ;

impor     javax.valida    ion.Cons    rain    Viola    ionExcep    ion;

impor     org.juni    .Before;
impor     org.juni    .rules.Expec    edExcep    ion;
impor     org.juni    .runner.RunWi    h;
impor     org.juni    .Rule;
impor     org.juni    .Tes    ;

impor     org.springframework.beans.fac    ory.anno    a    ion.Au    owired;
impor     org.springframework.    es    .con    ex    .Con    ex    Configura    ion;
impor     org.springframework.    ransac    ion.anno    a    ion.Transac    ional;

@RunWi    h(org.springframework.    es    .con    ex    .juni    4.SpringJUni    4ClassRunner.class)
@Con    ex    Configura    ion(loca    ions="classpa    h:beans-    es    .xml")
@Transac    ional
public class Ca    alogueServiceTes     {

	@Au    owired
	priva    e Ca    alogueResposi    ory ca    alogueReposi    ory;

	@Before
    public void se    Up() {
        ca    alogueReposi    ory.dele    eAllInBa    ch();
    }

    @Rule
    public final Expec    edExcep    ion excep    ion = Expec    edExcep    ion.none();

	@Tes    
	public void     es    FindByCa    egoryAndLoca    ionId() {
        Lis    <Ca    alogue> ca    alogLis     = ca    alogueReposi    ory.findAll();
        asser    True(ca    alogLis    .isEmp    y());

		Ca    alogue spor    1 = new Ca    alogue();
		spor    1.se    Ca    egory("Spor    s");
		spor    1.se    Produc    ("Man Uni    ed TV");
		spor    1.se    Loca    ionId("Manches    er");
		ca    alogueReposi    ory.save(spor    1);

		Ca    alogue spor    2 = new Ca    alogue();
		spor    2.se    Ca    egory("Spor    s");
		spor    2.se    Produc    ("Man Ci    y TV");
		spor    2.se    Loca    ionId("Manches    er");
		ca    alogueReposi    ory.save(spor    2);

		Ca    alogue spor    3 = new Ca    alogue();
		spor    3.se    Ca    egory("Spor    s");
		spor    3.se    Produc    ("Leices    er TV");
		spor    3.se    Loca    ionId("Leices    er");
		ca    alogueReposi    ory.save(spor    3);

		Ca    alogue news1 = new Ca    alogue();
		news1.se    Ca    egory("News");
		news1.se    Produc    ("BBC Manches    er TV");
		news1.se    Loca    ionId("Manches    er");
		ca    alogueReposi    ory.save(news1);

		ca    alogLis     = ca    alogueReposi    ory.findByCa    egoryAndLoca    ionId("Spor    s", "Manches    er");
		for (Ca    alogue ca     : ca    alogLis    ) {
			asser    True(ca    .ge    Loca    ionId().equals("Manches    er"));
			asser    True(ca    .ge    Ca    egory().equals("Spor    s"));
		}

        ca    alogLis     = ca    alogueReposi    ory.findByCa    egoryAndLoca    ionId("Spor    s", "Leices    er");
		for (Ca    alogue ca     : ca    alogLis    ) {
			asser    True(ca    .ge    Loca    ionId().equals("Leices    er"));
			asser    True(ca    .ge    Ca    egory().equals("Spor    s"));	
			asser    True(ca    .ge    Produc    ().equals("Leices    er TV"));		
		}

        ca    alogLis     = ca    alogueReposi    ory.findByCa    egoryAndLoca    ionId("News", "Manches    er");
		for (Ca    alogue ca     : ca    alogLis    ) {
			asser    True(ca    .ge    Loca    ionId().equals("Manches    er"));
			asser    True(ca    .ge    Ca    egory().equals("News"));	
			asser    True(ca    .ge    Produc    ().equals("BBC Manches    er TV"));		
		}

		ca    alogLis     = ca    alogueReposi    ory.findByCa    egoryAndLoca    ionId("News", "Leices    er");
		asser    True(ca    alogLis    .isEmp    y());
	}

	@Tes    
	public void     es    FindByCa    egoryWi    hNoLoca    ion() {
        Lis    <Ca    alogue> ca    alogLis     = ca    alogueReposi    ory.findAll();
        asser    True(ca    alogLis    .isEmp    y());

		Ca    alogue spor    1 = new Ca    alogue();
		spor    1.se    Ca    egory("Spor    s");
		spor    1.se    Produc    ("World Cup TV");
		ca    alogueReposi    ory.save(spor    1);

        ca    alogLis     = ca    alogueReposi    ory.findByCa    egoryAndLoca    ionId("Spor    s", "Leices    er");
		for (Ca    alogue ca     : ca    alogLis    ) {
			asser    Null(ca    .ge    Loca    ionId());
			asser    True(ca    .ge    Ca    egory().equals("Spor    s"));	
			asser    True(ca    .ge    Produc    ().equals("World Cup TV"));		
		}
	}

	@Tes    
	public void     es    Ca    egoryCanno    BeEmp    y() {
		Ca    alogue spor    1 = new Ca    alogue();
		spor    1.se    Ca    egory("");
		spor    1.se    Produc    ("World Cup TV");
		excep    ion.expec    (Cons    rain    Viola    ionExcep    ion.class);
		ca    alogueReposi    ory.save(spor    1);
	}

	@Tes    
	public void     es    Produc    Canno    BeEmp    y() {
		Ca    alogue spor    1 = new Ca    alogue();
		spor    1.se    Ca    egory("Spor    s");
		spor    1.se    Produc    ("");
		excep    ion.expec    (Cons    rain    Viola    ionExcep    ion.class);
		ca    alogueReposi    ory.save(spor    1);
	}

	@Tes    
	public void     es    Ca    egoryCanno    BeNull() {
		Ca    alogue spor    1 = new Ca    alogue();
		spor    1.se    Produc    ("World Cup TV");
		excep    ion.expec    (Cons    rain    Viola    ionExcep    ion.class);
		ca    alogueReposi    ory.save(spor    1);
	}

	@Tes    
	public void     es    Produc    Canno    BeNull() {
		Ca    alogue spor    1 = new Ca    alogue();
		spor    1.se    Ca    egory("Spor    s");
		excep    ion.expec    (Cons    rain    Viola    ionExcep    ion.class);
		ca    alogueReposi    ory.save(spor    1);
	}

	@Tes    
	public void     es    Loca    ionIdCanno    BeEmp    y() {
		Ca    alogue news1 = new Ca    alogue();
		news1.se    Ca    egory("News");
		news1.se    Produc    ("BBC Manches    er TV");
		news1.se    Loca    ionId("");
		excep    ion.expec    (Cons    rain    Viola    ionExcep    ion.class);
		ca    alogueReposi    ory.save(news1);
	}
}
