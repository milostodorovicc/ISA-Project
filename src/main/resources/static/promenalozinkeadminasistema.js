$(document).on("submit", "#promenalozinke", function (event) {
    event.preventDefault();
    let url = new URL('http://localhost:8011/api/adminsistema/promenalozinke');


    var lozinka = $("#lozinka").val();
    var potvrdalozinka = $("#lozinkapotvrda").val();
    const urlParams = new URLSearchParams(window.location.search);
    var email = urlParams.get('emailadresa')
    url.searchParams.append("email", email);
    url.searchParams.append("lozinka", lozinka);
    url.searchParams.append("potvrdalozinka", potvrdalozinka);

    alert("abcabc");


    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        contentType: "application/json",

        success: function (res) {
            console.log(res);
            alert("Uspesno ste izmenili lozinku!");

            window.location.href = "login.html";

        },
        error: function () {
            alert("Greška!");

            window.location.href = "promenalozinkeadminsistema.html?emailadresa="+ email;
        }
    } )})