<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
	<head>
		<c:import url='/WEB-INF/JSP/head.jsp'>
			<c:param name='title' value='Statistieken'/>
		</c:import>
	</head>
<body>
	<c:import url='/WEB-INF/JSP/head.jsp'/>
	<h1>Statistiek</h1>
	<c:if test = "${not empty statistiek}">
		<table>
			<thead>
			<tr>
				<th>URL</th><th>aantal requests</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var='entry' items='${statistiek}'>
					<tr>
						<td>${entry.key}</td>
						<td>${entry.value}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>