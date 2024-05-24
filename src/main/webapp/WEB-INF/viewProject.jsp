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
                <option>Select Option ...</option>
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

        </div>
    </section>
</section>
<script>
    $(document).ready(function() {
        $('#mySelect').on('change', function() {
            var selectedValue = $(this).val();
            $.ajax({
                url: 'ViewProject',
                type: 'GET',
                data: { id: selectedValue },
                success: function(response) {
                    // Handle the response from the servlet
                    $('#projectName').text(response.name);
                    $('#projectDescription').text(response.description);
                    $('#startDate').text(response.startDate);
                    $('#endDate').text(response.endDate);
                    $('#budget').text(response.budget + ' $');
                },
                error: function(xhr, status, error) {
                    console.error('Error: ' + error);
                }
            });
        });
    });
</script>
</body>
</html>