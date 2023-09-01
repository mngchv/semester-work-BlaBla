<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/style/main.css">
    <meta charset="utf-8"/>
    <title>Chat</title>
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="author"/>

</head>
<body id="body" data-spy="scroll" data-target=".header" onload="connect(${user.id})">
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
            <div style="background-color: rgb(252,255,190); border-radius: 14.25rem; margin-left:750px; margin-right:750px"">
                <h2>Чат</h2>
            </div>

            <div id="chatScrollView" style="overflow:scroll; overflow-x: hidden; overflow-y: hidden; height:400px;text-align: center;">
                <div id="messages"></div>
            </div>
            <div style="text-align: center">
                <button id="enterChatButton" onclick="loginToChat('${user.name}')">Начать общение</button>
            </div>
            <label for="message"></label><input style="height: 45px; width: 363px;border-radius: 14.25rem;margin-left: 700px;" name="message" id="message" disabled placeholder="Сообщение" hidden>
            <br>
            <button onclick="sendMessage('${user.name}', $('#message').val())" id="sendMessageButton" class="primaryBtnChat" hidden>
                Отправить
            </button>
        </div>
    </div>
</div>
<script src="/resources/js/jquery.min.js" type="text/javascript"></script>


<script src="/resources/js/chat_web_sockets.js" type="text/javascript"></script>

</body>
</html>