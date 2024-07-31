<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
  <title>게시판 리스트</title>
</head>
<style type="text/css">
  table, thead, tbody, tfoot { border:1px solid #000000;border-collapse:collapse; }
  tfoot { text-align:right; }
  th, td { border:1px solid #000000;padding:10px; }
  tbody > tr > td { cursor:pointer;cursor:hand; }
  tbody > tr > td:first-child { text-align:center; }
  button { cursor:pointer;cursor:hand; }

  ul.pagination { list-style:none;margin:0;padding:0; }
  li.pagination-btn { margin-right:5px;margin-left:5px;border:0;float:left;}
  li.active { font-weight:bold; }
  a.pagination-link { color:#000000;text-decoration:none; }
</style>
<script type="text/javascript">
  document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("btnWrite").addEventListener("click", function() {
      window.location.href = "./exampleWrite.do";
    });

    document.getElementsByClassName("")
  });

  function exampleMovePage(page) {
    window.location.href = "exampleList.do?page=" + page;
  }
</script>
<body>
<h1>${headTitle}</h1>
<table>
  <thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>이름</th>
    <th>날짜</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="example" items="${exampleList}">
    <tr onClick="window.location.href='/SpringExample_war_exploded/exampleInfo.do?number=${example.exampleNumber}'">
      <td>${example.exampleNumber}</td>
      <td>${example.exampleTitle}</td>
      <td>${example.exampleName}(${example.exampleId})</td>
      <td><fmt:formatDate value="${example.exampleDate}" pattern="yyyy-MM-dd"/></td>
    </tr>
  </c:forEach>
  </tbody>
  <tfoot>
  <tr>
    <td colspan="4">
      <button id="btnWrite" type="button">새 글쓰기</button>
    </td>
  </tr>
  </tfoot>
</table>
<br/>
${examplePagination}
</body>
</html>