package com.vladproduction.dataprocessordbapp;

import com.vladproduction.dataprocessordbapp.dao.DataDao;
import com.vladproduction.dataprocessordbapp.model.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DataProcessorDbAppApplicationTests {


    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    DataDao dataDao;

    @BeforeEach
    public void init(){
        dataDao.createTable();
        dataDao.clearTable();
    }
    @Test
    void testTrueData() throws InterruptedException {
        Data data = new Data("data1-h2", 100, true);
        verifyData(data);
    }

    @Test
    void testFalseData() throws InterruptedException {
        Data data = new Data("data2", 150, false);
        verifyData(data);
    }


    private void verifyData(Data data) throws InterruptedException {
        int beforeSent = dataDao.countAllData();
        ResponseEntity<Void> voidResponseEntity1 = testRestTemplate.postForEntity("/api/producer", data, Void.class);

        Assertions.assertTrue(voidResponseEntity1.getStatusCode().value() == 200);
        //todo --> embeeded adjustice  and thread.sleep
        Thread.sleep(1000);
        int afterSent = dataDao.countAllData();
        Assertions.assertTrue(beforeSent + 1 == afterSent);
        List<Data> dataList = dataDao.findAll();
        Assertions.assertTrue(dataList.size() == 1);
        Data actualData = dataList.get(0);
        Assertions.assertEquals(data, actualData);
    }

}
