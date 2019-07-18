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
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/css_2.css" rel="stylesheet" type="text/css" />
<link href="css/nzcms_top.css" rel="stylesheet" type="text/css">
</head>

<body>
	<table width="1004" border="0" align="center" cellpadding="1" cellspacing="10" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
		<tr>
			<td align="center" valign="top" bgcolor="#FFFFFF">
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td align="left">
							<div class="z" id="z">
								<table width="99%" border="0" cellpadding="5" cellspacing="1" bgcolor="#E0EDB7">
									<tr>
										<td height="30" colspan="8" align="left" background="images/nzcms/list_bg.gif" class="white14B">我的租赁订单明细</td>
									</tr>
									<tr>
										<td align="center" bgcolor="#FFFFFF">订单号</td>
										<td align="center" bgcolor="#FFFFFF">下单日期</td>
										<td align="center" bgcolor="#FFFFFF">结算方式</td>
										<td align="center" bgcolor="#FFFFFF">状态</td>
										<td align="center" bgcolor="#FFFFFF">租赁天数</td>
										<td align="center" bgcolor="#FFFFFF">当前金额</td>
										<td align="center" bgcolor="#FFFFFF">租赁物资数</td>
									</tr>
									<tr align="center" bgcolor="#FFFFFF">
										<td align="center">${orders.ordercode}</td>
										<td align="center">${orders.addtime}</td>
										<td align="center">${orders.way}</td>
										<td align="center">${orders.status}</td>
										<td align="center">${days}</td>
										<td align="center">${total}</td>
										<td align="center">${sum}</td>
									</tr>
								</table>
								<table height="15" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td></td>
									</tr>
								</table>
								<table width="99%" border="0" cellpadding="5" cellspacing="1" bgcolor="#E0EDB7">
									<tr>
										<td height="30" colspan="8" align="left" background="images/nzcms/list_bg.gif" class="white14B">物资明细</td>
									</tr>
									<tr>
										<td align="center" bgcolor="#FFFFFF">订单号</td>
										<td align="center" bgcolor="#FFFFFF">建材</td>
										<td align="center" bgcolor="#FFFFFF">数量</td>
										<td align="center" bgcolor="#FFFFFF">单价</td>
									</tr>
									<c:forEach items="${itemsList}" var="items">
										<tr align="center" bgcolor="#FFFFFF">
											<td align="center">${items.ordercode}</td>
											<td align="center">${items.goodsname}</td>
											<td align="center">${items.num}</td>
											<td align="center">${items.price}</td>
										</tr>
									</c:forEach>
								</table>
								<table height="50" border="0" cellpadding="0" cellspacing="0" width="99%">
									<tr align="center">
										<td><input type="button" onclick="window.print();" value="打印"></td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
