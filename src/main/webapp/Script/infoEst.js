var data;

window.addEventListener("load", () => {
    const xhr = new XMLHttpRequest();
    xhr.open('GET','servlet-student',true);
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
})

document.querySelector("#id").addEventListener("keyup", (e) => {
    const value = document.querySelector("#id").value;
    const copy = data.filter(student => {
        return student.ID.toString().toUpperCase().includes(value.toUpperCase());
    });
    document.querySelector("#tableBody").innerHTML = "";
    copy.forEach(e => addToTable(e))

})

const addToTable = (object) => {
    const table = document.querySelector("#tableBody");
    const tr = document.createElement("tr");
    tr.innerHTML = `<td>${object.ID}</td><td>${object.name}</td><td>${object.curso}</td><td>${object.diciplina}</td>`;
    table.append(tr);
}
