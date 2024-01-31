$(document).ready(function (){

    let urlParams = new URLSearchParams(window.location.search);
    let opremaid = urlParams.get('opremaid');
    let korisnikid = urlParams.get('korisnikid');
    let terminid = urlParams.get('terminid');
    let url = new URL('http://localhost:8011/api/adminkompanije/rezervacija');
    url.searchParams.append('opremaid', opremaid);
    url.searchParams.append('korisnikid', korisnikid);
    url.searchParams.append('terminid', terminid);
    console.log(url);
    console.log(opremaid);
    console.log(korisnikid);
    console.log(terminid);


    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        success: function (res) {
            console.log(res);
            alert('eeeee')
                let row = "<tr>";
                row += "<td>" + res.imekorisnika + "</td>";
                row += "<td>" + res.prezimekorisnika + "</td>";
                row += "<td>" + res.pocetaktermina + "</td>";
                row += "<td>" + res.krajtermina + "</td>";
                row += "<td>" + res.idopreme + "</td>";
                row += "</tr>";
                $('#rezervacija').append(row);
                row1 = '<button class="'+"pojaviose"+'">Obrisi opremu</button>';
                $('#rezervacija1').append(row1);


        },

    });
});


$(document).on('click', '.pojaviose', function (){
    let url = new URL('http://localhost:8011/api/adminkompanije/obrisiopremu');
    let urlParams = new URLSearchParams(window.location.search);
    let opremaid = urlParams.get('opremaid');
    url.searchParams.append('opremaid', opremaid);

    alert(url);
    $.ajax({

        type: "POST",
        url: url,
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            console.log(res);
            alert('Uspesno ste obrisali opremu')

        },
        error: function () {
            alert("Niste uspeli da obrisete opremu!");

        }
    } )

});