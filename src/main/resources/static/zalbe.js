$(document).ready(function () {


        let url = new URL('http://localhost:8011/api/adminsistema/zalbe');


        $.ajax({
            type: "GET",
            url: url ,
            dataType: "json",
            success: function (res) {
                console.log(res);
                for ( let i = 0; i < res.length; i++) {


                    let row = "<tr>";
                    row += "<td>" + res[i].tekstzalbe + "</td>";
                    row += "<td >" + res[i].emailkorisnika + "</td>";
                    row += "<td>" + "    <input type=\"text\" id="+res[i].idsender+" name="+res[i].idsender+"   />" + "</td>";
                    row += "<td>" + "    <input type=\"radio\" name=\"ocena\"  value=" + res[i].idsender + "  />" + "</td>";

                    row += "</tr>";
                    $('#zalbe').append(row);
                }
            },
            error: function () {
                alert("Greška!");
            }
        });



});

$(document).on("click", "#odgovor", function(event){


    // var sender = 'milostodorovic98@yahoo.com'
    var idsender = $("input[name=ocena]:checked").val();
    var body = document.getElementById(idsender).value
    var subject ='Odgovor'
    // alert(recipient,body);


    var data = {
        // sender: sender,

        subject: subject,
        body: body,
        idsender: idsender
    };
    alert(data.subject + data.body + data.idsender)
    fetch('/send-email', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                alert('Email sent successfully!');
            } else {
                alert('Failed to send email. Please try again.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });




});