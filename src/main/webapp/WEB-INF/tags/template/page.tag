<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>



<!DOCTYPE html>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <template:styles />
    
    <title>Document</title>
</head>
<body>
	<%-- Inject the page body here --%>
    <main>
	    <jsp:doBody/>
    </main>
</body>
</html>