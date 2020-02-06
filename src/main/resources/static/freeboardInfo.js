$(function() {
        function getList() {
            $.ajax({
                url : "${pageContext.request.contextPath}/memberList",
                type : "get",
                dataType : "xml",
                success : function(data) {
                    var table = "" ;
                    $(data).find("member").each(function() {
                        table +="<tr>";
                        table +="<td>"+$(this).find("id").text()+"</td>";
                        table +="<td>"+$(this).find("password").text()+"</td>";
                        table +="<td>"+$(this).find("name").text()+"</td>";
                        table +="<td>"+$(this).find("email").text()+"</td>";
                        table +="<td>" ;
                        table += "<input type='button' value='삭제' id='del' name='"+$(this).find("id").text()+"' />";
                        table +="</tr>";
                    });
                    $("#tbody").append(table);    
                },
                error : function name() {
                    alert("실패")
                }
            });
        }// getList()끝
