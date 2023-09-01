<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/style/style.css">
    <title>Sign Up</title>
</head>
<body>
<form action="/registration" method="post" class="form">
    <h3>${registrationStatus!""}</h3>
    <div id="wrapper">
        <label for="email"></label><input class="form-control" name="email" id="email" placeholder="email" type="text">
        <label for="password"></label><input class="form-control" name="password" id="password" placeholder="Password" type="password">
        <label for="retype_password"></label><input class="form-control" name="retype_password" id="retype_password" placeholder="Repeat password" type="password">
        <label for="name"></label><input class="form-control" name="name" id="name" placeholder="First name" type="text">
        <label for="surname"></label><input class="form-control" name="surname" id="surname" placeholder="Last name" type="text">
        <p style="text-align: center">Уже есть аккаунт? <a href="/login">Войти</a></p>
        <button class="btn btn-success" type="submit" style="margin: 0 auto;display: block;">Sign Up</button>
    </div>

</form>
</body>
</html>
