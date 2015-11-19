<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!doctype html>
<html lang="ru" ng-app="staff">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <script src="bower_components/angular/angular.js"></script>
    <script src="modules/main.js"></script>
    <script src="modules/ticket/TicketService.js"></script>
    <script src="modules/ticket/TicketController.js"></script>
    <script src="modules/user/UserService.js"></script>
</head>

<body ng-controller="TicketController as ticket" ng-init="ticket.getTickets()" class="container">

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="//192.168.50.17">Внутренние сервисы компании</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <%--<li><a href="/192.168.50.17">bonvio.staff</a></li>--%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="logout">Выход</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>

<div style="background-color: rgba(255,255,255,0.8); padding: 50px; padding-top: 100px;">
    <form >
        <fieldset>
            <div class="form-group">
                <label for="ticketName">Название</label>
                <input type="text" id="ticketName" class="form-control" placeholder="Название"
                       ng-model="ticket.single.name">
            </div>
            <div class="form-group">
                <label for="ticketDescription">Описание</label>
            <textarea class="form-control" rows="3" id="ticketDescription"
                      placeholder="Описание задачи"
                      ng-model="ticket.single.description"></textarea>
            </div>
            <button type="submit" class="btn btn-primary" ng-click="ticket.insertTicket()">Добавить</button>
        </fieldset>
    </form>
    <hr>


    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">Список задач</div>
        <div class="panel-body">
            <p>В данном разделе отображен список созданных ранее задач. Вы можете добавить новую задачу или удалить созданную ранее.</p>
        </div>

        <!-- Table -->
        <table class="table">
            <%--<tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
            </tr>--%>
            <tr ng-repeat="single in ticket.list">
                <td>
                    <i ng-if="single.status == 1" class="fa fa-caret-right "></i>
                    <i ng-if="single.status == 2" class="fa fa-cog fa-spin"></i>
                    <i ng-if="single.status == 3" class="fa fa-check-square-o"></i>
                    <i ng-if="single.status == 4" class="fa fa-close"></i>
                </td>
                <td>
                    <h4 class="list-group-item-heading">{{single.name}}</h4>
                    <p class="list-group-item-text">{{single.description}}</p>
                </td>
                <td>
                    <button class="btn btn-danger" ng-click="ticket.deleteTicket(single)">Удалить</button>
                </td>
                <td>
                    <button class="btn btn-success" ng-click="ticket.updateTicket(single, 3)">Готово</button>
                </td>
                <td>
                 <label>
                     {{single.developer.login}}
                     <select ng-options="userSingle.login for userSingle in ticket.userList"
                             ng-model="single.developer"
                             ng-change="ticket.updateTicket(single, 2)">
                         <option value="" disabled>Выберите пользователя123</option>
                     </select>
                     <%--<select ng-model=""
                             ng-init="single.developerId = 1">
                         <option value="">select a type</option>
                         <option ng-repeat="userSingle in ticket.userList"
                                 ng-selected="userSingle.id == single.developerId"
                                 value="{{userSingle.id}}">{{userSingle.login}}</option>
                     </select>--%>
                 </label>
                </td>
                <td>
                    <span class="badge">{{single.dateCreate | date: 'dd.MM.yyyy HH:mm'}}</span>
                </td>
                <td>
                    <span class="badge">{{single.dateClose | date: 'dd.MM.yyyy HH:mm'}}</span>
                </td>
            </tr>
        </table>
    </div>

</div>
</body>
</html>