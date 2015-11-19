<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="modules/login/signin.css">
</head>
<body>
<div class="container">

    <form class="form-signin" action="j_spring_security_check" method="POST">
        <h2 class="form-signin-heading">Авторизуйтесь...</h2>
        <label for="username" class="sr-only">Login</label>
        <input type="text" id="username" class="form-control" placeholder="Иван" required="" autofocus="" name="j_username">
        <label for="inputPassword" class="sr-only">Пароль</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Пароль" required="" name="j_password">
        <div class="checkbox">
            <label>
                <input type="checkbox"
                       value="remember-me"
                       name="_spring_security_remember_me"> Не выходить из системы
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div>

<%--<form class="form-signin" action="/j_spring_security_check" method="POST">

    <input type="text"
           placeholder="Login"
           required="" name="j_username">
    <input type="password"
           placeholder="Password"
           required=""
           name="j_password">

    <div class="checkbox">
        <label>
            <input type="checkbox"
                   value="remember-me"
                   name="_spring_security_remember_me"> Remember me
        </label>
    </div>
    <button type="submit">Singin</button>
</form>--%>

</body>
</html>