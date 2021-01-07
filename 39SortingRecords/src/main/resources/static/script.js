$(document).ready(
    function () {
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/employee",
            dataType: "json",
            success: [
                function (msg) {
                    insertIntoTable(msg);
                }
            ],
            statusCode: {
                200: function () {
                    console.log("Ok");
                }
            }
        })

        $("#id-asc").click(
            function (){
                sortByField("id", "true");
            }
        );
        $("#firstName-asc").click(
            function (){
                sortByField("firstName", "true");
            }
        );
        $("#lastName-asc").click(
            function (){
                sortByField("lastName", "true");
            }
        );
        $("#position-asc").click(
            function (){
                sortByField("position", "true");
            }
        );

        $("#id-desc").click(
            function (){
                sortByField("id", "false");
            }
        );
        $("#firstName-desc").click(
            function (){
                sortByField("firstName", "false");
            }
        );
        $("#lastName-desc").click(
            function (){
                sortByField("lastName", "false");
            }
        );
        $("#position-desc").click(
            function (){
                sortByField("position", "false");
            }
        );

        $("#createEmployee").click(
            function (){
                let firstName = $("#firstName").val();
                let lastName = $("#lastName").val();
                let position = $("#position").val();
                let separationDate = $("#separationDate").val();

                console.log("firstName: " + firstName);
                console.log("lastName: " + lastName);
                console.log("position: " + position);
                console.log("separationDate: " + separationDate);

                if(firstName == ""){
                    $("#error-firstName").text("Input First name");
                }
                if(lastName == ""){
                    $("#error-lastName").text("Input Last name");
                }
                if(position == ""){
                    $("#error-position").text("Input Position");
                }

                if (firstName != "" && lastName != "" && position != ""){
                    if(separationDate == ""){
                        separationDate = null;
                    }

                    // POST
                    $.ajax({
                        method: "POST",
                        url: "http://localhost:8080/employee",
                        dataType: "json",
                        data: JSON.stringify({
                            firstName : firstName,
                            lastName : lastName,
                            position : position,
                            separationDate : separationDate
                        }),
                        headers: {"Content-Type": "application/json"},
                        success: [
                            function (msg) {
                                $("#answer").text("Employee saved with id=" + msg.id);
                            }
                        ],
                        statusCode: {
                            200: function () {
                                console.log("Ok");
                            }
                        }
                    })
                }
            }
        );
    }
);

function insertIntoTable(msg) {
    let arr = msg;
    $.each(arr, function (index, value) {
        let row = $("<tr>" +
            "<td>" + value.id + "</td>" +
            "<td>" + value.firstName + "</td>" +
            "<td>" + value.lastName + "</td>" +
            "<td>" + value.position + "</td>" +
            "<td>" + value.separationDate + "</td>" +
            "</tr>");
        $("#table1").append(row);
    });
}

function clearTable(){
    $("#table1 tbody").empty();
}

function sortByField(field, asc){

    $.ajax({
        method: "GET",
        url: "http://localhost:8080/employee?sorting=" + field + "&asc=" + asc,
        dataType: "json",
        success: [
            function (msg) {
                clearTable();
                insertIntoTable(msg);
            }
        ],
        statusCode: {
            200: function () {
                console.log("Ok");
            }
        }
    })
}

