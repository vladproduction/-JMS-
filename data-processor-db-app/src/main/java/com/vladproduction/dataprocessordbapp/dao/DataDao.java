package com.vladproduction.dataprocessordbapp.dao;

import com.vladproduction.dataprocessordbapp.model.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {

    private JdbcTemplate jdbcTemplate;

    public DataDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveData(Data data){
        jdbcTemplate.update("insert into data (name, type, isTrue) values(?, ?, ?)",
                data.getName(), data.getType(), data.isTrue() ? 1:0);
    }



}
