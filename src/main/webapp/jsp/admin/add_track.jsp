<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="properties.content"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width = device-width, initial-scale = 1">
    <link rel="icon" href="../../images/logogreen.png">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/registerStyle.css">
    <script rel="script" src="../../js/jquery-3.3.1.min.js"></script>
    <script rel="script" src="../../js/validator.js"></script>
    <title><fmt:message key="page.addTrack.title"/></title>
</head>
<body>
<div class="container text-center">
    <br><br>
    <a href="${pageContext.request.contextPath}/web?command=main">
        <img src="../../images/logogreen.png" height="90px" width="105px">
    </a>
    <br><br><br>
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <form class="form-register" onsubmit="return checkAudioTrack()" action="${pageContext.request.contextPath}/web" method="POST">
                <input type="hidden" name="command" value="add_audio_track"/>
                <input type="text" name="name" class="form-control"
                       placeholder="<fmt:message key="page.addTrack.name"/>">
                <br>
                <input type="text" name="artist" class="form-control"
                       placeholder="<fmt:message key="page.addTrack.artist"/>">
                <br>
                <input type="text" name="album" class="form-control"
                       placeholder="<fmt:message key="page.addTrack.album"/>">
                <br>
                <input type="text" name="studio" class="form-control"
                       placeholder="<fmt:message key="page.addTrack.studio"/>">
                <br>
                <input type="text" name="date" class="form-control"
                       placeholder="<fmt:message key="page.addTrack.date"/>">
                <br>
                <input type="text" name="genre" class="form-control"
                       placeholder="<fmt:message key="page.addTrack.genre"/>">
                <br>
                <input type="text" name="price" class="form-control"
                       placeholder="<fmt:message key="page.addTrack.price"/>">
                <br>
                <input type="text" name="link" class="form-control"
                       placeholder="<fmt:message key="page.addTrack.link"/>">
                <br>
                <input type="text" name="imageLink" class="form-control"
                       placeholder="<fmt:message key="page.addTrack.linkImage"/>">
                <br>
                <button type="submit" name="addTrackButton" class="btn">
                    <fmt:message key="page.addTrack.add"/>
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
