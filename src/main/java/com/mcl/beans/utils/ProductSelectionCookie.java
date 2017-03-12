package com.mcl.beans.utils;

import javax.faces.context.FacesContext; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductSelectionCookie {
    private static final Logger LOGGER = LogManager.getLogger(ProductSelectionCookie.class);

    private static final String CUSTOMER_ID_COOKIE_ID = "productSelction_customerId";
    private static final String CUSTOMER_ID_COOKIE_VALUE = "AB321542134";

    public ProductSelectionCookie() {
        //TODO: This is just to simulate a cookie until we have the real thing.
        setCookie(CUSTOMER_ID_COOKIE_ID, CUSTOMER_ID_COOKIE_VALUE);
    }

    public void setCustomerId(String customerId) {
        setCookie(CUSTOMER_ID_COOKIE_ID, customerId);
    }

    public String getCustomerId() {
        return getCookie(CUSTOMER_ID_COOKIE_ID);
    }

    public void setCookie(String cookieId, String cookieValue) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)facesContext.getExternalContext().getRequest();
        Cookie requestedCookie = findCookie(request, cookieId); 

        if (requestedCookie != null) {
            requestedCookie.setValue(cookieValue);
        } else {
            requestedCookie = new Cookie(cookieId, cookieValue);
            requestedCookie.setPath(request.getContextPath());
        }

        requestedCookie.setMaxAge(-1);

        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.addCookie(requestedCookie);

        LOGGER.info("cookie set: {} : {}", requestedCookie.getName(), requestedCookie.getValue());
    }

    public String getCookie(String cookieId) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)facesContext.getExternalContext().getRequest();
        Cookie requestedCookie = findCookie(request, cookieId);

        String requestedCookieValue = "";
        if (requestedCookie != null) {
            requestedCookieValue = requestedCookie.getValue();
            LOGGER.info("cookie found: {} : {}", requestedCookie.getName(), requestedCookie.getValue());
        } else {
            LOGGER.error("{} Cookie not found!!!", cookieId);
        }

        return requestedCookieValue;
    }

    private Cookie findCookie(HttpServletRequest request, String cookieId) {
        Cookie requestedCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int index = 0; index < cookies.length; index++) {
                if (cookies[index].getName().equals(cookieId)) {
                    requestedCookie = cookies[index];
                    break;
                }
            }
        }

        return requestedCookie;
    }
}