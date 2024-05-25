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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
            <img src="https://i.ibb.co/BctDWFW/Gold-Black-Modern-Real-Estate-Logo.png" width="100%">
        </div>
        <div class="containers">
            <div class="icons">
                <i class="fa-solid fa-diagram-project"></i>
                <a href="#">Add project</a>
            </div>
            <div class="icons">
                <i class="fa-solid fa-diagram-project"></i>
                <a href="#">All Projects</a>
            </div>
            <div class="icons">
                <i class="fa-solid fa-diagram-project"></i>
                <a href="#">Finished projects</a>
            </div>
        </div>
        <form id="option">
            <select id="mySelect" onchange="location = this.value;">
                <option id="op">Select Option ...</option>
                <c:forEach items="${P1}" var="P">
                    <option value="ViewProject?id=${P.id}">${P.name}</option>
                </c:forEach>
            </select>
        </form>

        <div class="profile">
            <a href="#"><i class="fa-regular fa-id-card"></i></a>
        </div>
    </div>
    <section class="hero">
        <div class="menu_project">
            <div class="mini-menu">
                <h1 id="p">
                    <i class="fa-solid fa-diagram-project"></i>
                    <a href="#">Project</a>
                </h1>
                <h1>
                    <i class="fa-solid fa-list-check"></i>

                    <a href="#">Tasks</a>
                </h1>
                <h1>
                    <i class="fa-brands fa-osi"></i>
                    <a href="#">Resources</a>
                </h1>
                <h1>
                    <i class="fa-solid fa-chart-simple"></i>
                    <a href="#">statistics</a>
                </h1>
            </div>
        </div>

        <div class="projectView">
            <div class="project-info">
                <h1><em>project</em></h1>
                <div class="project-info-wrapper">
                    <div class="project-img">
                        <img src="https://i.ibb.co/MkSfdMb/Adobe-Stock-346885050-Preview.jpg" width="100%"/>
                    </div>
                    <div class="project-content">
                        <h1>${ProjectId.getName()}</h1>
                        <br>
                        <p>
                            ${ProjectId.getDescription()}
                        </p>
                        <div class="project-C-date">
                            <div class="dates">
                                <h2>${ProjectId.getStartDate()}</h2>
                                <h2>${ProjectId.getEndDate()}</h2>
                            </div >
                            <h4>${ProjectId.getBudget()} $</h4>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="project-info">
                <h1><em>Task</em></h1>
                <div class="task-info-wrapper">
                    <div class="task-menu">
                        <h4 class="btn-progress" id="btn1">in progress</h4>
                        <h4 class="btn-finished" id="btn2">finished</h4>
                    </div>
                   <div class="tasks">

                           <div class="encours">
                               <c:forEach  var="T" items="${T}">
                                <div class="tache">
                                    <h1>${T.getDescription}</h1>
                                    <div class="dates">
                                        <h2>${t.getStartDate}</h2>
                                        <h2>${t.getEndDate}</h2>
                                    </div >
                                    <p>${t.getStatus}</p>
                                </div>
                               </c:forEach>
                           </div>
                           <div class="termine">

                           </div>

                   </div>
                </div>
            </div>
        </div>
    </section>
</section>
<script>

    function changing(){
        const btnP = document.getElementById("btn1")
        const btnF = document.getElementById("btn2")
        const encours = document.querySelector(".encours");
        const termine  = document.querySelector(".termine");
        btnP.addEventListener("click", ()=> {
            btnP.style.color = "#ffe100"
            btnP.style.background = "black"
            btnF.style.color = "black"
            btnF.style.background = "white"
            encours.style.zIndex = "999"
            termine.style.zIndex = "0"
        })
        btnF.addEventListener("click", ()=> {
            btnF.style.color = "#ffe100"
            btnF.style.background = "black"
            btnP.style.color = "black"
            btnP.style.background = "white"
            termine.style.zIndex = "999"
            encours.style.zIndex = "0"
        })
    }
    changing();


</script>
</body>
</html>