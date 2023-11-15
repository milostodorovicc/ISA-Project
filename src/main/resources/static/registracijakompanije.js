$(document).on("submit", "#form1", function (event) {
    event.preventDefault();



    var naziv = $("#naziv").val();
    var adresa = $("#adresa").val();
    var opis = $("#opis").val();
    var prosecnaocena = $("#prosecnaocena").val();




    var novakompanija = {
        naziv,
        adresa,
        opis,
        prosecnaocena

    }
    console.log(novakompanija);
    alert("abcabc");

    $.ajax({
        type: "POST",
        url: "http://localhost:8011/api/adminsistema/kompanija",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(novakompanija),
        success: function (res) {
            console.log(res);
            alert("Kompanija " + res.id + " je uspesno kreiran!");
            localStorage.setItem('kreiranakompanija', res.id);
            window.location.href = "registracijaadminakompanije.html";

        },
        error: function () {
            alert("Greška!");
        }
    } )})
