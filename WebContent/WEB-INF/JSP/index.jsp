<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@page import ='java.time.LocalDate'%>
<%@page import ='java.time.DayOfWeek'%>
<!doctype html>
<html lang='nl'>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'>
		<c:param name='title' value='Frituur Frida'/>
	</c:import>
</head>
	<body>
		<h1>Frituur Frieda</h1>
		<h2>Vandaag zijn we ${openGesloten}</h2>
		<img src ="images/${openGesloten}.png" alt="${openGesloten}">
		<h3>Onze Locatie</h3>
		<dl>
			<dt>Straat:</dt><dd>${locatie.straat} ${locatie.huisNr}</dd>
			<dt>Gemeente:</dt><dd>${locatie.gemeente.naam} ${locatie.gemeente.postCode}</dd>
		</dl>
		<div>Telefoonnummer helpdesk:
		<a href="tel:+${telefoonNummerHelpDesk.replace('/','')}">${telefoonNummerHelpDesk}</a></div>
	</body>
</html>