$(document).ready(function () {



    let url = new URL('http://localhost:8011/api/korisnik/svaoprema');




    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function (res) {



            console.log(res);
            for (let i = 0; i < res.length; i++) {


                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].tip + "</td>";
                row += "<td>" + res[i].opis + "</td>"
                row += "<td>" + res[i].ocena + "</td>";

                row += "</tr>";
                $('#odradjeni').append(row);
            }
        },
        error: function () {
            alert("Greška!");
        }
    });

});