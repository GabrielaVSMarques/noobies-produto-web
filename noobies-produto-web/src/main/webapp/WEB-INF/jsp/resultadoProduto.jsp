<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title> Cadastro de Produto</title>        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">       
    </head>
    <body>
        <h1>Resultado do Cadastro de Cliente<c:out value="${metodoHttp}"/></h1>
        <div>
            <div>Nome: <c:out value="${nome}" /></div>
            <div>CPF: <c:out value="${cpf}" /></div>
            <div>Endereco: <c:out value="${endereco}"/></div>
            <div>Telefone: <c:out value="${telefone}" /></div>
            <div>Email: <c:out value="${nome}" /></div>
        </div>
    </body>
</html>
