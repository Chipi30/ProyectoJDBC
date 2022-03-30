window.addEventListener("load", () => {
    const xhr = new XMLHttpRequest();
    xhr.open('GET','servlet-student',true);
    xhr.onload = () => {
        if (xhr.status === 200 && xhr.readyState === 4) {
            const response = JSON.parse(xhr.responseText);
            for (const responseKey of response) {
                addToTable(responseKey)
            }
        }
    }
    xhr.send();
})


const addToTable = (object) => {
    const table = document.querySelector("#tableBody");
    const tr = document.createElement("tr");
    tr.innerHTML = `<td>${object.ID}</td><td>${object.name}</td><td>${object.curso}</td><td>${object.diciplina}</td><td>${object.posicion}</td>`;
    table.append(tr);
}
