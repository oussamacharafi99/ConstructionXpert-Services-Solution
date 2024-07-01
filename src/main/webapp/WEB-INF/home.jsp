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
        <a href="view"><i class="fa-solid fa-user"></i></a>
    </div>
</header>
<section class="main" id="home">
    <div class="header2">
        <div class="header-wrapper">
            <div class="logo">
                <img src="https://i.ibb.co/HzkVrgC/4.png" width="100%">
            </div>

            <div class="list">
                <ul>
                    <li><a href="#home">Home</a></li>
                    <li><a href="#Service">Services</a></li>
                    <li><a href="#About">About</a></li>
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
<section class="Service" id="Service">
    <h1><em>Services</em></h1>

    <div class="service-wrapper">
        <div class="card" id="card">
            <div class="img"><img src="https://i.ibb.co/Z6J5Xnx/pic1.jpg" width="100%" class="imm"></div>
            <div class="content">
                <h1>Construction <span><br> Engineering your dreams with us.</span></h1>
                <h2><i class="fa-solid fa-plus"></i></h2>
            </div>
        </div>
        <div class="card" id="card">
            <div class="img"><img src="https://i.ibb.co/3d40Tm1/pic2.jpg" width="100%" class="imm"></div>
            <div class="content">
                <h1>Construction <span><br> Engineering your dreams with us.</span></h1>
                <h2><i class="fa-solid fa-plus"></i></h2>
            </div>
        </div>
        <div class="card" id="card">
            <div class="img"><img src="https://i.ibb.co/nQg26WG/pic3.jpg" width="100%" class="imm"></div>
            <div class="content">
                <h1>Construction <span><br> Engineering your dreams with us.</span></h1>
                <h2><i class="fa-solid fa-plus"></i></h2>
            </div>
        </div>
        <div class="card1" id="card">
            <div class="mini-card">
                <p>Building</p>
                <h1>It better in concrete.</h1>
                <h2>When it comes to your house, don’t mess with the rest, trust the best. Making your vision come true, that is what we do.</h2>
                <div class="buttons">
                    <a href="#" id="a1" class="a1"></a>
                    <a href="#" id="a2" class="a2"></a>
                    <a href="#" id="a3" class="a3">VIEW ALL</a>
                </div>
            </div>
        </div>
    </div>
</section>
<br>
<br>
<section class="About" id="About">
    <h1>ABOUT <em> COMPANY</em></h1>
    <div class="about-wrapper">
        <div class="SP">
            <swiper-container class="mySwiper" pagination="true" pagination-clickable="true" navigation="true" space-between="30"
                              centered-slides="true" autoplay-delay="2500" autoplay-disable-on-interaction="false">
                <swiper-slide><img src="https://i.ibb.co/G0FSmJz/Adobe-Stock-268225711-Preview.jpg" alt=""></swiper-slide>
                <swiper-slide><img src="https://i.ibb.co/0YnZMqb/Adobe-Stock-420698353-Preview.jpg" alt=""></swiper-slide>
                <swiper-slide><img src="https://i.ibb.co/4SmDcn6/Adobe-Stock-179280204-Preview.jpg" alt=""></swiper-slide>
                <swiper-slide><img src="https://i.ibb.co/pKXzsS6/Adobe-Stock-209466807-Preview.jpg" alt=""></swiper-slide>
                <swiper-slide><img src="https://i.ibb.co/ZVVN2Z7/Adobe-Stock-268247743-Preview.jpg" alt=""></swiper-slide>
                <swiper-slide><img src="https://i.ibb.co/Rgtj8Bh/Adobe-Stock-571655697-Preview.jpg" alt=""></swiper-slide>
                <div class="autoplay-progress" slot="container-end">
                    <svg viewBox="0 0 48 48">
                        <circle cx="24" cy="24" r="20"></circle>
                    </svg>
                    <span></span>
                </div>
            </swiper-container>

        </div>
        <div class="content2">
            <swiper-container class="mySwiper" effect="cards" grab-cursor="true" autoPlay="true">
                <swiper-slide>Slide 1</swiper-slide>
                <swiper-slide>Slide 2</swiper-slide>
                <swiper-slide>Slide 3</swiper-slide>
                <swiper-slide>Slide 4</swiper-slide>
                <swiper-slide>Slide 5</swiper-slide>
                <swiper-slide>Slide 6</swiper-slide>
                <swiper-slide>Slide 7</swiper-slide>
                <swiper-slide>Slide 8</swiper-slide>
                <swiper-slide>Slide 9</swiper-slide>
            </swiper-container>
        </div>
    </div>
</section>



<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-element-bundle.min.js"></script>
<script>
    document.querySelectorAll(".card").forEach((card) => {
        const imm = card.querySelector(".imm");
        const content = card.querySelector(".content");

        let check = true;

        card.addEventListener("mouseenter", () => {
            if (check) {
                imm.style.transition = "0.6s";
                imm.style.height = "300px";
                content.style.transition = "0.6s";
                content.style.height = "50px";
                check = false;
            }
        });

        card.addEventListener("mouseleave", () => {
            if (!check) {
                imm.style.transition = "0.6s";
                imm.style.height = "350px";
                content.style.transition = "0.6s";
                content.style.height = "0";
                check = true;
            }
        });
    });
    document.querySelectorAll(".buttons").forEach((btn) => {
        const a1 = btn.querySelector(".a1");
        const a2 = btn.querySelector(".a2");
        const a3 = btn.querySelector(".a3");
        let check = true;

        btn.addEventListener("mouseenter", () => {
            if (check) {
                a1.style.transition = ".6s"
                a1.style.width = "124px";
                a1.style.height = "44px";
                a2.style.transition = ".6s"
                a2.style.width = "124px";
                a2.style.height = "44px";
                a1.style.borderColor = "#ffe100"
                a2.style.borderColor = "#ffe100"
                a3.style.transition = ".6s";
                a3.style.background = "#ffe100";
                a3.style.color = "black"
                check = false;
            }
        });

        btn.addEventListener("mouseleave", () => {
            if (!check) {
                a1.style.transition = ".6s"
                a1.style.width = "44px";
                a1.style.height = "24px";
                a1.style.transition = ".6s"
                a1.style.borderColor = "black"
                a2.style.borderColor = "black"
                a2.style.width = "44px";
                a2.style.height = "24px";
                a3.style.background = "black";
                a3.style.color = "white"
                check = true;
            }
        });
    });

</script>
</body>
</html>
