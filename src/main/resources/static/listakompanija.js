$(document).ready(function (){

    let urlParams = new URLSearchParams(window.location.search);
    let opremaid = urlParams.get('opremaid');
    let url = new URL('http://localhost:8011/api/korisnik/kompanija');
    url.searchParams.append('opremaid', opremaid);
    console.log(url);
    console.log(opremaid);


    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function (res) {
            alert('eeeee')
            for (let i = 0; i < res.length; i++) {


                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].adresa + "</td>";
                row += "<td>" + res[i].opis + "</td>";
                row += "<td>" + res[i].prosecnaocena + "</td>";
                row += "</tr>";
                $('#listakomp').append(row);
            }

        },

    });
});
