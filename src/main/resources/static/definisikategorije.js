$(document).on("submit", "#definisikategorije", function (event) {
    event.preventDefault();
    var granica1 = document.getElementById("granica1").value;
    var granica2 = document.getElementById("granica2").value;
    var granica3 = document.getElementById("granica3").value;
    var granica4 = document.getElementById("granica4").value;
    let url = new URL('http://localhost:8011/api/korisnik/definisikategorije');
    url.searchParams.append('granica1', granica1);
    url.searchParams.append('granica2', granica2);
    url.searchParams.append('granica3', granica3);
    url.searchParams.append('granica4', granica4);






    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",


        success: function (res) {
            console.log(res);
            alert("Uspesno ste definisali kategorije!");
        },
        error: function () {
            alert("Niste uspeli da definisete kategorije!");
        }
    } )})