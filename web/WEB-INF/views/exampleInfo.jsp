<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>${exampleTitle}</title>
</head>
<style type="text/css">
    table, thead, tbody { border: 1px solid #000000;border-collapse:collapse; }
    th, td { border:1px solid #000000;padding:10px; }
    tfoot { text-align:right; }
</style>
<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("btnList").addEventListener("click", function() {
            history.back();
        });

        document.getElementById("btnRemove").addEventListener("click", function() {
            if(confirm("해당 글을 삭제하시겠습니까?") == true) {
                window.location.href = "./exampleRemove.do?number=" + getParameter("number");
            }
        });

        document.getElementById("btnRevise").addEventListener("click", function() {
            window.location.href = "./exampleRevise.do?number=" + getParameter("number");
        });
    });

    var getParameter = function(param) {
        let returnValue;
        let url = location.href;
        let parameters = (url.slice(url.indexOf("?") + 1, url.length)).split("&");
        for(let i = 0; i < parameters.length; i++) {
            let varName = parameters[i].split("=")[0];
            if(varName.toUpperCase() == param.toUpperCase()) {
                returnValue = parameters[i].split("=")[1];
                return decodeURIComponent(returnValue);
            }
        }
    }
</script>
<body>
<h3>${exampleName} : ${exampleTitle}</h3>
<table>
    <tbody>
    </tbody>
    <tr>
        <th>제목</th>
        <td>${exampleTitle}</td>
    </tr>
    <tr>
        <th>이름</th>
        <td>${exampleName}(${exampleId})</td>
    </tr>
    <tr>
        <th>개봉일</th>
        <td>${exampleDate}</td>
    </tr>
    <tr>
        <th>내용</th>
        <td>${exampleInfo}</td>
    </tr>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="2">
            <button id="btnList" type="button">리스트</button>
            <button id="btnRemove" type="button">글삭제</button>
            <button id="btnRevise" type="button">글수정</button>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>