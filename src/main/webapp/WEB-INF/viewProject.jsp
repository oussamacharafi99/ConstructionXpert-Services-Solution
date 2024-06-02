<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        <%@include file="/CSS/dashboard.css"%>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
<div class="alert alert-success alert-dismissible fade show" role="alert">
    <strong>The Project !</strong> <strong id="texte"></strong>
    <button type="button" id="closes" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
<p style="display: none" id="alerT">${alert}</p>
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
        <a href="${pageContext.request.contextPath}"><i class="fa-solid fa-right-to-bracket"></i></a>
    </div>
</header>
<section class="main">
    <div class="formAddProject">
        <h2><em>Add Project</em></h2>
        <h1 class="closeAddProject"><i class="fa-solid fa-circle-xmark"></i></h1>
        <form action="addprojects" method="POST" class="mb-4">
            <input type="hidden" name="itemId">
            <div class="form-group">
                <label for="itemName">Nom du projet</label>
                <input type="text" class="form-control" id="itemName" name="NameProject" placeholder="Entrer nom">
            </div>
            <div class="form-group">
                <label for="DateDebutProject">Date de début</label>
                <input type="date" class="form-control" id="DateDebutProject" name="DateDebutProject">
            </div>
            <div class="form-group">
                <label for="itemDateFin">Date de fin</label>
                <input type="date" class="form-control" id="itemDateFin" name="DateFinProject" >
            </div>
            <div class="form-group">
                <label for="itemBudget">Budget</label>
                <input type="number" class="form-control" id="itemBudget" name="BudgetProject"  placeholder="Entrer budget">
            </div>
            <div class="form-group">
                <label for="itemDescription">Description</label>
                <textarea class="form-control" id="itemDescription" name="DescriptionProject" placeholder="Entrer description"></textarea>
            </div>
            <button type="submit" class="btn btn-dark">Ajouter</button>
        </form>
    </div>
    <div class="formUpdateProject">
        <h2><em>Update Project</em></h2>
        <h1 class="closeUpdateProject"><i class="fa-solid fa-circle-xmark"></i></h1>
        <form action="updateProject" method="POST" class="mb-4">
            <input type="hidden" name="itemId">
            <div class="form-group">
                <label for="itemName">Id du projet</label>
                <input  type="hidden" class="form-control" id="idProject" name="idProject" value="${Project.getId()}" placeholder="update id">
            </div>
            <div class="form-group">
                <label for="itemName">Nom du projet</label>
                <input type="text" class="form-control" id="itemName" name="NameProject" value="${Project.getName()}" placeholder="Entrer nom">
            </div>
            <div class="form-group">
                <label for="DateDebutProject">Date de début</label>
                <input type="date" class="form-control" id="DateDebutProject" value="${Project.getStartDate()}" name="DateDebutProject">
            </div>
            <div class="form-group">
                <label for="itemDateFin">Date de fin</label>
                <input type="date" class="form-control" id="itemDateFin" name="DateFinProject" value="${Project.getEndDate()}" >
            </div>
            <div class="form-group">
                <label for="itemBudget">Budget</label>
                <input type="number" class="form-control" id="itemBudget" name="BudgetProject" value="${Project.getBudget()}"  placeholder="Entrer budget">
            </div>
            <div class="form-group">
                <label for="itemDescription">Description</label>
                <textarea class="form-control" id="itemDescription" name="DescriptionProject"placeholder="Entrer description">${Project.getDescription()}</textarea>
            </div>
            <button type="submit" class="btn btn-dark">Update</button>
        </form>
    </div>
    <div class="menu">
        <div class="logo">
            <img src="https://i.ibb.co/BctDWFW/Gold-Black-Modern-Real-Estate-Logo.png" width="100%">
        </div>
        <div class="containers">
            <div class="icons updateProject" id="icons">
                <i class="fa-solid fa-diagram-project"></i>
                <a href="#">Update Projects</a>
            </div>
            <div class="icons addProject" >
                <i class="fa-solid fa-diagram-project"></i>
                <a href="#">Add project</a>
            </div>
            <div class="icons">
                <i class="fa-solid fa-diagram-project"></i>
                <a href="addprojects?idD=${Project.getId()}">Finished projects</a>
            </div>
        </div>
        <form id="option">
            <select id="mySelect" onchange="location = this.value;">
                <option id="op">Select Project ...</option>
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
                <h1 onclick="scrolling(0 , 0)">
                    <i class="fa-solid fa-diagram-project"></i>
                    <p >Project</p>
                </h1>
                <h1 onclick="scrolling(500 , 95)">
                    <i class="fa-solid fa-list-check"></i>
                    <p >Tasks</p>
                </h1>
                <h1 onclick="scrolling(1100 , 195)">
                    <i class="fa-brands fa-osi"></i>
                    <p >Resources</p>
                </h1>
                <h1 onclick="scrolling(1600 , 295)">
                    <i class="fa-solid fa-chart-simple"></i>
                    <p >Statistics</p>
                </h1>
                <h1 class="borderM"></h1>
            </div>
        </div>
        <div class="projectView">
            <div class="project-info">
                <h1 id="projectt"><em>Project</em></h1>
                <div class="project-info-wrapper">
                    <div class="project-img">
                        <img src="https://i.ibb.co/MkSfdMb/Adobe-Stock-346885050-Preview.jpg" width="100%"/>
                    </div>
                    <div class="project-content">
                        <h1>${Project.getName()}</h1>
                        <br>
                        <p>
                            ${Project.getDescription()}
                        </p>
                        <div class="project-C-date">
                            <div class="dates">
                                <h2>${Project.getStartDate()}</h2>
                                <h2>${Project.getEndDate()}</h2>
                            </div>
                            <h4>${Project.getBudget()} $</h4>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="project-info">
                <h1 id="taskk"><em>Task</em></h1>
                <div class="task-info-wrapper">
                    <div class="task-menu">
                        <h4 class="btn-progress" id="btn1">In Progress</h4>
                        <h4 class="btn-finished" id="btn2">Finished</h4>
                        <button class="btn btn-outline-primary btn3" id="btn3">Add Task</button>

                        <div class="formAddTask">
                            <h1 class="closeAddTask"><i class="fa-solid fa-circle-xmark"></i></h1>
                            <form action="viewTask" method="POST" class="mb-4">
                                    <div class="row">
                                        <div class="col" style="display:none;">
                                            <label for="DateDebutProject">Date de début</label>
                                            <input type="number" class="form-control" value="${Project.getId()}"  name="idProject">
                                        </div>
                                        <div class="col">
                                            <label for="DateDebutProject">Date de début</label>
                                            <input type="date" class="form-control" id="DateDebutProject" name="DateDebutTask">
                                        </div>
                                        <div class="col">
                                            <label for="DateDebutProject">Date de début</label>
                                            <input type="date" class="form-control" id="DateDebutProject" name="DateFinTask">
                                        </div>
                                    </div>
                                <div class="row">
                                    <div class="col">
                                        <label for="itemDescription">Description</label>
                                        <textarea class="form-control" id="itemDescription" name="DescriptionTask" placeholder="Entrer description"></textarea>
                                    </div>
                                    <div class="col "id="selectAdd">
                                        <select class="custom-select" id="inputGroupSelect01" name="statusTask">
                                            <option selected>Choose...</option>
                                            <option value="To Do">To Do</option>
                                            <option value="Completed">Completed</option>
                                            <option value="In Progress">In Progress</option>
                                        </select>
                                    </div>
                                </div>

                                <button type="submit" class="btn btn-dark mt-3">Ajouter</button>
                            </form>
                        </div>

                    </div>
                    <div class="tasks">
                        <div class="encours">
                            <c:forEach var="T" items="${T}">
                                <div class="tache">
                                    <h1>${T.getDescription()}</h1>
                                    <div class="dates">
                                        <h2>${T.getStartDate()}</h2>
                                         <p>---></p>
                                        <h2>${T.getEndDate()}</h2>
                                    </div>
                                    <div class="controls-tache">
                                        <h6 class="setting"><i class="fa-solid fa-ellipsis-vertical"></i></h6>
                                        <a href="viewTask?idT=${T.getId()}&idP=${T.getProjectId()}"> <button><i class="fa-solid fa-toolbox"></i></button></a>
                                        <a href="deleteProject?idT=${T.getId()}&idP=${T.getProjectId()}"><button><i class="fa-solid fa-trash"></i></button></a>
                                        <a href="#" class="updateBtn"><button><i class="fa-solid fa-pen-clip"></i></i></button></a>
                                    </div>
                                    <div class="formUpdateTask">
                                        <h1 class="closeUpdateTask"><i class="fa-solid fa-circle-xmark"></i></h1>
                                        <form action="deleteProject" method="POST" class="mb-4">
                                            <div class="row">
                                                <div class="col" style="display:none;">
                                                    <label for="DateDebutProject">Date de début</label>
                                                    <input type="number" class="form-control" value="${T.getId()}"  name="idTask">
                                                </div>
                                                <div class="col" style="display:none;">
                                                    <label for="DateDebutProject">Date de début</label>
                                                    <input type="number" class="form-control" value="${T.getProjectId()}"  name="idProject">
                                                </div>
                                                <div class="col">
                                                    <label for="DateDebutProject">Date de début</label>
                                                    <input type="date" class="form-control" id="DateDebutProject" name="DateDebutTask" value="${T.getStartDate()}">
                                                </div>
                                                <div class="col">
                                                    <label for="DateDebutProject">Date de début</label>
                                                    <input type="date" class="form-control" id="DateDebutProject" name="DateFinTask" value="${T.getEndDate()}">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <label for="itemDescription">Description</label>
                                                    <textarea class="form-control" id="itemDescription" name="DescriptionTask" placeholder="Entrer description">${T.getDescription()}</textarea>
                                                </div>
                                                <div class="col">
                                                    <select class="custom-select" id="inputGroupSelect01" name="statusTask">
                                                        <option selected>Choose...</option>
                                                        <option value="To Do">To Do</option>
                                                        <option value="Completed">Completed</option>
                                                        <option value="In Progress">In Progress</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <button type="submit" class="btn btn-dark mt-3">update</button>
                                        </form>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="termine">
                            <c:forEach var="T" items="${Tu}">
                                <div class="tache">
                                    <h1>${T.getDescription()}</h1>
                                    <div class="dates">
                                        <h2>${T.getStartDate()}</h2>
                                        <p>---></p>
                                        <h2>${T.getEndDate()}</h2>
                                    </div>
                                    <div class="controls-tache">
                                            <h6 class="setting"><i class="fa-solid fa-ellipsis-vertical"></i></h6>
                                            <a href="viewTask?idT=${T.getId()}&idP=${T.getProjectId()}"> <button><i class="fa-solid fa-toolbox"></i></button></a>
                                            <a href="deleteProject?idT=${T.getId()}&idP=${T.getProjectId()}"><button><i class="fa-solid fa-trash"></i></button></a>
                                            <a href="#" class="updateBtn"><button><i class="fa-solid fa-pen-clip"></i></i></button></a>
                                    </div>
                                    <div class="formUpdateTask">
                                        <h1 class="closeUpdateTask"><i class="fa-solid fa-circle-xmark"></i></h1>
                                        <form action="deleteProject" method="POST" class="mb-4">
                                            <div class="row" style="display:none;">
                                                <div class="col">
                                                    <label for="idTask">Task ID</label>
                                                    <input type="number" class="form-control" id="idTask" value="${T.getId()}" name="idTask">
                                                </div>
                                                <div class="col">
                                                    <label for="idProject">Project ID</label>
                                                    <input type="number" class="form-control" id="idProject" value="${T.getProjectId()}" name="idProject">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <label for="DateDebutTask">Date de début</label>
                                                    <input type="date" class="form-control" id="DateDebutTask" name="DateDebutTask" value="${T.getStartDate()}">
                                                </div>
                                                <div class="col">
                                                    <label for="DateFinTask">Date de fin</label>
                                                    <input type="date" class="form-control" id="DateFinTask" name="DateFinTask" value="${T.getEndDate()}">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <label for="itemDescription">Description</label>
                                                    <textarea class="form-control" id="itemDescription" name="DescriptionTask" placeholder="Entrer description">${T.getDescription()}</textarea>
                                                </div>
                                                <div class="col">
                                                    <select  name="statusTask">
                                                        <option value="" disabled selected>Choose...</option>
                                                        <option value="To Do">To Do</option>
                                                        <option value="Completed">Completed</option>
                                                        <option value="In Progress">In Progress</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-dark">Update</button>
                                        </form>
                                    </div>


                                </div>
                            </c:forEach>
                        </div>
                        </div>
                    </div>
                </div>

            <div class="project-info">
                <h1 id="resourcee"><em>Resource</em></h1>
                <div class="Resouce-info-wrapper">
                    <div class="resourceMenu">
                        <button class="btn btn-outline-primary Add" id="Add">Add Ressource</button>
                    </div>
                    <div class="addResource">
                        <h1 class="closeAddRessource"><i class="fa-solid fa-circle-xmark"></i></h1>
                        <form action="addRessource" method="POST">
                            <div class="row">
                                <div class="col" style="display: none">
                                    <input type="number" value="${Project.getId()}" name="IdProject" id="IdProject" placeholder="idTask" class="form-control"/>
                                </div>
                                <div class="col" style="display: none">
                                    <input type="number" value="${idTask}" name="idTask" id="idTask" placeholder="idTask" class="form-control"/>
                                </div>
                                <div class="col" style="display: none">
                                    <input type="text"  name="resourceName" value="Resource For Task ${idTask}" id="resourceName" placeholder="resourceName" class="form-control"/>
                                </div>
                                <div class="col">
                                    <select name="type" class="form-control">
                                        <option value="" disabled selected>Choose...</option>
                                        <option value="Material">Material</option>
                                        <option value="Labor">Labor</option>
                                        <option value="Equipment">Equipment</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <input type="number" name="quantity" id="quantity" placeholder="Quantity" class="form-control"/>
                                </div>
                                <div class="col">
                                    <select name="supplier" class="form-control">
                                        <option value="" disabled selected>Choose...</option>
                                        <option value="Supplier A">Supplier A</option>
                                        <option value="Supplier B">Supplier B</option>
                                        <option value="Supplier C">Supplier C</option>
                                        <option value="Supplier D">Supplier D</option>
                                        <option value="Supplier E">Supplier E</option>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-dark mt-3">Add Resource</button>
                        </form>
                    </div>

                    <div class="ressource-wrapper">
                        <c:forEach var="re" items="${ressource}">
                        <div class="resource">
                            <a href="addRessource?idT=${re.getTask_id()}&idP=${Project.getId()}&idR=${re.getId()}"><i class="fa-solid fa-circle-xmark"></i></a>
                            <h1>${re.getName()}</h1>
                            <div>
                                <h2><span>Type </span> ---> <span> ${re.getType()}</span></h2>
                                <h2><span>Quantity </span> ---> <span> ${re.getQuantity()}</span></h2>
                                <h2><span>Supplier  </span> ---> <span> ${re.getSupplier()}</span></h2>
                            </div>
                        </div>

                        </c:forEach>
                    </div>
                </div>
            </div>


            <div class="project-info">
                <h1 id="resourcee"><em>Statistics</em></h1>
                <div class="statistic-info-wrapper">
                    <canvas id="myChart" style="width:100%;"></canvas>
                </div>
            </div>
        </div>
    </section>
