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
                let btn = "<button class='aktiviraj'  data-id=" + res[i].id + ">Prikazi listu kompanija</button>";
                row += "<td>" + btn + "</td>"
                row += "</tr>";
                $('#oprematabela').append(row);
            }
        },
        error: function () {
            alert("Greška!");
        }
    });

});

$(document).on('click', '.aktiviraj', function (){
    let opremaid = this.dataset.id
    window.location.href = "listakompanija.html?opremaid="+ opremaid;

});

$(document).on("submit", "#pretragaponazivu", function (event) {
    event.preventDefault();
    var nazivopreme = document.getElementById("nazivopreme").value;
    let url = new URL('http://localhost:8011/api/korisnik/opremaponazivu');
    url.searchParams.append('oprema', nazivopreme);
    





    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        contentType: "application/json"
        ,
        success: function (res) {
            alert("eee!");
            $("#oprematabela tbody tr").remove();
            for (let i = 0; i < res.length; i++) {


                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].tip + "</td>";
                row += "<td>" + res[i].opis + "</td>"
                row += "<td>" + res[i].ocena + "</td>";
                let btn = "<button class='aktiviraj'  data-id=" + res[i].id + ">Prikazi listu kompanija</button>";
                row += "<td>" + btn + "</td>"
                row += "</tr>";
                $('#oprematabela').append(row);
            }


        },
        error: function () {
            alert("Greška!");
        }
    } )})

$(document).on("submit", "#filtrirajpotipu", function (event) {
    event.preventDefault();
    var tipopreme = document.getElementById("filtpotipu").value;
    let url = new URL('http://localhost:8011/api/korisnik/opremapotipu');
    url.searchParams.append('tipopreme', tipopreme);






    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        contentType: "application/json"
        ,
        success: function (res) {
            alert("eee!");
            $("#oprematabela tbody tr").remove();
            for (let i = 0; i < res.length; i++) {


                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].tip + "</td>";
                row += "<td>" + res[i].opis + "</td>"
                row += "<td>" + res[i].ocena + "</td>";
                let btn = "<button class='aktiviraj'  data-id=" + res[i].id + ">Prikazi listu kompanija</button>";
                row += "<td>" + btn + "</td>"
                row += "</tr>";
                $('#oprematabela').append(row);
            }


        },
        error: function () {
            alert("Greška!");
        }
    } )})


$(document).on("submit", "#filtrirajpooceni", function (event) {
    event.preventDefault();
    var ocenaopreme = document.getElementById("filtpooceni").value;
    let url = new URL('http://localhost:8011/api/korisnik/opremapominoceni');
    url.searchParams.append('ocenaopreme', ocenaopreme);






    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        contentType: "application/json"
        ,
        success: function (res) {
            alert("eee!");
            $("#oprematabela tbody tr").remove();
            for (let i = 0; i < res.length; i++) {


                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].tip + "</td>";
                row += "<td>" + res[i].opis + "</td>"
                row += "<td>" + res[i].ocena + "</td>";
                let btn = "<button class='aktiviraj'  data-id=" + res[i].id + ">Prikazi listu kompanija</button>";
                row += "<td>" + btn + "</td>"
                row += "</tr>";
                $('#oprematabela').append(row);
            }


        },
        error: function () {
            alert("Greška!");
        }
    } )})


$(document).on('click', '.kombinovanapretraga', function (){
    var nazivopreme = $("#nazivopreme").val();
    var filtpotipu = $("#filtpotipu").val();
    var filtpooceni = $("#filtpooceni").val();
    alert(nazivopreme+filtpotipu+filtpooceni);







    let url = new URL('http://localhost:8011/api/korisnik/kombinovanapretraga');
    url.searchParams.append('nazivopreme', nazivopreme);
    url.searchParams.append('filtpotipu', filtpotipu);
    url.searchParams.append('filtpooceni', filtpooceni);






    $.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        contentType: "application/json"
        ,
        success: function (res) {
            alert("eee!");
            $("#oprematabela tbody tr").remove();
            for (let i = 0; i < res.length; i++) {


                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].tip + "</td>";
                row += "<td>" + res[i].opis + "</td>"
                row += "<td>" + res[i].ocena + "</td>";
                let btn = "<button class='aktiviraj'  data-id=" + res[i].id + ">Prikazi listu kompanija</button>";
                row += "<td>" + btn + "</td>"
                row += "</tr>";
                $('#oprematabela').append(row);
            }


        },
        error: function () {
            alert("Nije kombinovana pretraga!");
        }
})});