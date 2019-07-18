<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>${title}</title>
<script type="text/javascript" src="js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/ajax.js" charset="utf-8"></script>
</head>

<body>
	<center>
		<table width="99%" border="0" cellpadding="5" cellspacing="1" bgcolor="#E0EDB7" class="tab" id="tblData">
			<tr>
				<td height="50" align="center" bgcolor="#FFFFFF">物资名称</td>
				<td height="50" align="center" bgcolor="#FFFFFF">数量</td>
				<td height="50" align="center" bgcolor="#FFFFFF"><input type="button" id="btnAdd" value="十" /></td>
			</tr>
			<tr id="tRow0">
				<td bgcolor="#FFFFFF" align="center"><select name="goodsid" id="goodsid" style="width: 99%;" class="m2">
						<c:forEach items="${goodsList}" var="goods">
							<option value="${goods.goodsid }">${goods.goodsname }</option>
						</c:forEach>
				</select></td>
				<td bgcolor="#FFFFFF" align="center"><input type="text" name="num" style="width: 99%;" id="num" class="m3" /></td>
				<td bgcolor="#FFFFFF" align="center"><input type="hidden" name="ordercode" id="ordercode" class="m1"
					value="${ordercode }" /> <input type="hidden" id="hidNum" name="hidNum" value="0" /> <input type="button"
					id="btnSave" value="保存" /></td>
			</tr>
		</table>
	</center>
</body>
</html>
