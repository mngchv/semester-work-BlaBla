// document.cookie = 'X-Authorization=' + '123456' + ';path=/';
// const socket = new WebSocket('ws://localhost:8080/chat');
//
// function connect(id) {
//
//     // webSocket = new WebSocket('ws://localhost:8080/chat');
//     // webSocket.onmessage = function receiveMessage(response) {
//     //     let data = response['data'];
//     //     let json = JSON.parse(data);
//     //     $('#messages').last().before("<p style='font-size: larger; height: 3%'>" + json['email'] + ": " + json['body'] + "</p>")
//     // };
//     console.log("dsgasg")
//
//     socket.addEventListener('open', function (event) {
//         socket.send('Hello Server!');
//     });
//     socket.onerror = function errorShow(e ) {
//         console.log(e)
//     }
// }
//
// function loginToChat(from) {
//     let message = {
//         "messageType": "loginToChat",
//         "email": from,
//         "body": ""
//     };
//     socket.send(JSON.stringify(message));
//     document.getElementById('message').disabled = false
//     document.getElementById('message').hidden = false
//     document.getElementById('sendMessageButton').hidden = false
//     document.getElementById('enterChatButton').hidden = true
// }
//
// function sendMessage(from, text) {
//     if (from == null || text === '') return
//
//     let message = {
//         "messageType": "chat",
//         "email": from,
//         "body": text
//     };
//     socket.send(JSON.stringify(message));
//     document.getElementById('message').value = ''
// }

var webSocket;

function connect(id) {
    document.cookie = 'X-Authorization=' + '123456' + ';path=/';
    webSocket = new WebSocket('ws://localhost:8080/chat');
    webSocket.onmessage = function receiveMessage(response) {
        let data = response['data'];
        let json = JSON.parse(data);
        $('#messages').last().before("<p style='font-size: larger; height: 3%'>" + json['name'] + ": " + json['body'] + "</p>")
    };
    webSocket.onerror = function errorShow() {
        alert('Ошибка авторизации')
    }
}

function loginToChat(from) {
    let message = {
        "messageType": "loginToChat",
        "name": from,
        "body": ""
    };
    webSocket.send(JSON.stringify(message));
    document.getElementById('message').disabled = false
    document.getElementById('message').hidden = false
    document.getElementById('sendMessageButton').hidden = false
    document.getElementById('enterChatButton').hidden = true
}

function sendMessage(from, text) {
    if (from == null || text === '') return

    let message = {
        "messageType": "chat",
        "name": from,
        "body": text
    };
    webSocket.send(JSON.stringify(message));
    document.getElementById('message').value = ''
}