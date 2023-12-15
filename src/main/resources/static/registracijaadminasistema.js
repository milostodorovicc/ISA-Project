$(document).on("submit", "#formadminsistema", function (event) {
    event.preventDefault();
    let url = new URL('http://localhost:8011/api/adminsistema/adminsistema1');
    // url.searchParams.append('idkompanije', localStorage.getItem("kreiranakompanija"));
    // zameni idkompanije sa idadmina kad napravis login da bi proverio da li je to predefinisani admin

    var emailadresa = $("#email").val();
    var lozinka = $("#lozinka").val();
    var ime = $("#ime").val();
    var prezime = $("#prezime").val();
    var grad = $("#grad").val();
    var drzava = $("#drzava").val();
    var brojtelefona = $("#brojtelefona").val();
    var uloga = "ADMINSISTEMA";




    var noviadminsistema= {

        emailadresa,
        lozinka,
        ime,
        prezime,
        grad,
        drzava,
        brojtelefona,
        uloga


    }
    console.log(noviadminsistema);
    alert("abcabc");

    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviadminsistema),
        success: function (res) {
            console.log(res);
            alert("Admin sistema je uspesno kreiran!");

            window.location.href = "registracijaadminasistema.html";


        },
        error: function () {
            alert("Greška!");
        }
    } )})