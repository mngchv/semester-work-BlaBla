<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/style/main.css">
    <meta charset="utf-8"/>
    <title>Объявления</title>
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <link href="https://fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet" type="text/css">
</head>
<body id="body" data-spy="scroll" data-target=".header">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">

            <a class="nav-item nav-link active" href="/rides"> Поездки <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/user">Профиль</a>
            <a class="nav-item nav-link" href="/chatting">Чат</a>
            <a class="nav-item nav-link" href="/logout">Выход</a>
        </div>
    </div>
</nav>
<div id="rides">
    <div class="container content-lg">
        <div class="row text-center margin-b-40">

        </div >
        <#list rides as ride>
            <div style="background-color: rgb(252,255,190); border-radius: 14.25rem;">
                <h4>${ride.destination}</h4>


                <form action="/rides/${ride.id}" method="get">
                    <button class="primaryBtnMain" type="submit">Смотреть поездку</button>
                </form>
            </div>
            <br>
        </#list>
    </div>
</div>

<script src="/resources/js/jquery.min.js" type="text/javascript"></script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBsXUGTFS09pLVdsYEE9YrO2y4IAncAO2U&amp;callback=initMap" async defer></script>


</body>
</html>