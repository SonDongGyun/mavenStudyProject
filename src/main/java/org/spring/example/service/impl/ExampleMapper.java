package org.spring.example.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.example.service.ExampleVO;

import java.util.List;

@Mapper
public interface ExampleMapper {

    ExampleVO selectExample(ExampleVO vo) throws Exception;

    int selectCountExample(ExampleVO vo) throws Exception;

    List<ExampleVO> selectListExample(ExampleVO vo, @Param("startRow") int startRow, @Param("limitRow") int limitRow) throws Exception;

    int insertExample(ExampleVO vo) throws Exception;

    int updateExample(ExampleVO vo) throws Exception;

    int deleteExample(ExampleVO vo) throws Exception;
}