package org.spring.example.service.impl;

import org.spring.example.service.ExampleDAO;
import org.spring.example.service.ExampleVO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("exampleDaoMyBatis")
public class ExampleDAOMyBatis implements ExampleDAO {

    @Resource(name="exampleMapper")
    private ExampleMapper mybatis;

    public ExampleDAOMyBatis() {
        System.out.println("===> ExampleDAOMyBatis 생성");
    }

    public ExampleVO selectExample(ExampleVO vo) throws Exception {
        System.out.println("===> MyBatis로 selectExample() 기능 처리");
        return (ExampleVO) mybatis.selectExample(vo);
    }

    public int selectCountExample(ExampleVO vo) throws Exception {
        System.out.println("===> MyBatis로 selectCountExample() 기능 처리");
        return mybatis.selectCountExample(vo);
    }

    public List<ExampleVO> selectListExample(ExampleVO vo, int startRow, int limitRow) throws Exception {
        System.out.println("===> MyBatis로 selectListExample() 기능 처리");
        return mybatis.selectListExample(vo, startRow, limitRow);
    }

    public int insertExample(ExampleVO vo) throws Exception {
        System.out.println("===> MyBatis로 insertExample() 기능 처리");
        return mybatis.insertExample(vo);
    }

    public int updateExample(ExampleVO vo) throws Exception {
        System.out.println("===> MyBatis로 updateExample() 기능 처리");
        return mybatis.updateExample(vo);
    }

    public int deleteExample(ExampleVO vo) throws Exception {
        System.out.println("===> MyBatis로 deleteExample() 기능 처리");
        return mybatis.deleteExample(vo);
    }
}