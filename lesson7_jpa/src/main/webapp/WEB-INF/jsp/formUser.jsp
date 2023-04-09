<%--
  Created by IntelliJ IDEA.
  User: 79171
  Date: 04.07.2021
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head >
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>

</head>
<body>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <form:form modelAttribute="user" action="/users">
                <div>
                    <div class="form-group">
                        <label>Name</label>
                        <div><form:input path="name" type="text" class="form-control"/></div>
                       </div>
                    <div class="form-group">
                        <label>Age</label>
                        <div><form:input path="age" type="text" class="form-control"/></div>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
