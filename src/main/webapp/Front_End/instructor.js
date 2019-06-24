
function createInstructor() {
    let instructor = {
        firstname: document.getElementById('firstname').value,
        lastname: document.getElementById('lastname').value
    };
    makeRequest("Post", path + "instructors/createInstructor", JSON.stringify(instructor)).then(resolve => { 
        window.location.href="getAllInstructors.html";
});

}


function getAllInstructors() {
    makeRequest("GET", path + "instructors/getAllInstructors").then(value => {

        const container = document.getElementById('instructorsTable');
    
        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (let j = tableSize; j > 1; j--) {
                container.deleteRow(j - 1);
            }

        }

        for (let i = 0; i < value.length; i++) {
            let myRow = document.createElement('tr');
            container.appendChild(myRow);
            let myInstructorid = document.createElement('td');
            myInstructorid.innerHTML = value[i].instructorid;
            let myFirstName = document.createElement('td');
            myFirstName.innerHTML = value[i].firstname;
            let myLastName = document.createElement('td');
            myLastName.innerHTML = value[i].lastname;

            myRow.appendChild(myInstructorid);
            myRow.appendChild(myFirstName);
            myRow.appendChild(myLastName);
        }

    })
        .catch((error) => console.log(error.message));
    return false;
}

const detailButtonHandler = () => {


    sessionStorage.setItem('instructorid', event.target.id)
   



        const instructoriq = sessionStorage.getItem('instructorid');


        makeRequest("DELETE", path + "instructors/deleteInstructor/" + instructoriq).then(resolve => { console.log(resolve) });

}

    function updateInstructor() {
        let instructor = {
            firstname: document.getElementById('firstname2').value,
            lastname: document.getElementById('lastname2').value
        };
        let id = Number(document.getElementById("instructorid").value);
        makeRequest("PUT", path + "instructors/updateInstructor/" + id, JSON.stringify(instructor)).then(resolve => { console.log(resolve) });
        window.location.href="getAllInstructors.html";
    }

    function findInstructor(){
        let id=Number(document.getElementById('instructorid3').value)
       makeRequest("GET", path + "instructors/findInstructor/" +id).then(value => {
    
       const container = document.getElementById('instructorsTable');


       if (container.rows.length > 1) {

           let tableSize = container.rows.length;
           for (i = tableSize; i > 1; i--) {
               container.deleteRow(i - 1);
           }

      }
           let myRow = document.createElement('tr');
           container.appendChild(myRow);
           let myInstructorid = document.createElement('td');
           myInstructorid.innerHTML = value.instructorid;
           let myFirstName = document.createElement('td');
           myFirstName.innerHTML = value.firstname;
           let myLastName = document.createElement('td');
           myLastName.innerHTML = value.lastname;

           myRow.appendChild(myInstructorid);
          myRow.appendChild(myFirstName);
          myRow.appendChild(myLastName);


   })
       .catch((error) => console.log(error.message));
   return false;
}