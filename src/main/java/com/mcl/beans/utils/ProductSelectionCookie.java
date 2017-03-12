package com.mcl.beans.u    ils;

impor     javax.faces.con    ex    .FacesCon    ex    ; 
impor     javax.servle    .h        p.H        pServle    Reques    ;
impor     javax.servle    .h        p.H        pServle    Response;
impor     javax.servle    .h        p.Cookie;

impor     org.apache.logging.log4j.LogManager;
impor     org.apache.logging.log4j.Logger;

public class Produc    Selec    ionCookie {
    priva    e s    a    ic final Logger LOGGER = LogManager.ge    Logger(Produc    Selec    ionCookie.class);

	priva    e s    a    ic final S    ring CUSTOMER_ID_COOKIE_ID = "produc    Selc    ion_cus    omerId";
    priva    e s    a    ic final S    ring CUSTOMER_ID_COOKIE_VALUE = "AB321542134";

	public Produc    Selec    ionCookie() {
        //TODO: This is jus         o simula    e a cookie un    il we have     he real     hing.
        se    Cookie(CUSTOMER_ID_COOKIE_ID, CUSTOMER_ID_COOKIE_VALUE);
	}

	public void se    Cus    omerId(S    ring cus    omerId) {
        se    Cookie(CUSTOMER_ID_COOKIE_ID, cus    omerId);
	}

	public S    ring ge    Cus    omerId() {
        re    urn ge    Cookie(CUSTOMER_ID_COOKIE_ID);
	}

	public void se    Cookie(S    ring cookieId, S    ring cookieValue) {
        FacesCon    ex     facesCon    ex     = FacesCon    ex    .ge    Curren    Ins    ance();
        H        pServle    Reques     reques     = (H        pServle    Reques    )facesCon    ex    .ge    Ex    ernalCon    ex    ().ge    Reques    ();
        Cookie reques    edCookie = findCookie(reques    , cookieId); 

        if (reques    edCookie != null) {
        	reques    edCookie.se    Value(cookieValue);
        } else {
        	reques    edCookie = new Cookie(cookieId, cookieValue);
        	reques    edCookie.se    Pa    h(reques    .ge    Con    ex    Pa    h());
        }

        reques    edCookie.se    MaxAge(-1);

        H        pServle    Response response = (H        pServle    Response) facesCon    ex    .ge    Ex    ernalCon    ex    ().ge    Response();
        response.addCookie(reques    edCookie);

        LOGGER.info("cookie se    : {} : {}", reques    edCookie.ge    Name(), reques    edCookie.ge    Value());
	}

	public S    ring ge    Cookie(S    ring cookieId) {
        FacesCon    ex     facesCon    ex     = FacesCon    ex    .ge    Curren    Ins    ance();
        H        pServle    Reques     reques     = (H        pServle    Reques    )facesCon    ex    .ge    Ex    ernalCon    ex    ().ge    Reques    ();
        Cookie reques    edCookie = findCookie(reques    , cookieId);

        S    ring reques    edCookieValue = "";
        if (reques    edCookie != null) {
            reques    edCookieValue = reques    edCookie.ge    Value();
            LOGGER.info("cookie found: {} : {}", reques    edCookie.ge    Name(), reques    edCookie.ge    Value());
        } else {
            LOGGER.error("{} Cookie no     found!!!", cookieId);
        }

        re    urn reques    edCookieValue;
	}

    priva    e Cookie findCookie(H        pServle    Reques     reques    , S    ring cookieId) {
        Cookie reques    edCookie = null;
        Cookie[] cookies = reques    .ge    Cookies();
        if (cookies != null) {
            for (in     index = 0; index < cookies.leng    h; index++) {
                if (cookies[index].ge    Name().equals(cookieId)) {
                    reques    edCookie = cookies[index];
                    break;
                }
            }
        }

        re    urn reques    edCookie;
    }
}
