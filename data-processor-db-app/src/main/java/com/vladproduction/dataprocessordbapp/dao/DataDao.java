package com.vladproduction.dataprocessordbapp.dao;

import com.vladproduction.dataprocessordbapp.model.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public int countAllData(){
        return jdbcTemplate.queryForObject("select count(*) from data", Integer.class);
    }

    public void createTable(){
        String sql = "create table if not exists data\n" +
                "(\n" +
                "    id     int auto_increment\n" +
                "        primary key,\n" +
                "    name   varchar(45) null,\n" +
                "    type   int         null,\n" +
                "    isTrue tinyint     null\n" +
                ");";
        jdbcTemplate.execute(sql);
    }

    public void clearTable(){
        String sql = "delete from data";
        jdbcTemplate.execute(sql);
    }

    public List<Data> findAll(){
        String sql = "select * from data";
        return jdbcTemplate.query(sql, new RowMapper<Data>() {
            @Override
            public Data mapRow(ResultSet rs, int rowNum) throws SQLException {
                String name = rs.getString("name");
                int type = rs.getInt("type");
                boolean isTrue = rs.getBoolean("isTrue");
                Data data = new Data(name, type, isTrue);
                return data;
            }
        });
    }



}
