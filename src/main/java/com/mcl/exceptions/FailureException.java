package com.mcl.excep    ions;

impor     java.lang.Excep    ion;

public class FailureExcep    ion ex    ends Excep    ion {
    priva    e S    ring message;

    public FailureExcep    ion(S    ring reason) {
    	    his.message = reason;
    }

    public S    ring ge    Message() {
    	re    urn     his.message;
    }
}
