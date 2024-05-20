<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projects</title>
    <style>
        .task {
            padding: 10px;
            margin: 5px 0;
            background-color: #f0f0f0;
            border: 1px solid #ccc;
            cursor: grab;
        }

        .delete-marker {
            width: 100px;
            padding: 10px;
            background-color: red;
            color: white;
            text-align: center;
            position: fixed;
            left: 10px;
            bottom: 50px;
            transition: bottom 0.3s ease;
        }

        .delete-button {
            cursor: pointer;
            color: white;
            float: left;
        }
    </style>
</head>
<body>
<h1>Projects</h1>
<c:forEach var="task" items="${TaskP}">
    <div class="task" data-task-id="${task.id}" draggable="true">
        <h2>Task ID: ${task.id}</h2>
        <p>Project ID: ${task.projectId}</p>
        <p>Description: ${task.description}</p>
        <p>Start Date: ${task.startDate}</p>
        <p>End Date: ${task.endDate}</p>
        <p>Status: ${task.status}</p>
    </div>
</c:forEach>

<div class="delete-marker" id="deleteMarker">
    <span class="delete-button">Delete</span>
</div>

<form id="deleteForm" action="ViewTasks" method="post">
    <input type="hidden" id="taskId" name="taskId">
</form>

<script>
    document.addEventListener('DOMContentLoaded', (event) => {
        const tasks = document.querySelectorAll('.task');
        const deleteMarker = document.getElementById('deleteMarker');
        const deleteButton = deleteMarker.querySelector('.delete-button');

        tasks.forEach(task => {
            task.addEventListener('dragstart', (e) => {
                deleteMarker.style.bottom = '0';
                e.dataTransfer.setData('text/plain', e.target.dataset.taskId);
                
                e.target.classList.add('dragging');
            });

            task.addEventListener('dragend', (e) => {
                deleteMarker.style.bottom = '50px';

                e.target.classList.remove('dragging');
            });
        });

        deleteMarker.addEventListener('dragover', (e) => {
            e.preventDefault();
        });

        deleteMarker.addEventListener('drop', (e) => {
            e.preventDefault();
            const taskId = e.dataTransfer.getData('text/plain');
            const taskElement = document.querySelector(`.task[data-task-id="${taskId}"]`);
            taskElement.parentNode.removeChild(taskElement);
            deleteMarker.style.bottom = '50px';
        });

        deleteButton.addEventListener('click', (e) => {
            const taskId = document.querySelector('.task.dragging').dataset.taskId;
            document.getElementById('taskId').value = taskId;
            document.getElementById('deleteForm').submit();
        });

        document.addEventListener('dragenter', (e) => {
            if (!deleteMarker.contains(e.target)) {
                deleteMarker.style.bottom = '50px';
            }
        });
    });

</script>
</body>
</html>
