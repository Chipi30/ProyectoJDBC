var data;

window.addEventListener("load", () => {
    reloadTable();
})

const reloadTable = () => {
    document.querySelector("#tableBody").innerHTML = "";
    const xhr = new XMLHttpRequest();
    xhr.open('GET', 'servlet-dicipline?option=0', true);
    xhr.onload = () => {
        if (xhr.status === 200 && xhr.readyState === 4) {
            const response = JSON.parse(xhr.responseText);
            data = response;
            for (const responseKey of response) {
                addToTable(responseKey)
            }
        }
    }
    xhr.send(null);
}

document.querySelector("#diciplina-form").addEventListener("submit",(e)=>{
    e.preventDefault();
    const name = document.querySelector("#disciplina");

    const xhr = new XMLHttpRequest();
    xhr.open('POST','servlet-dicipline',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            name.value = "";
            reloadTable();
        }
    }
    const data1 = `&option=0&name=${name.value}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data1);
})

const addToTable = (object) => {
    const table = document.querySelector("#tableBody");
    const tr = document.createElement("tr");
    tr.innerHTML = `<td>${object.id}</td>
    <td>${object.nombre}</td>
    <td style="cursor: pointer; text-align: center" onclick="edit(${object.id})"><i class="fas fa-pen"></i></td>
    <td style="cursor: pointer; text-align: center" onclick="del(${object.id})"><i class="fas fa-trash"></i></td>`;
    table.append(tr);
}

const del = (index) =>{
    const xhr = new XMLHttpRequest();
    xhr.open('POST','servlet-dicipline?option=2',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            reloadTable();
        }
    }
    const data2 = `id=${index}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data2)
}


var modid
const edit = (index) =>{
    const modal = new bootstrap.Modal(document.querySelector("#exampleModal"));
    modal.show();
    modid = index;
}

document.querySelector("#mod-form").addEventListener("submit", (e) =>{
    e.preventDefault();
    const name = document.querySelector("#modname");

    const xhr = new XMLHttpRequest();
    xhr.open('POST','servlet-dicipline',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            const modal = new bootstrap.Modal(document.querySelector("#exampleModal"));
            modal.hide();
            name.value = "";
            reloadTable();
        }
    }
    const data2 = `&option=1&id=${modid}&name=${name.value}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data2);
})

