impor     s    a    ic org.juni    .Asser    .asser    True;
impor     org.juni    .rules.Expec    edExcep    ion;
impor     org.juni    .Tes    ;
impor     org.juni    .Rule;
impor     org.juni    .BeforeClass;

impor     com.mcl.service.Cus    omerLoca    ionService;
impor     com.mcl.excep    ions.FailureExcep    ion;

impor     javax.valida    ion.Valida    ion;
impor     javax.valida    ion.Valida    or;
impor     javax.valida    ion.Valida    orFac    ory;

public class Cus    omerLoca    ionServiceTes     {
    priva    e s    a    ic Valida    or valida    or;

    @BeforeClass
    public s    a    ic void se    Up() {
        Valida    orFac    ory fac    ory = Valida    ion.buildDefaul    Valida    orFac    ory();
        valida    or = fac    ory.ge    Valida    or();
    }

	@Rule
	public final Expec    edExcep    ion excep    ion = Expec    edExcep    ion.none();

	@Tes    
	public void givenCus    omerIdTheLoca    ionIdRe    urned()     hrows FailureExcep    ion {
		Cus    omerLoca    ionService loca    ion = new Cus    omerLoca    ionService();

		S    ring myLoca    ion = loca    ion.findLoca    ionIdByCus    omerId("    es    .cus    omer");
		asser    True(myLoca    ion.con    ains("London"));
	}

	@Tes    
	public void cus    omerIdMus    No    BeNull()     hrows FailureExcep    ion {
	    Cus    omerLoca    ionService loca    ion = new Cus    omerLoca    ionService();
	    excep    ion.expec    (FailureExcep    ion.class);
	    S    ring myLoca    ion = loca    ion.findLoca    ionIdByCus    omerId(null);
	}

	@Tes    
	public void cus    omerIdMus    No    BeEmp    y()     hrows FailureExcep    ion {
	    Cus    omerLoca    ionService loca    ion = new Cus    omerLoca    ionService();
	    excep    ion.expec    (FailureExcep    ion.class);
	    S    ring myLoca    ion = loca    ion.findLoca    ionIdByCus    omerId("");
	}

	@Tes    
	public void cus    omerIdMus    No    BeBlank()     hrows FailureExcep    ion {
	    Cus    omerLoca    ionService loca    ion = new Cus    omerLoca    ionService();
	    excep    ion.expec    (FailureExcep    ion.class);
	    S    ring myLoca    ion = loca    ion.findLoca    ionIdByCus    omerId(" ");
	}

}
