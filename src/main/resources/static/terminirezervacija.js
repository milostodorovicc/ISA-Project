$(document).ready(function () {


    let url = new URL('http://localhost:8011/api/adminkompanije/termini');
    url.searchParams.append('id', localStorage.getItem("id"));


    $.ajax({
        type: "GET",
        url: url ,
        dataType: "json",
        success: function (res) {
            console.log(res);
            for ( let i = 0; i < res.length; i++) {

                alert(JSON.stringify(res[i]));
                var qrData = JSON.stringify(res[i]);

                var typeNumber = 0;
                var errorCorrectionLevel = 'L';
                var qr = qrcode(typeNumber, errorCorrectionLevel);
                qr.addData(qrData);
                qr.make();
                var qrDataURL = qr.createDataURL();


                var qrCodeImg = document.createElement("img");
                qrCodeImg.src = qrDataURL;
                document.getElementById("qrCodeContainer").appendChild(qrCodeImg);
                var readButton = document.createElement("button");
                readButton.textContent = "Read QR Code";
                readButton.onclick = (function(opt) {

                    return function() {
                    readQRCode(opt);

                };
                })(qrData)
                document.getElementById("qrCodeContainer").appendChild(readButton);
            }
        },
        error: function () {
            alert("Greška!");
        }
    });

    function readQRCode(qrData) {

        fetch('/read?qrData=' + encodeURIComponent(qrData))
             alert(encodeURIComponent(qrData))
            .then(response => response.text())
            .then(data => console.log("QR Code Data:", data))
            .catch(error => console.error('Error:', error));
    }

});

// $(document).on("click", "#odgovor", function(event){
//
//
//
//     var idsender = $("input[name=ocena]:checked").val();
//     var body = document.getElementById(idsender).value
//     var poctermina = document.getElementById(idsender+"poc").value
//     var krajtermina = document.getElementById(idsender+"kraj").value
//     var subject ='QR kod'
//     alert(poctermina,krajtermina,body);
//
//
//     var data = {
//         // sender: sender,
//
//         subject: subject,
//         body: body,
//         idsender: idsender,
//         poctermina: poctermina,
//         krajtermina: krajtermina
//     };
//     alert(data.subject + data.body + data.idsender + data.poctermina + data.krajtermina)
//     podaci = data.subject + data.body + data.idsender + data.poctermina + data.krajtermina
//
//     let url1 = new URL('http://localhost:8011/api/qrcode/generateQRCode');
//     url1.searchParams.append('data', encodeURIComponent(podaci));
//     $.ajax({
//         type: "GET",
//         url: url1 ,
//         data: data,
//         dataType: "json",
//         success: function (res) {
//         },
//         error: function () {
//             alert("Greška!");
//         }
//     });
//
//
//
//
//
// });