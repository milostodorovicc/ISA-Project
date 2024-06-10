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

    let url1 = new URL('http://localhost:8011/api/qrcode/upload');

    $.ajax({

        url: url1,
        type: 'POST',
        data: formData,
        contentType: false, // Important: Let the browser set the Content-Type
        processData: false, // Important: Don't process data (FormData)

        success: function (response) {
            console.log(response);
            let str = response.idopremesva;
            alert(str);
            str = str.slice(0,str.lastIndexOf(";"));
            alert(str);
            let str1 ="";
            for ( let i = 0; i < response.idopremesva.length; i++) {
                str1 = str1+response.idopremesva[i]+",";
            }

            window.location.href = "rezervacija.html?opremaid=" + str1 + "&korisnikid=" + response.idkorisnika + "&terminid=" + response.idtermina;
        },
        error: function () {
            alert('Rok za preuzimanje opreme je prosao!');
        }

    })


}




    // fetch('/upload', {
    //     method: 'POST',
    //     body: formData
    // })
    //     .then(response => response.json())
    //     .then(data => {
    //         if(data.success) {
    //             console.log('QR Code Contents:', data);
    //             window.location.href = "rezervacija.html?opremaid=" + data.idopreme + "&korisnikid=" + data.idkorisnika + "&terminid=" + data.idtermina;
    //         }
    //         else
    //         {alert('Rok za preuzimanje opreme je prosao!');}
    //     })
    //     .catch(error => {
    //         console.error('Rok za preuzimanje opreme je prosao dodeljena su vam 2 penala!');
    //     });
// }
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