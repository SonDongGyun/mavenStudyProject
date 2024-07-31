<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>${exampleTitle}</title>
</head>
<style type="text/css">
    table, thead, tbody, tfoot { border:1px solid #000000;border-collapse:collapse; }
    tfoot { text-align:right; }
    th, td { border:1px solid #000000;padding:10px; }
</style>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("btnVerification").addEventListener("click", function() {
            duplicateCheckId();
        });

        document.getElementById("btnList").addEventListener("click", function() {
            history.back();
        });

        document.getElementById("btnRegistry").addEventListener("click", function() {
            submitRegistryExample();
        });
    });

    function duplicateCheckId() {
        jQuery.ajax({
            url : "./verificationDuplicateId.do"
            , type : "POST"
            , data : {
                "exampleId" : document.getElementsByName("exampleId")[0].value
            }
            , success:function(json) {
                if(json.result == "success") {
                    alert(json.message);
                    document.getElementsByName("exampleName")[0].focus();
                    document.getElementById("verificationId").value = "true";
                } else {
                    alert(json.message);
                    document.getElementsByName("exampleId")[0].value = "";
                    document.getElementsByName("exampleId")[0].focus();
                }
            }
        });
    }

    function submitRegistryExample() {

        if(document.getElementById("verificationId").value == "false") {
            alert("ID 중복체크를 진행하지 않았습니다.\nID를 중복체크해 주세요.");
            document.getElementById("btnVerification").focus();
            return false;
        }

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
        document.getElementById("formWriteExample").action = "./exampleRegistryWrite.do";
        document.getElementById("formWriteExample").submit();
    }
</script>
<body>
<h3>신규 글 등록</h3>
<input type="hidden" id="verificationId" value="false"/>
<form id="formWriteExample">
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <td>
                <input type="text" name="exampleId" value=""/>
                <button id="btnVerification" type="button">중복확인</button>
            </td>
        </tr>
        <tr>
            <th>이름</th>
            <td>
                <input type="text" name="exampleName" value=""/>
            </td>
        </tr>
        <tr>
            <th>제목</th>
            <td>
                <input type="text" name="exampleTitle" value=""/>
            </td>
        </tr>
        <tr>
            <th>날짜</th>
            <td>
                <input type="date" name="exampleDate" value=""/>
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="exampleInfo"></textarea></td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="2">
                <button id="btnList" type="button">리스트</button>
                <button id="btnRegistry" type="button">글등록</button>
            </td>
        </tr>
        </tfoot>
    </table>
</form>
</body>
</html>