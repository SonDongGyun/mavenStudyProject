package org.spring.example.controller;

import org.spring.example.service.ExampleService;
import org.spring.example.service.ExampleVO;
import org.spring.example.util.OutputPagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ExampleController {

    @Resource(name="exampleService")
    private ExampleService exampleService;

    Map<String, String> resultMap = new HashMap<String, String>();

    @RequestMapping(value = "/example.do", method = RequestMethod.GET)
    public String ExampleMain() {
        return "example";
    }

    @RequestMapping(value = "/exampleInfo.do", method = RequestMethod.GET)
    public String exampleInfo(ExampleVO vo, HttpServletRequest request, Model model) throws Exception {

        if(request.getParameter("number").isEmpty() == false) {

            vo.setExampleNumber(Integer.parseInt(request.getParameter("number")));
            ExampleVO exampleVO = exampleService.selectExample(vo);
            model.addAttribute("exampleId", exampleVO.getExampleId());
            model.addAttribute("exampleName", exampleVO.getExampleName());
            model.addAttribute("exampleTitle", exampleVO.getExampleTitle());
            model.addAttribute("exampleInfo", exampleVO.getExampleInfo());
            model.addAttribute("exampleDate", exampleVO.getExampleDate());
        }
        return "exampleInfo";
    }

    @RequestMapping(value = "/exampleList.do")
    public String exampleList(ExampleVO vo, HttpServletRequest request, Model model) throws Exception {

        int totalRow = exampleService.selectCountExample(vo);       // 해당 테이블의 전체 갯수
        int choicePage = 0;                                         // 선택 페이지
        int startRow = 0;                                           // MySQL LIMIT 시작점
        int limitRow = 10;                                          // MySQL LIMIT 종료점( 출력될 가로(row)의 개수를 지정 )

        if(request.getParameter("page") != null && request.getParameter("page").length() > 0) {
            choicePage = Integer.parseInt(request.getParameter("page"));
            startRow = (choicePage - 1) * limitRow;
        } else {
            choicePage = 1;
            startRow = 0;
        }

        model.addAttribute("exampleList", exampleService.selectListExample(vo, startRow, limitRow));
        model.addAttribute("examplePagination", OutputPagination.outputServletPagination(choicePage, limitRow, totalRow, "exampleMovePage"));

        return "exampleList";
    }

    @RequestMapping(value = "/exampleWrite.do")
    public String exampleWrite() throws Exception {
        return "exampleWrite";
    }

    @RequestMapping(value = "/exampleRevise.do", method = RequestMethod.GET)
    public String exampleRevision(ExampleVO vo, HttpServletRequest request, Model model) throws Exception {

        vo.setExampleNumber(Integer.parseInt(request.getParameter("number")));

        ExampleVO exampleVO = exampleService.selectExample(vo);
        // System.out.println( "exampleVO.toString() : " + exampleVO.toString());

        model.addAttribute("exampleNumber", request.getParameter("number"));
        model.addAttribute("exampleId", exampleVO.getExampleId());
        model.addAttribute("exampleName", exampleVO.getExampleName());
        model.addAttribute("exampleTitle", exampleVO.getExampleTitle());
        model.addAttribute("exampleInfo", exampleVO.getExampleInfo());
        model.addAttribute("exampleDate", exampleVO.getExampleDate());

        return "exampleRevise";
    }

    @ResponseBody
    @RequestMapping(value = "/verificationDuplicateId.do", method = RequestMethod.POST)
    public Map verificationDuplicateId(ExampleVO vo, HttpServletRequest request ) throws Exception {

        if(request.getParameter( "exampleId" ).isEmpty() == false) {
            vo.setExampleId(request.getParameter("exampleId"));
        } else {
            vo.setExampleId(null);
        }

        int resultCount = exampleService.selectCountExample(vo);
        // System.out.println( "exampleVO.toString() : " + exampleVO.toString());

        if(resultCount > 0) {
            resultMap.put("result", "fail");
            resultMap.put("message", request.getParameter( "exampleId" ) + "는\n이미 사용중인 아이디 입니다.");
        } else {
            resultMap.put("result", "success");
            resultMap.put("message", "사용가능한 아이디 입니다.");
        }

        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/exampleRegistryWrite.do", method = RequestMethod.POST)
    public void exampleRegistryWrite(ExampleVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(request.getParameter("exampleId").isEmpty() == false) {
            vo.setExampleId(request.getParameter("exampleId"));
        }

        if(request.getParameter("exampleName").isEmpty() == false) {
            vo.setExampleName(request.getParameter("exampleName"));
        }

        if(request.getParameter("exampleTitle").isEmpty() == false) {
            vo.setExampleTitle(request.getParameter("exampleTitle"));
        }

        if(request.getParameter("exampleInfo").isEmpty() == false) {
            vo.setExampleInfo(request.getParameter("exampleInfo"));
        }

        if(request.getParameter("exampleDate").isEmpty() == false) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            vo.setExampleDate(formatter.parse(request.getParameter("exampleDate")));
        }

        int resultNumber = exampleService.insertExample(vo);
        // System.out.println( "exampleVO.toString() : " + vo.toString());

        if(resultNumber > 0) {
            response.sendRedirect("./exampleList.do");
        } else {
            // 참고 : https://redcoder.tistory.com/195
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>alert('해당 글을 등록하는데 실패하였습니다.');</script>");
            out.flush();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/exampleModifyWrite.do", method = RequestMethod.POST)
    public void exampleModifyWrite(ExampleVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(request.getParameter("exampleNumber").isEmpty() == false) {
            vo.setExampleNumber(Integer.parseInt(request.getParameter("exampleNumber")));
        }

        if(request.getParameter("exampleId").isEmpty() == false) {
            vo.setExampleId(request.getParameter("exampleId"));
        }

        if(request.getParameter("exampleName").isEmpty() == false) {
            vo.setExampleName(request.getParameter("exampleName"));
        }

        if(request.getParameter("exampleTitle").isEmpty() == false) {
            vo.setExampleTitle(request.getParameter("exampleTitle"));
        }

        if(request.getParameter("exampleInfo").isEmpty() == false) {
            vo.setExampleInfo(request.getParameter("exampleInfo"));
        }

        if(request.getParameter("exampleDate").isEmpty() == false) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            vo.setExampleDate(formatter.parse(request.getParameter("exampleDate")));
        }

        int resultNumber = exampleService.updateExample(vo);
        // System.out.println( "exampleVO.toString() : " + vo.toString());

        if(resultNumber > 0) {
            response.sendRedirect("./exampleInfo.do?number=" + vo.getExampleNumber());
        } else {
            // 참고 : https://redcoder.tistory.com/195
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>alert('해당 글을 수정하는데 실패하였습니다.');</script>");
            out.flush();
        }
    }

    @RequestMapping(value = "/exampleRemove.do", method = RequestMethod.GET)
    public void exampleRemove(ExampleVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(request.getParameter("number").isEmpty() == false) {
            vo.setExampleNumber(Integer.parseInt(request.getParameter("number")));
        }

        int resultNumber = exampleService.deleteExample(vo);

        if(resultNumber > 0) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>");
            out.println("alert('해당 글이 삭제되었습니다.');");
            out.println("window.location.href='./exampleList.do';");
            out.println("</script>");
            out.flush();
        } else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>alert('해당 글을 삭제하는데 실패하였습니다.');</script>");
            out.flush();
        }
    }
}