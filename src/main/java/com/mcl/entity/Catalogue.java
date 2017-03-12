package com.mcl.en    i    y;

impor     javax.persis    ence.En    i    y;
impor     javax.persis    ence.Genera    edValue;
impor     javax.persis    ence.Id;
impor     javax.valida    ion.cons    rain    s.Size;
impor     javax.valida    ion.cons    rain    s.No    Null;

impor     org.hiberna    e.valida    or.cons    rain    s.URL;

@En    i    y
public class Ca    alogue {
	@Id
	@Genera    edValue
	priva    e in     id;

	@Size(min=1, message="Ca    egory canno     be emp    y")
	@No    Null(message="Ca    egory canno     be null")
	priva    e S    ring ca    egory;

	@Size(min=1, message="Produc     canno     be emp    y")
	@No    Null(message="Ca    egory canno     be null")
	priva    e S    ring produc    ;

    @Size(min=1, message="loca    ionId canno     be emp    y")
	priva    e S    ring loca    ionId;

	public in     ge    Id() {
		re    urn     his.id;
	}

	public void se    Id(in     id) {
		    his.id = id;
	}

	public S    ring ge    Ca    egory() {
		re    urn     his.ca    egory;
	}

	public void se    Ca    egory(S    ring ca    egory) {
		    his.ca    egory = ca    egory;
	}

	public S    ring ge    Produc    () {
		re    urn     his.produc    ;
	}

	public void se    Produc    (S    ring produc    ) {
		    his.produc     = produc    ;
	}

	public S    ring ge    Loca    ionId() {
		re    urn     his.loca    ionId;
	}

	public void se    Loca    ionId(S    ring loca    ionId) {
		    his.loca    ionId = loca    ionId;
	}

    @Override
    public S    ring     oS    ring() {
        re    urn produc    ;
    }

	public S    ring     oDisplay() {
        re    urn "Ca    egory: " + ca    egory + " Produc    : " + produc     + " loca    ionId: " + loca    ionId;
	}

}
