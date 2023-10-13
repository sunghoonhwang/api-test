package com.samsungsds.eshop.ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value="/api/testjobs")
public class AdController {
    private Logger logger = LoggerFactory.getLogger(AdController.class);
    private final AdRepository adRepository;
    private static final Random random = new Random();
    private static final int MAX_ADS_TO_SERVE = 2;

    public AdController(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Void> addTestJob(@RequestBody Ad testJob) {
        adRepository.save(testJob);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Ad>> getRandomAds() {
        logger.info("getRandomAds");
        List<Ad> allAds = Lists.newArrayList(adRepository.findAll());
	
	try{
           Thread.sleep(150);
        }catch(InterruptedException e){
           e.printStackTrace();
        }

        return ResponseEntity.ok(allAds);
    }
}
