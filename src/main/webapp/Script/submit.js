window.addEventListener("load", () => {
    const xhr = new XMLHttpRequest();
    xhr.open('GET','servlet-dicipline?option=0',true);
    xhr.onload = () => {
        if (xhr.status === 200 && xhr.readyState === 4){
            const resp = JSON.parse(xhr.responseText);
            const select = document.querySelector("#disciplina");
            const selectmod = document.querySelector("#moddisciplina");
            resp.forEach(e => {
                select.appendChild(new Option(e.nombre, e.id));
                selectmod.appendChild(new Option(e.nombre, e.id));
            })
        }
    }
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(null);

    const xhr2 = new XMLHttpRequest();
    xhr2.open('GET','servlet-event?option=0',true);
    xhr2.onload = () => {
        if (xhr2.status === 200 && xhr2.readyState === 4){
            const resp = JSON.parse(xhr2.responseText);
            const select = document.querySelector("#evento");
            const selectmod = document.querySelector("#modevento");
            resp.forEach(e => {
                select.appendChild(new Option(e.nombre, e.id));
                selectmod.appendChild(new Option(e.nombre, e.id));
            })
        }
    }
    xhr2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr2.send(null);
})


document.querySelector("#student-form").addEventListener("submit", (e) => {
    e.preventDefault();
    const name = document.querySelector("#name");
    const curso = document.querySelector("#curso");
    const disciplina = document.querySelector("#disciplina");
    const evento = document.querySelector("#evento");
    const posicion = document.querySelector("#posicion");

    const xhr = new XMLHttpRequest();
    xhr.open('POST','servlet-student',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            alert("Registrado con exito");
            name.value = "";
            curso.value = "";
            posicion.value = "";
        }
    }
    const data1 = `&option=0&name=${name.value}&disciplina=${disciplina.value}&evento=${evento.value}&curso=${curso.value}&posicion=${posicion.value}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data1);
})

document.querySelector("#delete-form").addEventListener("submit", (e)=>{
    e.preventDefault();
    const id = document.querySelector("#deleteId").value;
    const xhr = new XMLHttpRequest();

    xhr.open('post','servlet-student',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            alert(xhr.responseText);
        }
    }
    const data3 = `&option=1&deleteId=${id}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data3);
})

document.querySelector("#mod-btn").addEventListener("click",()=>{
    const id = document.querySelector("#modId").value;

    const xhr = new XMLHttpRequest();
    xhr.open('post','servlet-student',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            alert(xhr.responseText);
            if(xhr.responseText!=="null"){
                const response = JSON.parse(xhr.responseText);
                document.querySelector("#modname").value = response.name;
                document.querySelector("#modcurso").value = response.curso;
                document.querySelector("#moddisciplina").value = response.diciplina;
                document.querySelector("#modevento").value = response.evento;
                document.querySelector("#modposicion").value = response.posicion;
                const modal = new bootstrap.Modal(document.querySelector("#exampleModal"));
                modal.show();
            }else {
                alert("No se ha encontrado");
            }
        }
    }
    const data7 = `&option=2&id=${id}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data7);
})

document.querySelector("#mod-form").addEventListener("submit", (e)=>{
    e.preventDefault();
    const id = document.querySelector("#modId").value;
    const name = document.querySelector("#modname").value;
    const curso = document.querySelector("#modcurso").value;
    const disciplina = document.querySelector("#moddisciplina").value ;
    const evento = document.querySelector("#modevento").value;
    const posicion = document.querySelector("#modposicion").value;

    const xhr = new XMLHttpRequest();
    xhr.open('POST','servlet-student',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            alert("Actualizado con exito");
            const modal = new bootstrap.Modal(document.querySelector("#exampleModal"));
            modal.hide();
        }
    }
    const data2 = `&option=3&id=${id}&name=${name}&disciplina=${disciplina}&evento=${evento}&curso=${curso}&posicion=${posicion}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data2);
})