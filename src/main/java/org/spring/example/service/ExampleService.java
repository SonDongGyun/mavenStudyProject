package org.spring.example.service;

import java.util.List;

public interface ExampleService {

    /* @brief  사용자 정보 등록*/
    ExampleVO selectExample(ExampleVO vo) throws Exception;

    int selectCountExample(ExampleVO vo) throws Exception;

    List<ExampleVO> selectListExample(ExampleVO vo, int startRow, int limitRow) throws Exception;

    /* @brief  사용자 정보 등록*/
    int insertExample(ExampleVO vo) throws Exception;

    /* @brief  사용자 정보 수정 */
    int updateExample(ExampleVO vo) throws Exception;

    /* @brief  사용자 삭제 */
    int deleteExample(ExampleVO vo) throws Exception;
}