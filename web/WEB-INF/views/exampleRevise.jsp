<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>${exampleTitle}</title>
</head>
<style type="text/css">
    table, thead, tbody, tfoot { border:1px solid #000000;border-collapse:collapse; }
    tfoot { text-align:right; }
    th, td { border:1px solid #000000;padding:10px; }
    .fakeDisabled { cursor:default;background-color:#F8F8F8;color:#545454;border-color:#D6D6D6; }
</style>
<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("btnModify").addEventListener("click", function() {
            submitModifyExample();
        });
    });

    function submitModifyExample() {

        if(document.getElementsByName("exampleName")[0].value.replace(/\s/gi, "") == "") {
            alert("이름을 입력하지 않았습니다.\n이름을 입력해 주세요.");
            document.getElementsByName("exampleName")[0].focus();
            return false;
        }

        if(document.getElementsByName("exampleTitle")[0].value.replace(/\s/gi, "") == "") {
            alert("제목을 입력하지 않았습니다.\n제목을 입력해 주세요.");
            document.getElementsByName("exampleTitle")[0].focus();
            return false;
        }

        if(document.getElementsByName("exampleDate")[0].value.replace(/\s/gi, "") == "") {
            alert("날짜를 입력하지 않았습니다.\n날짜를 입력해 주세요.");
            document.getElementsByName("exampleDate")[0].focus();
            return false;
        }

        document.getElementById("formWriteExample").method = "POST";
        document.getElementById("formWriteExample").action = "./exampleModifyWrite.do";
        document.getElementById("formWriteExample").submit();
    }
</script>
<body>
<h3>신규 글 등록</h3>
<input type="hidden" id="verificationId" value="false"/>
<form id="formWriteExample">
    <input type="hidden" name="exampleNumber" value="${exampleNumber}"/>
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <td>
                <input type="text" class="fakeDisabled" name="exampleId" value="${exampleId}" readonly/>
            </td>
        </tr>
        <tr>
            <th>이름</th>
            <td>
                <input type="text" name="exampleName" value="${exampleName}"/>
            </td>
        </tr>
        <tr>
            <th>제목</th>
            <td>
                <input type="text" name="exampleTitle" value="${exampleTitle}"/>
            </td>
        </tr>
        <tr>
            <th>날짜</th>
            <td>
                <input type="date" name="exampleDate" value="${exampleDate}"/>
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="exampleInfo">"${exampleInfo}"</textarea></td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="2">
                <button id="btnModify" type="button">글수정</button>
            </td>
        </tr>
        </tfoot>
    </table>
</form>
</body>
</html>