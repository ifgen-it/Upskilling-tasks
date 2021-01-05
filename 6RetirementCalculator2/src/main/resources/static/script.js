$(document).ready(
    function () {
        $("button").click(
            function () {
                console.log("start request");
                let curAge = $("#currentAge").val();
                let retAge = $("#retireAge").val();
                $.ajax({
                    method: "GET",
                    url: "http://localhost:8080/retire2?currentAge=" + curAge + "&retireAge=" + retAge,
                    dataType: "json",
                    success: [
                        function (msg) {
                            let result = msg.result;
                            let workingYears = msg.workingYears;
                            let retireYear = msg.retireYear;
                            let currentYear = new Date().getFullYear();

                            if (result == "OK") {
                                $("#answer").text("You have " + workingYears + " years left until you can retire. " +
                                    "It's " + currentYear + " , so you can retire in " + retireYear);
                            } else {
                                $("#answer").text(result);
                            }
                        }
                    ],
                    statusCode: {
                        200: function () {
                            console.log("Ok");
                        }
                    }
                })
            }
        );
    }
);