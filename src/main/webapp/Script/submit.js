window.addEventListener("load", () =>{
    const xhr = new XMLHttpRequest();
    xhr.open('get','hello-servlet',true)
    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            alert(xhr.responseText);
            const students = JSON.parse( xhr.responseText)
            console.log( xhr.responseText)
        }
    }
    xhr.send(null)
})

document.querySelector("#student-form").addEventListener("submit", (e) => {
    e.preventDefault();
    const name = document.querySelector("#name").value;
    const curso = document.querySelector("#curso").value;
    const disciplina = document.querySelector("#disciplina").value;
    const evento = document.querySelector("#evento").value;
    const posicion = document.querySelector("#posicion").value;

    const xhr = new XMLHttpRequest();
    xhr.open('POST','servlet-test',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            alert(xhr.responseText);
        }
    }
    const data1 = `&name=${name}&disciplina=${disciplina}&evento=${evento}&curso=${curso}&posicion=${posicion}`
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data1);
})

document.querySelector("#delete-form").addEventListener("submit", (e)=>{
    e.preventDefault();
    const id = document.querySelector("#deleteId").value;
    const xhr = new XMLHttpRequest();

    xhr.open('post','hello-servlet',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            if(xhr.responseText !== "Error al eliminar estudiante"){
                alert("Estudiante eliminado");
            }else {
                alert("No se ha encontrado");
            }
        }else {
        }
    }
    const data3 = `&deleteId=${id}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data3);
})

document.querySelector("#mod-btn").addEventListener("click",()=>{
    const id = document.querySelector("#modId").value;

    const xhr = new XMLHttpRequest();
    xhr.open('post','hello-servlet',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            if(xhr.responseText!=="null"){
                const response = JSON.parse(xhr.responseText);
                document.querySelector("#modname").value = response[1];
                document.querySelector("#modcurso").value = response[2];
                document.querySelector("#moddisciplina").value = response[3];
                document.querySelector("#modevento").value = response[4];
                const modal = new bootstrap.Modal(document.querySelector("#exampleModal"));
                modal.show();
            }else {
                alert("No se ha encontrado");
            }
        }
    }
    const data7 = `&id=${id}`;
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

    const xhr = new XMLHttpRequest();
    xhr.open('post','hello-servlet',true);
    xhr.onload = () => {
        if(xhr.status === 200 && xhr.readyState === 4){
            alert(xhr.responseText);
        }
    }
    const data2 = `id=${id}&name=${name}&disciplina=${disciplina}&evento=${evento}&curso=${curso}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data2);
})