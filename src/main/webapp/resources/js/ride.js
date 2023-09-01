function addVehicle(rideId) {
    let model = document.getElementById('new_vehicle_model').value
    let seats = document.getElementById('new_vehicle_seats').value
    $.ajax({
        url: '/rides/addVehicle',
        method: 'post',
        dataType: 'json',
        data: {
            "rideId": rideId,
            "model": model,
            "seats": seats
        },
        success: function (vehicle) {
            if (vehicle == null) {
                return;
            }
            const vehicleElem = document.createElement('li');
            vehicleElem.innerHTML = vehicle.model + ' <a href="#" target="_blank">' + vehicle.seats + '</a>';
            const container = document.querySelector('#vehicles_container');
            container.insertBefore(vehicleElem, container.children[container.children.length - 1]);
        },
        error: function (response) {
        }
    })
}
function addPrice(rideID) {
    let title = document.getElementById('new_price_title').value
    $.ajax({
        url: '/rides/addPrice',
        method: 'post',
        dataType: 'json',
        data: {
            "rideID": rideID,
            "title": title,
        },
        success: function (price) {
            if (price == null) {
                return;
            }
            let check = document.getElementById("price-title")
            if (check){
                console.log(price)
                check.innerHTML = price.title
            }else {
                const elem = document.createElement('div');
                elem.classList.add("item")
                elem.innerHTML = '<div className="meta"><div className="upper-row"><h3 id="price-title" className="price-title">' + price.title + '</h3>';
                const container = document.querySelector('#prices_container');
                container.insertBefore(elem, container.children[container.children.length - 1]);
            }
        },
        error: function (response) {
        }
    })
}

function addRideType(rideID) {
    let type = document.getElementById('new_ride-type_type').value
    $.ajax({
        url: '/rides/addRideType',
        method: 'post',
        dataType: 'json',
        data: {
            "rideID": rideID,
            "type": type,
        },
        success: function (rideType) {
            if (rideType == null) {
                return;
            }
            let check = document.getElementById("ride-type_type")
            if (check){
                console.log(rideType)
                check.innerHTML = rideType.type
            }else {

            const elem = document.createElement('div');
            elem.classList.add("item")
            elem.innerHTML = rideType.type;
            const container = document.querySelector('#rideType_container');
            container.insertBefore(elem, container.children[container.children.length - 1]);
                }
        },
        error: function (response) {
        }
    })
}

function addComment(rideID) {
    let comment = document.getElementById('new_comment_comment').value
    $.ajax({
        url: '/rides/addComment',
        method: 'post',
        dataType: 'json',
        data: {
            "rideID": rideID,
            "comment": comment,
        },
        success: function (comment) {
            if (comment == null) {
                return;
            }
            let check = document.getElementById("comment-comment")
            if (check){
                console.log(comment)
                check.innerHTML = comment.comment
            }else {
            const elem = document.createElement('div');
            elem.classList.add("item")
            elem.innerHTML =
                '<h3 className="comment">' + comment.comment + '</h3>';
            const container = document.querySelector('#comments_container');
            container.insertBefore(elem, container.children[container.children.length - 1]);
            }
        },
        error: function (response) {
        }
    })
}

function addContact(rideId) {
    let title = document.getElementById('new_contact_title').value
    let contact = document.getElementById('new_contact_info').value
    $.ajax({
        url: '/rides/addContact',
        method: 'post',
        dataType: 'json',
        data: {
            "rideId": rideId,
            "title": title,
            "contact": contact
        },
        success: function (contact) {
            if (contact == null) {
                return;
            }
            let check = document.getElementById("contact-title")
            if (check){
                console.log(contact)
                check.innerHTML = contact.title
                check.innerHTML = contact.contact
            }else {
                const contactElem = document.createElement('li');
                contactElem.innerHTML = contact.title + ' <a href="#" target="_blank">' + contact.contact + '</a>';
                const container = document.querySelector('#contacts_container');
                container.insertBefore(contactElem, container.children[container.children.length - 1]);
            }
                },
            error: function (response) {
            }
    })
}

// function updateDescription(id) {
//     let comment = document.getElementById('comment').value
//
//     $.ajax({
//         url: '/comment/comment',
//         method: 'post',
//         dataType: 'json',
//         data: {
//             "id": id,
//             "comment": comment,
//         },
//         success: function (contact) {
//         },
//         error: function (response) {
//         }
//     })
// }

function updateDestination(id) {
    let destination = document.getElementById('destination').value
    $.ajax({
        url: '/rides/destination',
        method: 'post',
        dataType: 'json',
        data: {
            "id": id,
            "destination": destination,
        },
        success: function (contact) {
        },
        error: function (response) {
        }
    })
}
