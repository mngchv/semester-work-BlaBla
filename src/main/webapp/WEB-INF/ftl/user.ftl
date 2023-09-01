<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/style/style.css">
    <meta charset="utf-8"/>
    <title> Профиль </title>
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
    <div>
        <div>
            <div style="display: inline-block; width:100%">
                <div>
                    <img src="${user.imageSrc!"/resources/img/avatar.png"}" style="width: 128px; border-radius: 100px;" alt="User Image">
                    <form action="/user" enctype="multipart/form-data" method="post">
                        <input type="file" id="userImage" name="userImage" title="Change Image">
                        <button class="BtnImg" type="submit">Сохранить</button>
                    </form>

                </div>
                <hr>
                <div style="background-color: rgb(252,255,190);border-radius: 14.25rem;">

                    <div style=""><h4>Новое объявление</h4></div>

                    <form action="/rides" method="post">
                        <label for="rideDestination"></label>
                        <input class="form-control" id="rideDestination" name="rideDestination" type="text"
                                                                    placeholder="Город, в который вы направляетесь">
                        <br>
                        <button class="primaryBtn" type="submit">Создать</button>
                    </form>
                </div>
                <h2>Мои объявления</h2>

            </div>
        </div>
<#--        <div style="background-color: rgb(252,255,190)">-->
<#--            <div style=""><h4>Новое объявление</h4></div>-->

<#--            <form action="/rides" method="post">-->
<#--                <label for="rideDestination"></label><input class="form-control" id="rideDestination" name="rideDestination" type="text"-->
<#--                                                            placeholder="Название">-->
<#--                <br>-->
<#--                <button class="btn btn-success" type="submit">Создать</button>-->
<#--            </form>-->
<#--        </div>-->
        <hr>
        <#list rides as ride>
            <div style="background-color: rgb(252,255,190); border-radius: 14.25rem;">
                <h4>${ride.destination}</h4>
                <p>${ride.description!""}</p>


                <form action="/rides/${ride.id}" method="get">
                    <button class="primaryBtn" type="submit">Смотреть поездку</button>
                </form>
                <br>
                <form action="/rides/${ride.id}/edit" method="get">
                    <button class="primaryBtn" type="submit">Изменить</button>
                </form>
            </div>
            <br>
            <hr>
        </#list>
    </div>
</div>
</body>
</html>