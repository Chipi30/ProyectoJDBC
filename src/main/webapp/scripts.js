//esto es lo q hixo el profe en clase
const xhr = new XMLHttpRequest();
xhr.open('get','servlet-test?code=234563',true)
xhr.onreadystatechange = ()=>{
    if( xhr.readyState === 4 && xhr.status === 200 ){
        const students = JSON.parse( xhr.responseText)
        console.log( xhr.responseText)
        //students.forEach( student => alert(`${student.code} ${student.surname} ${student.name}`))
    }
}
xhr.send(null)

document.getElementById('button').addEventListener('click',()=>{
    const code= document.getElementById('code').value;
    const surname= document.getElementById('surname').value;
    const name= document.getElementById('name').value;

    const xhr = new XMLHttpRequest();
    xhr.open('post','servlet-test',true)
    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            alert(xhr.responseText)
        }
    }
    const data = `code=${code}&surname=${surname}&name=${name}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send( data )

})