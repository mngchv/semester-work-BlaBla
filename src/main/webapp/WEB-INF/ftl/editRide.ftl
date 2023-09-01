<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,500,400italic,300italic,300,500italic,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
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
        <div>
            <h1 class="name">${ride.user.name!""} ${ride.user.surname!""}</h1>
            <label for="article"></label><input class="form-control" id="destination" type="text" class="tagline" style="color: #0f0f0f"
                                                value="${ride.destination!""}">
            <br>
            <button class="btn btn-success" onclick="updateDestination(${ride.id})">Сохранить</button>
        </div>
        <div>
            <h2>Модель автомобиля</h2>
            <ul class="list-unstyled list" id="models_container">
                <#list ride.vehicles as vehicle>
                    <li id="vehicle_${vehicle.id}">${vehicle.model} <a href="#" target="_blank">${vehicle.seats}</a>
                    </li>
                </#list>
                <li>
                    <label for="new_vehicle_model"></label><input type="text" id="new_vehicle_model"
                                                                  placeholder="Модель">
                    <label for="new_vehicle_seats"></label><input type="text" id="new_vehicle_seats"
                                                                 placeholder="Кол-во мест">
                    <br>
                    <br>
                    <button class="btn btn-success" onclick="addVehicle(${ride.id})">Добавить</button>
                </li>
            </ul>
        </div>
<#--        <div>-->
<#--            <h2>Контакты</h2>-->
<#--            <ul class="list-unstyled list" id="contacts_container">-->
<#--                <#list ride.contacts as contact>-->
<#--                    <li id="contact_${contact.id}">${contact.title} <a href="#" target="_blank">${contact.contact}</a>-->
<#--                    </li>-->
<#--                </#list>-->
<#--                <li>-->
<#--                    <label for="new_contact_title"></label><input type="text" id="new_contact_title"-->
<#--                                                                  placeholder="Имя">-->
<#--                    <label for="new_contact_info"></label><input type="text" id="new_contact_info"-->
<#--                                                                 placeholder="Номер телефона">-->
<#--                    <br>-->
<#--                    <br>-->
<#--                    <button class="btn btn-success" onclick="addContact(${ride.id})">Добавить</button>-->
<#--                </li>-->
<#--            </ul>-->
<#--        </div>-->
    </div>
    <div>
        <section>
<#--            <h2><i></i>Описание</h2>-->
<#--            <div>-->
<#--                <label for="description"></label><textarea class="form-control" id="description" placeholder="Например: Чистая, ухоженная квартира">${post.description!""}</textarea>-->
<#--                <br>-->
<#--                <button class="btn btn-success" onclick="updateDescription(${post.id})">Сохранить</button>-->
<#--            </div>-->
        </section>
        <section id="prices_container">
            <h2><i></i>Цена</h2>
            <#list ride.prices as price>
                <div class="item">
                    <div class="meta">
                        <div class="upper-row">
                            <h3 class="price-title">${price.title}</h3>
                        </div>
                    </div>
                </div>
            </#list>
            <div>
                <label for="new_price_title"></label><input class="form-control" type="text" id="new_price_title"
                                                               placeholder="Например: 1000 рублей">
                <br>
                <button class="btn btn-success" onclick="addPrice(${ride.id})">Добавить</button>
            </div>
        </section>
        <section id="rideType_container">
            <h2><i></i>Тип поездки</h2>
            <#list ride.rideTypes as rideType>
                <div class="item">
                    <h3 class="rideType-type">${rideType.type}</h3>
                </div>
            </#list>
            <div>
                <label for="new_ride-type_type"></label><input class="form-control" type="text" id="new_ride-type_type"
                                                                    placeholder="Например: посылка, перевозка животного, личная и т.п.">
                <br>
                <button class="btn btn-success" onclick="addRideType(${ride.id})">Добавить</button>
            </div>
        </section>
        <section>
            <h2><i></i>Комментарий к поездке</h2>
            <div id="comments_container">
                <#list ride.comments as comment>
                    <div class="item">
                        <h3 class="comments-comment">${comment.comment}</h3>
                    </div>
                </#list>
                <div>
                    <label for="new_comment_comment"></label><input class="form-control" type="text" id="new_comment_comment"
                                                                                 placeholder="Например: Будет 2 остановки по пути ">
                    <br>
                    <button class="btn btn-success" onclick="addComment(${ride.id})">Добавить</button>
                </div>
            </div>
        </section>

    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="/resources/js/ride.js" type="text/javascript"></script>
</body>
</html>

