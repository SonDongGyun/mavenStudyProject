package org.spring.example.service.impl;

import org.spring.example.service.ExampleDAO;
import org.spring.example.service.ExampleService;
import org.spring.example.service.ExampleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    // @Page 409
    @Resource(name="exampleDaoMyBatis")
    private ExampleDAO exampleDAO;

    public ExampleVO selectExample(ExampleVO vo) throws Exception {
        return exampleDAO.selectExample(vo);
    }

    public int selectCountExample(ExampleVO vo) throws Exception {
        return exampleDAO.selectCountExample(vo);
    }

    public List<ExampleVO> selectListExample(ExampleVO vo, int startRow, int limitRow) throws Exception {
        return exampleDAO.selectListExample(vo, startRow, limitRow);
    }

    public int insertExample(ExampleVO vo) throws Exception {
        return exampleDAO.insertExample(vo);
    }

    public int updateExample(ExampleVO vo) throws Exception {
        return exampleDAO.updateExample(vo);
    }

    public int deleteExample(ExampleVO vo) throws Exception {
        return exampleDAO.deleteExample(vo);
    }
}