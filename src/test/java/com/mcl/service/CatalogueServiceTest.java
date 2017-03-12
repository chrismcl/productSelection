package com.mcl.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import com.mcl.entity.Catalogue;
import com.mcl.respository.CatalogueRespository;

import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.Rule;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans-test.xml")
@Transactional
public class CatalogueServiceTest {

    @Autowired
    private CatalogueRespository catalogueRepository;

    @Before
    public void setUp() {
        catalogueRepository.deleteAllInBatch();
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testFindByCategoryAndLocationId() {
        List<Catalogue> catalogList = catalogueRepository.findAll();
        assertTrue(catalogList.isEmpty());

        Catalogue sport1 = new Catalogue();
        sport1.setCategory("Sports");
        sport1.setProduct("Man United TV");
        sport1.setLocationId("Manchester");
        catalogueRepository.save(sport1);

        Catalogue sport2 = new Catalogue();
        sport2.setCategory("Sports");
        sport2.setProduct("Man City TV");
        sport2.setLocationId("Manchester");
        catalogueRepository.save(sport2);

        Catalogue sport3 = new Catalogue();
        sport3.setCategory("Sports");
        sport3.setProduct("Leicester TV");
        sport3.setLocationId("Leicester");
        catalogueRepository.save(sport3);

        Catalogue news1 = new Catalogue();
        news1.setCategory("News");
        news1.setProduct("BBC Manchester TV");
        news1.setLocationId("Manchester");
        catalogueRepository.save(news1);

        catalogList = catalogueRepository.findByCategoryAndLocationId("Sports", "Manchester");
        for (Catalogue cat : catalogList) {
            assertTrue(cat.getLocationId().equals("Manchester"));
            assertTrue(cat.getCategory().equals("Sports"));
        }

        catalogList = catalogueRepository.findByCategoryAndLocationId("Sports", "Leicester");
        for (Catalogue cat : catalogList) {
            assertTrue(cat.getLocationId().equals("Leicester"));
            assertTrue(cat.getCategory().equals("Sports")); 
            assertTrue(cat.getProduct().equals("Leicester TV"));        
        }

        catalogList = catalogueRepository.findByCategoryAndLocationId("News", "Manchester");
        for (Catalogue cat : catalogList) {
            assertTrue(cat.getLocationId().equals("Manchester"));
            assertTrue(cat.getCategory().equals("News"));   
            assertTrue(cat.getProduct().equals("BBC Manchester TV"));       
        }

        catalogList = catalogueRepository.findByCategoryAndLocationId("News", "Leicester");
        assertTrue(catalogList.isEmpty());
    }

    @Test
    public void testFindByCategoryWithNoLocation() {
        List<Catalogue> catalogList = catalogueRepository.findAll();
        assertTrue(catalogList.isEmpty());

        Catalogue sport1 = new Catalogue();
        sport1.setCategory("Sports");
        sport1.setProduct("World Cup TV");
        catalogueRepository.save(sport1);

        catalogList = catalogueRepository.findByCategoryAndLocationId("Sports", "Leicester");
        for (Catalogue cat : catalogList) {
            assertNull(cat.getLocationId());
            assertTrue(cat.getCategory().equals("Sports")); 
            assertTrue(cat.getProduct().equals("World Cup TV"));        
        }
    }

    @Test
    public void testCategoryCannotBeEmpty() {
        Catalogue sport1 = new Catalogue();
        sport1.setCategory("");
        sport1.setProduct("World Cup TV");
        exception.expect(ConstraintViolationException.class);
        catalogueRepository.save(sport1);
    }

    @Test
    public void testProductCannotBeEmpty() {
        Catalogue sport1 = new Catalogue();
        sport1.setCategory("Sports");
        sport1.setProduct("");
        exception.expect(ConstraintViolationException.class);
        catalogueRepository.save(sport1);
    }

    @Test
    public void testCategoryCannotBeNull() {
        Catalogue sport1 = new Catalogue();
        sport1.setProduct("World Cup TV");
        exception.expect(ConstraintViolationException.class);
        catalogueRepository.save(sport1);
    }

    @Test
    public void testProductCannotBeNull() {
        Catalogue sport1 = new Catalogue();
        sport1.setCategory("Sports");
        exception.expect(ConstraintViolationException.class);
        catalogueRepository.save(sport1);
    }

    @Test
    public void testLocationIdCannotBeEmpty() {
        Catalogue news1 = new Catalogue();
        news1.setCategory("News");
        news1.setProduct("BBC Manchester TV");
        news1.setLocationId("");
        exception.expect(ConstraintViolationException.class);
        catalogueRepository.save(news1);
    }
}
