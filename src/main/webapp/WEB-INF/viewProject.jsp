<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        <%@include file="/CSS/dashboard.css"%>
    </style>
    <title>Document</title>
</head>
<body>
<header>
    <div class="contact">
        <div class="email">
            <i class="fa-solid fa-envelope"></i>
            <p>ou.charafi@gmail.com</p>
        </div>
        <div class="phone">
            <i class="fa-solid fa-phone"></i>
            <p>(+212) 628532671</p>
        </div>
        <div class="workTime">
            <i class="fa-solid fa-calendar-days"></i>
            <p>Sun-Sat 9:45 am</p>
        </div>
    </div>
    <div class="login">
        <button><i class="fa-solid fa-right-to-bracket"></i></button>
    </div>
</header>
<section class="main">
    <div class="menu">
        <div class="logo">
            <img src="https://i.ibb.co/HzkVrgC/4.png" width="100%">
        </div>
        <form id="option">
            <select id="mySelect" onchange="location = this.value;">
                <c:forEach items="${P1}" var="P">
                    <option value="ViewProject?id=${P.id}">${P.name}</option>
                </c:forEach>
            </select>
        </form>

        <div class="profile">
            <a href="#"><i class="fa-solid fa-user"></i></a>
        </div>
    </div>

</section>
</body>
</html>