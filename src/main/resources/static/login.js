$(document).on("submit", "#loginforma", function (event) {
    event.preventDefault();
    let url = new URL('http://localhost:8011/api/korisnik/login');
    // url.searchParams.append('idkompanije', localStorage.getItem("kreiranakompanija"));
    // zameni idkompanije sa idadmina kad napravis login da bi proverio da li je to predefinisani admin

    var emailadresa = $("#email").val();
    var lozinka = $("#lozinka").val();





    var login = {

        emailadresa,
        lozinka,



    }
    console.log(login);
    alert("abcabc");

    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(login),
        success: function (res) {
            console.log(res);
            alert("Uspesno ste se prijavili!");
            alert(res);
            window.location.href = "login.html";

        },
        error: function () {
            alert("Greška!");
            window.location.href = "promenalozinkeadminsistema.html?emailadresa="+ emailadresa;
        }
    } )})