<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Transacoes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body class="container">
    <form action="<c:url value="/transacoes"/>" method="POST">
        <div class="form-group">
            <label for="ticker">Ticker</label>
            <input id="ticker" name="ticker" class="form-control">
        </div>
        <div class="form-group">
            <label for="data">data</label>
            <input id="data" name="data" class="form-control">
        </div>
        <div class="form-group">
            <label for="preco">Preço</label>
            <input id="preco" name="preco" class="form-control">
        </div>
        <div class="form-group">
            <label for="quantidade">Quantidade</label>
            <input id="quantidade" name="quantidade" class="form-control">
        </div>
        <div class="form-group">
            <label for="tipo">Tipo</label>
            <input id="tipo" name="tipo" class="form-control">
        </div>

        <input type="submit" value="Gravar" class="mt-2 btn-primary">
    </form>

    <h1 class="text-center">Lista de Transacoes</h1>
    <table class="table table-hover table-striped table-bordered">
        <thead>
            <tr>
                <th class="col">TICKER</th>
                <th>DATA</th>
                <th>PRECO</th>
                <th>QUANTIDADE</th>
                <th>TIPO</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${transacoes}" var="t">
                <tr>
                    <td>${t.ticker}</td>
                    <td>${t.data}</td>
                    <td>${t.preco}</td>
                    <td>${t.quantidade}</td>
                    <td>${t.tipo}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
