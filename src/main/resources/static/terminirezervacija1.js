document.getElementById('uploadForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const fileInput = document.getElementById('fileInput');
    const files = fileInput.files;

    if (files.length === 0) {
        console.error('No files selected.');
        return;
    }

    for (let i = 0; i < files.length; i++) {
        const file = files[i];
        const reader = new FileReader();

        reader.onload = function(event) {
            const qrCodeData = event.target.result;

            // Display QR code image
            const qrCodeImage = document.createElement('img');
            qrCodeImage.src = qrCodeData;
            document.getElementById('qrCodeContainer').appendChild(qrCodeImage);

            // Create button for scanning QR code
            const scanButton = document.createElement('button');
            scanButton.textContent = 'Scan QR Code';
            scanButton.onclick = function() {
                scanQRCode(qrCodeData);
            };
            document.getElementById('qrCodeContainer').appendChild(scanButton);
        };

        reader.readAsDataURL(file);
    }
});

function scanQRCode(qrCodeData) {
    // Send qrCodeData to server-side Java application for processing
    const formData = new FormData();
    formData.append('files', dataURItoBlob(qrCodeData));

    fetch('/upload', {
        method: 'POST',
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            console.log('QR Code Contents:', data);
            window.location.href = "rezervacija.html?opremaid="+ data.idopreme +"&korisnikid="+data.idkorisnika+"&terminid="+data.idtermina;
            // alert(data);
            // let tabela = "<table id='table'></table>"
            //
            // document.getElementById('qrCodeContainer').appendChild(tabela);
            // let row = "<tr>";
            // row += "<td>" + data.imekorisnika + "</td>";
            // row += "<td >" + data.prezimekorisnika + "</td>";
            // row += "<td >" + data.pocetaktermina + "</td>";
            // row += "<td >" + data.krajtermina + "</td>";
            // row += "<td >" + data.idopreme + "</td>";
            // row += "</tr>";
            // $('#table').append(row);
            // podaci = data.idopreme
            // readButton1.textContent = "Korisnik se pojavio";
            // readButton1.onclick = (function(opt) {
            //
            //     return function() {
            //         pojaviose(opt);
            //
            //     };
            // })(podaci)
            // document.getElementById("qrCodeContainer").appendChild(1);
            // podaci2 = data.idkorisnika
            // readButton2.textContent = "Read QR Code";
            // readButton2.onclick = (function(opt) {
            //
            //     return function() {
            //         nijesepojavio(opt);
            //
            //     };
            // })(podaci2)
            // document.getElementById("qrCodeContainer").appendChild(readButton2);
        })
        .catch(error => {
            console.error('Error uploading files:');
        });
}
function pojaviose(podaci) {

    let url = new URL('http://localhost:8011/api/adminkompanije/obrisiopremu');
    url.searchParams.append('id', podaci);
    alert(podaci);
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
            // window.location.href = "login.html";
        }
    } )
}

// Convert data URI to Blob
function dataURItoBlob(dataURI) {
    const byteString = atob(dataURI.split(',')[1]);
    const mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];
    const ab = new ArrayBuffer(byteString.length);
    const ia = new Uint8Array(ab);

    for (let i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }

    return new Blob([ab], { type: mimeString });
}