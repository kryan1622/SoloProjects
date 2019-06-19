function makeRequest(method, url, body) {

    return new Promise(function (resolve, reject) {
        const req = new XMLHttpRequest

        req.open(method, url);
        req.send(body);
        req.onload = function () {
            const data = JSON.parse(req.responseText);
            if (req.status >= 200 || req.status < 300) {
                resolve(data);
            } else {
                reject(Error(req.statusText));
            }
        };
        req.onerror = function () {
            reject(Error("Network Error"))
        }
    })
}

function createClass() {
    let cla = {
        classname: document.getElementById('classname').value,
        instructors: {
            instructorid: Number(document.getElementById('instructorid').value)
        } 
    };
    makeRequest("Post", "http://localhost:8080/SoloProj/api/classes/createClass", JSON.stringify(cla)).then(resolve => { console.log(resolve) });

}


function getAllClasses() {
    makeRequest("GET", "http://localhost:8080/SoloProj/api/classes/getAllClasses").then(value => {

        let data = JSON.stringify(value);
        const container = document.getElementById('classTable');
        console.log(value[0].instructors.instructorid);

         if (container.rows.length > 1) {

             let tableSize = container.rows.length;
             for (i = tableSize; i > 1; i--) {
                 container.deleteRow(i - 1);
             }

        }

         for (let i = 0; i < value.length; i++) {
             let myRow = document.createElement('tr');
             container.appendChild(myRow);
             let myClassid = document.createElement('td');
             myClassid.innerHTML = value[i].classid;
             let myClassName = document.createElement('td');
             myClassName.innerHTML = value[i].classname;

             myRow.appendChild(myClassid);
            myRow.appendChild(myClassName);
    



          let detail = document.createElement('td');
             let detailButton = document.createElement('button');

             detailButton.id = value[i].classid;
            detailButton.innerText = "Instructor information";
             detailButton.onclick = detailButtonHandler;
             detail.innerHTML = detailButton;

             myRow.appendChild(detailButton);

             let detail2 = document.createElement('td');
             let detail2Button2 = document.createElement('button');

             detail2Button2.id = value[i].classid;
             detail2Button2.innerText = "Delete Class";
             detail2Button2.onclick = detail2Button2Handler;
             detail2.innerHTML = detail2Button2;

             myRow.appendChild(detail2Button2);
         }

     })
         .catch((error) => console.log(error.message));
     return false;
 }

 const detailButtonHandler = () => {


     sessionStorage.setItem('classid', event.target.id)
   
         const classiq = sessionStorage.getItem('classid');


         makeRequest("GET", "http://localhost:8080/SoloProj/api/classes/getAllClasses").then(value => {
            // let data = JSON.stringify(value);
            const container = document.getElementById('instructorTable');
            
    
             if (container.rows.length > 1) {
    
                 let tableSize = container.rows.length;
                 for (i = tableSize; i > 1; i--) {
                     container.deleteRow(i - 1);
                 }
    
            }
    
            //  for (let i = 0; i < 1; i++) {
                 let myRow = document.createElement('tr');
                 container.appendChild(myRow);
                 let myInstructorid = document.createElement('td');
                 myInstructorid.innerHTML = value[classiq].instructors.instructorid;
                 let myFirstName = document.createElement('td');
                 myFirstName.innerHTML = value[classiq].instructors.firstname;
                 let myLastName = document.createElement('td');
                 myLastName.innerHTML = value[classiq].instructors.lastname;
    
                 myRow.appendChild(myInstructorid);
                myRow.appendChild(myFirstName);
                myRow.appendChild(myLastName);
        
                // }

            })
            .catch((error) => console.log(error.message));
            return false;
          }

          const detail2Button2Handler = () => {

            sessionStorage.setItem('classid', event.target.id)
       
                const classiq = sessionStorage.getItem('classid');

                makeRequest("DELETE", "http://localhost:8080/SoloProj/api/classes/deleteClass/" + classiq).then(resolve => { console.log(resolve) });

            }
        
     function updateMember() {
          let user = {
              firstname: document.getElementById('firstname2').value,
              lastname: document.getElementById('lastname2').value
          };
          let id = Number(document.getElementById("memberid").value);
          makeRequest("PUT", "http://localhost:8080/SoloProj/api/members/updateMember/" + id, JSON.stringify(user)).then(resolve => { console.log(resolve) });
       
     }