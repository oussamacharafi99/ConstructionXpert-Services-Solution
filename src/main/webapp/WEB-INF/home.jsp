<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="/CSS/style.css"%>
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Home Build</title>
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
    <div class="header2">
        <div class="header-wrapper">
            <div class="logo">
                <img src="https://i.ibb.co/HzkVrgC/4.png" width="100%">
            </div>

            <div class="list">
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Services</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="hero">
        <div class="left">
            <h1>WE <em>BUILD</em> YOUR <em>DREAM</em></h1>
            <p>it is a long established fact that a reader will be distracted <em>by the reabdable content</em>.</p>
        </div>
        <div class="right">
            <div class="carre">
                <swiper-container class="mySwiper" direction="vertical" pagination="true" pagination-clickable="true" autoPlay="true">
                    <swiper-slide><img src="https://i.ibb.co/z87VNnC/Adobe-Stock-192077668-Preview.jpg" alt=""></swiper-slide>
                    <swiper-slide><img src="https://i.ibb.co/Nx4gSWw/Adobe-Stock-298573439-Preview.jpg" alt=""></swiper-slide>
                    <swiper-slide><img src="https://i.ibb.co/xMkrHzN/Adobe-Stock-346885013-Preview.jpg" alt=""></swiper-slide>
                    <swiper-slide><img src="https://i.ibb.co/MkSfdMb/Adobe-Stock-346885050-Preview.jpg" alt=""></swiper-slide>
                </swiper-container>
            </div>
            <div class="carre2">
                <swiper-container class="mySwiper" direction="vertical" pagination="true" pagination-clickable="true" autoPlay="true">
                    <swiper-slide><img src="https://i.ibb.co/LP5BhCj/Adobe-Stock-283185674.jpg" alt=""></swiper-slide>
                    <swiper-slide><img src="https://i.ibb.co/bvqnwWj/Adobe-Stock-602461020.jpg" alt=""></swiper-slide>
                    <swiper-slide><img src="https://i.ibb.co/CJZZf4Q/Adobe-Stock-387867515.jpg" alt=""></swiper-slide>
                    <swiper-slide><img src="https://i.ibb.co/FH7McHX/Adobe-Stock-602461037.jpg" alt=""></swiper-slide>
                    <swiper-slide><img src="https://i.ibb.co/vhbhjqr/Adobe-Stock-629756205.jpg" alt=""></swiper-slide>
                    <swiper-slide><img src="https://i.ibb.co/sbWjbCD/Adobe-Stock-775963396.jpg" alt=""></swiper-slide>
                </swiper-container>
            </div>

        </div>
    </div>
</section>
<section class="Service">
    <h1><em>Services</em></h1>
</section>
<section class="About">
    <h1><em>About</em></h1>
</section>



<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-element-bundle.min.js"></script>
<script src="script.js"></script>
</body>
</html>
