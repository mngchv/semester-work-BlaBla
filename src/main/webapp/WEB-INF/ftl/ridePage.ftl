<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,500,400italic,300italic,300,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link id="theme-style" rel="stylesheet" href="/resources/style/main.css">
    <title>Объявление</title>
</head>
<body>
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
<div>
    <div>
        <div style="background:rgb(252,255,190); border-radius: 14.25rem; margin-top: 20px">
            <p class="tagline"> Пункт назначения - ${ride.destination!}</p>
        </div>
        <div style="background:rgb(252,255,190); border-radius: 14.25rem;margin-left: 100px;margin-right: 100px;">
            <h2>Машина</h2>
            <ul class="list-unstyled list">
                <#list ride.vehicles as vehicle>
                    <li>${vehicle.model} <a href="#" target="_blank">${vehicle.seats}</a></li>
                </#list>
            </ul>
        </div>
    </div>

<#--    <div style="background:rgb(252,255,190); border-radius: 14.25rem;margin-left: 100px;margin-right: 100px;">-->
<#--        <h2>Контакты</h2>-->
<#--        <ul class="list-unstyled list">-->
<#--            <#list ride.vehicles as vehicle>-->
<#--                <li>${contact.contact} <a href="#" target="_blank">${contact.title}</a></li>-->
<#--            </#list>-->
<#--        </ul>-->
<#--    </div>-->


    <div>

        <section style="background:rgb(252,255,190); border-radius: 14.25rem;margin-left: 100px;margin-right: 100px;">
            <h2><i></i>Цена</h2>
            <#list ride.prices as price>
                <div class="item">
                    <div class="meta">
                        <div class="upper-row">
                            <li> class="cost-title">${price.title}</li>
                        </div>
                    </div>
                </div>
            </#list>
        </section>
        <section style="background:rgb(252,255,190); border-radius: 14.25rem;margin-left: 100px;margin-right: 100px;">
            <h2><i></i>Комментарий</h2>
            <#list ride.comments as comment>
                <div class="item">
                    <li> class="comment-comment">${comment.comment}</li>
                </div>
            </#list>
        </section>
        <section style="background:rgb(252,255,190); border-radius: 14.25rem;margin-left: 100px;margin-right: 100px;">
            <h2><i></i>Тип поездки</h2>
            <div>
                <#list ride.rideTypes as rideType >
                    <div class="item">
                        <li> class="rideType-type">${rideType.type}</li>
                    </div>
                </#list>
            </div>
        </section>



    </div>
</div>
</body>
</html>

