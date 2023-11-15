$(document).on("submit", "#formadminkomp", function (event) {
    event.preventDefault();
    let url = new URL('http://localhost:8011/api/adminsistema/adminkompanija');
    url.searchParams.append('idkompanije', localStorage.getItem("kreiranakompanija"));


    var emailadresa = $("#email").val();
    var lozinka = $("#lozinka").val();
    var ime = $("#ime").val();
    var prezime = $("#prezime").val();
    var grad = $("#grad").val();
    var drzava = $("#drzava").val();
    var brojtelefona = $("#brojtelefona").val();




    var noviadminkompanije = {

        emailadresa,
        lozinka,
        ime,
        prezime,
        grad,
        drzava,
        brojtelefona


    }
    console.log(noviadminkompanije);
    alert("abcabc");

    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviadminkompanije),
        success: function (res) {
            console.log(res);
            alert("Admin kompanije je uspesno kreiran!");

            window.location.href = "registracijaadminakompanije.html";

        },
        error: function () {
            alert("Greška!");
        }
    } )})