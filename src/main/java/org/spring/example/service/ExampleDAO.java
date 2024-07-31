package org.spring.example.service;

import java.util.List;

public interface ExampleDAO {

    ExampleVO selectExample(ExampleVO vo) throws Exception;

    int selectCountExample(ExampleVO vo) throws Exception;

    List<ExampleVO> selectListExample(ExampleVO vo, int startRow, int limitRow) throws Exception;

    int insertExample(ExampleVO vo) throws Exception;

    int updateExample(ExampleVO vo) throws Exception;

    int deleteExample(ExampleVO vo) throws Exception;
}