</section>

<p id="S" style="display: none">${S}</p>
<script>
    let p1 = <%= request.getAttribute("ToDo") %>;
    let p2 = <%= request.getAttribute("Progress") %>;
    let p3 = <%= request.getAttribute("Completed") %>;
    const xValues = ["To Do","In Progress", "Completed",];
    const yValues =[ p1, p2, p3];
    const barColors = ["green","orange","brown"];

    new Chart("myChart", {
        type: "bar",
        data: {
            labels: xValues,
            datasets: [{
                backgroundColor: barColors,
                data: yValues
            }]
        },
        options: {
            legend: {display: false},
            title: {
                display: true,
                text: "Tasks of Project"
            }
        }
    });

    if(document.getElementById("S").innerText === "S"){
        const projectView = document.querySelector('.projectView');
        const menu = document.querySelector('.borderM');
        projectView.scrollTo({top: 1100, behavior: 'smooth'});
        menu.style.transition = ".6s"
        menu.style.top = "195px";
        document.getElementById("S").innerText = "s";
    }

    function showUpdateTask(){
        document.querySelectorAll(".tache").forEach(T =>{
            const controls = T.querySelectorAll(".controls-tache");
            const popup = T.querySelector(".formUpdateTask");
            const popupAll = T.querySelectorAll(".formUpdateTask");
            controls.forEach(C =>{
                const updateTask = C.querySelector(".updateBtn");
                updateTask.addEventListener("click", ()=>{
                    popup.style.display = "block";
                })
            })
            popupAll.forEach(P =>{
                const close = P.querySelector(".closeUpdateTask");
                close.addEventListener("click", ()=>{
                    popup.style.display = "none";
                })
            })

        })
    }
    showUpdateTask();
    function changing() {
        const btnP = document.getElementById("btn1");
        const btnF = document.getElementById("btn2");
        const encours = document.querySelector(".encours");
        const termine = document.querySelector(".termine");
        btnP.addEventListener("click", () => {
            btnP.style.color = "white";
            btnP.style.background = "black";
            btnF.style.color = "black";
            btnF.style.background = "white";
            encours.style.zIndex = "999";
            termine.style.zIndex = "0";
        });
        btnF.addEventListener("click", () => {
            btnF.style.color = "white";
            btnF.style.background = "black";
            btnP.style.color = "black";
            btnP.style.background = "white";
            termine.style.zIndex = "999";
            encours.style.zIndex = "0";
        });
    }

    function changing2() {
        document.querySelectorAll(".controls-tache").forEach((cours) => {

            let check = true;

            cours.addEventListener("mouseenter", () => {
                if (check) {
                    cours.style.transition = ".6s"
                    cours.style.width = "80%"
                    check = false;
                }
            });

            cours.addEventListener("mouseleave", () => {
                if (!check) {
                    cours.style.transition = ".6s"
                    cours.style.width = "35px"
                    check = true;
                }
            });
        });
    }

    function scrolling(value1, value2) {
        const projectView = document.querySelector('.projectView');
        const menu = document.querySelector('.borderM');
        projectView.scrollTo({top: value1, behavior: 'smooth'});
        menu.style.transition = ".6s"
        menu.style.top = value2 + "px";
    }

    document.querySelector('.projectView').addEventListener('scroll', () => {
        const projectView = document.querySelector('.projectView');
        const menu = document.querySelector('.borderM');

        if (projectView.scrollTop === 0) {
            menu.style.transition = ".6s"
            menu.style.top = "0px";
        } else if (projectView.scrollTop >= 500 && projectView.scrollTop < 800) {
            menu.style.transition = ".6s"
            menu.style.top = "95px";
        } else if (projectView.scrollTop >= 800 &&projectView.scrollTop < 1200 ) {
            menu.style.transition = ".6s"
            menu.style.top = "195px";
        } else if (projectView.scrollTop >= 1200) {
            menu.style.transition = ".6s"
            menu.style.top = "295px";
        }
    });

    function addProjects() {
        document.querySelector(".addProject").addEventListener("click", () => {
            document.querySelector(".formAddProject").style.display = "block"
        })
        document.querySelector(".closeAddProject").addEventListener("click", () => {
            document.querySelector(".formAddProject").style.display = "none"
        })
    }
    function updateProject() {
        document.querySelector(".updateProject").addEventListener("click", () => {
            document.querySelector(".formUpdateProject").style.display = "block"
        })
        document.querySelector(".closeUpdateProject").addEventListener("click", () => {
            document.querySelector(".formUpdateProject").style.display = "none"
        })
    }

    function addTasks() {
        document.querySelector(".btn3").addEventListener("click", () => {
            document.querySelector(".formAddTask").style.display = "block"
        })
        document.querySelector(".closeAddTask").addEventListener("click", () => {
            document.querySelector(".formAddTask").style.display = "none"
        })
    }
    function addResources() {
        document.querySelector(".Add").addEventListener("click", () => {
            document.querySelector(".addResource").style.display = "block"
        })
        document.querySelector(".closeAddRessource").addEventListener("click", () => {
            document.querySelector(".addResource").style.display = "none"
        })
    }
    addResources();
    function alerting(){
        let checked = false;
        if (document.getElementById("alerT").innerHTML === "."){
            document.getElementById("texte").innerText = "has been added successfully"
            document.querySelector(".alert").style.display ="flex";
            checked = true;
        }
        if (checked === true){
            document.getElementById("closes").addEventListener("click" , ()=>{
                document.querySelector(".alert").style.display ="none";
                checked = false;
            })
        }
    }
    function alerting2(){
        let checked = false;
        if (document.getElementById("alerT").innerHTML === ".."){
            document.getElementById("texte").innerText = "has been successfully deleted"
            document.querySelector(".alert").style.display ="flex";
            checked = true;
        }
        if (checked === true){
            document.getElementById("closes").addEventListener("click" , ()=>{
                document.querySelector(".alert").style.display ="none";
                checked = false;
            })
        }
    }
    updateProject();
    addTasks();
    alerting2();
    alerting();
    addProjects();
    changing2();
    changing();

</script>
</body>
</html>
