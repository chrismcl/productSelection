package com.mcl.database;

import com.mcl.entity.Catalogue;
import com.mcl.respository.CatalogueRespository;

import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class TempDatabase {

    private static final Logger LOGGER = LogManager.getLogger(TempDatabase.class);

	@Autowired
	private CatalogueRespository catalogueRepository;

	@PostConstruct
	public void init() {
		List<Catalogue> catalogList = catalogueRepository.findAll();
		if (catalogList == null || catalogList.isEmpty()) {
			/* if this is a real database don't keep filling it up with the same data */
			LOGGER.info("Database is empty... Filling in the Database...");

			Catalogue arsenalTv = new Catalogue();
			arsenalTv.setCategory("Sports");
			arsenalTv.setProduct("Arsenal TV");
			arsenalTv.setLocationId("London");
			catalogueRepository.save(arsenalTv);

			Catalogue chelseaTv = new Catalogue();
			chelseaTv.setCategory("Sports");
			chelseaTv.setProduct("Chelsea TV");
			chelseaTv.setLocationId("London");
			catalogueRepository.save(chelseaTv);

			Catalogue liverpoolTv = new Catalogue();
			liverpoolTv.setCategory("Sports");
			liverpoolTv.setProduct("Liverpool TV");
			liverpoolTv.setLocationId("Liverpool");
			catalogueRepository.save(liverpoolTv);

			Catalogue skyNews = new Catalogue();
			skyNews.setCategory("News");
			skyNews.setProduct("Sky News");
			catalogueRepository.save(skyNews);

			Catalogue skySportsNews = new Catalogue();
			skySportsNews.setCategory("News");
			skySportsNews.setProduct("Sky Sports News");
			catalogueRepository.save(skySportsNews);
		} else {
            LOGGER.info("Database is not Empty, doing nothing");
		}
	}
}
