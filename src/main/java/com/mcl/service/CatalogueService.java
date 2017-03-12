package com.mcl.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mcl.entity.Catalogue;
import com.mcl.respository.CatalogueRespository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogueService {
    private static final Logger LOGGER = LogManager.getLogger(CatalogueRespository.class);

    @Autowired
    private CatalogueRespository catalogueRepository;

    public List<Catalogue> findByCategoryAndLocation(String category, String location) {
        List<Catalogue> catalogue;
        if (catalogueRepository != null) {
            catalogue = catalogueRepository.findByCategoryAndLocationId(category, location);
        } else {
            LOGGER.error("catalogueRepository is null, it hasn't been autowired!");
            catalogue = new ArrayList<Catalogue>();
        }

        return catalogue;
    }
}