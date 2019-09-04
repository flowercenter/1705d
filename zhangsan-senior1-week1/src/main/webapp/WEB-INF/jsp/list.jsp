<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
function fenye(cpage){
	$("[name='cpage']").val(cpage);
	$("form").submit();
	
}
$(function (){
	$("[name='checkall']").click(
			function(){
				var b=$("[name='checkall']").prop("chckall");
				$("[name='movie_id']").each(function(){
					$(this).prop("checked",b);
				});
			}
			
			);
	$("[name=fanxuan]").click(
			function(){
				$("[name='movie_id']").prop("checked",!$("[name='movie_id']").prop("checked"));
			}
	);
	<%-- $("[value='批量删除']").click(
			function(){
				var ids=$("[name='movie_id']:checked").map(
						function(){
							return $(this).val();
						}).get().join(",").val();
				location="<%=request.getContextPath()%>/dels.do?ids="+ids;
			}
			); --%>
});

</script>
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/list.do">
<input type="hidden" name="cpage">
 电影名：<input type="text" name="mohu1">
 <input type="button" value="批量删除">
 <input type="submit" value="搜索">
</form>
<table>
<tr>

<td><input type="button" value="反选" name="fanxuan">反选<input type="checkbox" name="checkall">编号</td>
<td>名称</td>
<td>介绍</td>
<td>导演</td>
<td>发行时间</td>
</tr>
<c:forEach items="${list}" var="bean">
<tr>
<td><input type="checkbox" value="${bean.id}" name="movie_id">${bean.id}</td>
<td>${bean.name}</td>
<td>${bean.introduce}</td>
<td>${bean.actor}</td>
<td>${bean.beginDate}</td>
</tr>
</c:forEach>
<tr>
<td>
<input type="button" value="首页" onclick="fenye(1)">
<input type="button" value="上一页" onclick="fenye(${pi.isIsFirstPage()?1:pi.getPrePage()})">
<input type="button" value="下一页" onclick="fenye(${pi.isIsLastPage()? pi.getPages():pi.getNextPage()})">
<input type="button" value="尾页" onclick="fenye(${pi.getPages()})">


</td>
</tr>
</table>
</body>
</html>