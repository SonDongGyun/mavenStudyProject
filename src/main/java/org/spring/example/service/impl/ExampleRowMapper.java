package org.spring.example.service.impl;

import org.spring.example.service.ExampleVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExampleRowMapper implements RowMapper<ExampleVO> {

    public ExampleVO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ExampleVO example = new ExampleVO();
        example.setExampleNumber(rs.getInt("example_number"));
        example.setExampleId(rs.getString("example_id"));
        example.setExampleName(rs.getString("example_name"));
        example.setExampleTitle(rs.getString("example_title"));
        example.setExampleInfo(rs.getString("example_info"));
        example.setExampleDate(rs.getDate("example_date"));
        return example;
    }
}