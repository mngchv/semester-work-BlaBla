<html lang="">
<head>
    <title>Sign In</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/style/style.css">

</head>
<body>
<form action="/login" method="post" class="form">
    <#if error??>
        <p style="text-align: center">Неправильный логин или пароль</p>
    </#if>
    <div id="wrapper">
        <label for="email"></label><input class="form-control" name="email" id="email" placeholder="Login" type="text">
        <label for="password"></label><input class="form-control" name="password" id="password" placeholder="Password" type="password">
        <p style="text-align: center">Нет аккаунта? <a href="/registration">Создать</a></p>
        <button class="btn btn-success" type="submit" style="margin: 0 auto; display: block;">Sign in</button>
    </div>
</form>
</body>
</html>
