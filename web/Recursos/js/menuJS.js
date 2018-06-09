cargarTablaMenu();

function construirJSON(ban) {
    datos = {
        bandera: ban,
        id: document.getElementById('id_menu').value,
        nombre: document.getElementById('nombre_menu').value,
        obsv: document.getElementById('obsv_menu').value
    };
    
    
    envio();

}

function agregarMenu() {
    construirJSON(1);
}
function modificarMenu() {
    construirJSON(2);
}
function eliminarMenu() {
    construirJSON(3);
}


function envio() {    
    var xmlhttp = new XMLHttpRequest();   // objeto para peticion vía ajax 
    xmlhttp.open("POST", "/LaboratorioWEBLCI/menuCTRL");// tipo de envio -  destino de envio
   // xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8"); // Es el formato de envio de datos  
    xmlhttp.onreadystatechange = function () {
        if (this.status === 200) {
            cargarTablaMenu();
        } else {
            alert("error");
        }
    };
    xmlhttp.send(JSON.stringify(datos));
}

function cargarTablaMenu() {
    //alert('Llegando a cargar tabla');
    var xhr = new XMLHttpRequest(), //
            method = "POST",
            url = "/LaboratorioWEBLCI/menuCTRL";
    xhr.open(method, url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            // alert(xhr.responseText);
            var json = JSON.parse(xhr.responseText); //reponseText returns the entire JSON file and we assign it to a javascript variable "json".
            //alert(json);
            var i;
            var filas = "";
            var opcionL;
            for (i = 0; i < json.length; i++) {
                filas += "<tr>";
                filas += "<td>" + json[i].id + "</td>";
                filas += "<td>" + json[i].nombre + "</td>";
                filas += "<td>" + (typeof json[i].obsv === 'undefined' ? '' : json[i].obsv) + "</td>";
                // filas += 	"<td><img src='../Recursos/Img/update.png'/>  </td>";
                // filas += 	"<td><img src='../Recursos/Img/delete.png'/>  </td>";
                filas += "</tr>";
                opcionL += "<option value= " + json[i].id + "> " + json[i].nombre + " </option>";
            }
            document.getElementById("cuepotablaMenu").innerHTML = filas;
            //  document.getElementById("lista_combo_menu").innerHTML = opcionL;
        }
    };
    xhr.send(JSON.stringify(datos = {bandera: 5}));
}


function recuperarMenu() {
    var xhr = new XMLHttpRequest(), //
            method = "POST",
            url = "/LaboratorioWEBLCI/menuCTRL";
    xhr.open(method, url, true);
//    xhr.setRequestHeader("Content-Type",
//                         "application/json;charset=UTF-8");

    xhr.onreadystatechange = function () {
        if ( xhr.status === 200 && (!xhr.responseText === null) ) {
            var json = JSON.parse(xhr.responseText);
            var i;
            for (i = 0; i < json.length; i++) {
                document.getElementById('id_menu').value = json[i].id;
                document.getElementById('nombre_menu').value = json[i].nombre;
                document.getElementById('obsv_menu').value = json[i].obsv;
            }
        }else{
            alert('No existe dato... ');
        }
    };
    xhr.send(JSON.stringify(datos = {bandera: 4, id: document.getElementById('id_menu').value}));
}


function myFunction() {
    var input, filter, table, tr, td, i;
    input = document.getElementById("datofiltro");
    filter = input.value.toUpperCase();
    table = document.getElementById("cuepotablaMenu");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}


