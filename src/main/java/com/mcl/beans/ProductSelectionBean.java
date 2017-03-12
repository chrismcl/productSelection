package com.mcl.beans;

import com.mcl.beans.utils.ProductSelectionCookie;
import com.mcl.service.CustomerLocationService;
import com.mcl.exceptions.FailureException;
import com.mcl.service.CatalogueService;
import com.mcl.entity.Catalogue;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean(name="productSelectionBean")
@SessionScoped
public class ProductSelectionBean implements Serializable {

	private static final Logger LOGGER = LogManager.getLogger(ProductSelectionBean.class);
	private static final long serialVersionUID = 1L;
 
    @ManagedProperty("#{catalogueService}")
    private CatalogueService catalogueService;

	private List<Catalogue> selectedNews;
	private List<Catalogue> selectedSports;
	private List<Catalogue> basketList;

	private Map<String,List<Catalogue>> products;

	private String customerId = "";

	@PostConstruct
    public void init() {
    	LOGGER.info("init");

    	ProductSelectionCookie cookie = new ProductSelectionCookie();
        customerId = cookie.getCustomerId();
        LOGGER.info("customerId: {}", customerId);

    	selectedNews = new ArrayList<Catalogue>();
    	selectedSports = new ArrayList<Catalogue>();
    	basketList = new ArrayList<Catalogue>();

        products = new HashMap<String, List<Catalogue>>();

        try {
            CustomerLocationService location = new CustomerLocationService();
            String locationId = location.findLocationIdByCustomerId(customerId);
            LOGGER.info("Location: {}", locationId);

            getCatalogueData(locationId);

        } catch (FailureException e) {
        	LOGGER.error(e.getMessage(), e);
        }
    }

    private void getCatalogueData(String locationId) {
        if (catalogueService != null) {
            List<Catalogue> sportsProducts = catalogueService.findByCategoryAndLocation("Sports", locationId);
            List<Catalogue> newsProducts = catalogueService.findByCategoryAndLocation("News", locationId);
            products.put("Sports", sportsProducts);
            products.put("News", newsProducts);
        } else {
        	LOGGER.error("catalogueService is null, dependency injection has failed");
        }
    }

    public List<Catalogue> getProducts(String category) {
        return this.products.get(category);
    }	

	public void setSelectedNews(List<Catalogue> selectedNews) {
		LOGGER.debug("Set selectedNews: {}", selectedNews);
	    this.selectedNews = selectedNews;
	}

	public List<Catalogue> getSelectedNews() {
        LOGGER.debug("Get selectedNews: {}", this.selectedNews);
		return this.selectedNews;
	}

	public void setSelectedSports(List<Catalogue> selectedSports) {
        LOGGER.debug("Set selectedSports: {}", selectedSports);
	    this.selectedSports = selectedSports;
	}

	public List<Catalogue> getSelectedSports() {
        LOGGER.debug("Get selectedSports: {}", this.selectedSports);
		return this.selectedSports;
	}

	public void setBasket() {
		LOGGER.debug("Set Basket");
		this.basketList = new ArrayList<Catalogue>();
        this.basketList.addAll(this.selectedNews);
        this.basketList.addAll(this.selectedSports);
	}

	public List<Catalogue> getBasketList() {
		return this.basketList;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCatalogueService(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
	}

	public CatalogueService getCatalogueService() {
		return this.catalogueService;
	}
}