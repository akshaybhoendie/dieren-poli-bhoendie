/*!
* Start Bootstrap - Bare v5.0.7 (https://startbootstrap.com/template/bare)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-bare/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

actieveDiensten();

function actieveDiensten(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let actieveDienstenDataList = JSON.parse(this.responseText);
            console.log(actieveDienstenDataList);
            actieveDienstenDataList.reverse();
            let actieveDienstGridRow = '<tbody>';

            for (let i = 0; i < actieveDienstenDataList.length; i++) {
                console.log(actieveDienstenDataList[i]);

                actieveDienstGridRow +=
                    '<tr>\n' +
                    '                    <td>' + actieveDienstenDataList[i].id + '</td>\n' +
                    '                    <td>' + actieveDienstenDataList[i].dienstType.naam + '</td>\n' +
                    '                    <td>' + actieveDienstenDataList[i].lidmaatschap.voornaam + ' ' + actieveDienstenDataList[i].lidmaatschap.achternaam + '</td>\n' +
                    '                    <td>' + actieveDienstenDataList[i].aangemaaktDoor.naam + ' ' + actieveDienstenDataList[i].aangemaaktDoor.achternaam + '</td>\n' +
                    '                    <td>' + actieveDienstenDataList[i].datum.dayOfMonth + ' ' + actieveDienstenDataList[i].datum.month + ' ' + actieveDienstenDataList[i].datum.year + '</td>\n' +
                    '                    <td>\n' +
                    '                        <button id=' + actieveDienstenDataList[i].id + ' type="button" ' + 'onclick="editDienst(this.id)"' + ' class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#wijzigDienst">Details/Wijzigen</button>\n' +
                    '                        <button id=' + actieveDienstenDataList[i].id + ' type="button" ' + 'onclick="deleteDienst(this.id)"' + ' class="btn btn-danger">Verwijderen</button>\n' +
                    '                    </td>\n' +
                    '                </tr>';
            }

           document.getElementById("tableBody").innerHTML = actieveDienstGridRow;
        }
    };

    xhttp.open("GET", "/dierenpolibhoendie/api/dienst/actieve-diensten", true);
    xhttp.send();
}