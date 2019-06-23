

function createClass() {
    let cla = {
        classname: document.getElementById('classname').value,
        instructors: {
            instructorid: Number(document.getElementById('instructorid').value)
        } 
    };
    makeRequest("Post", path + "classes/createClass", JSON.stringify(cla)).then(resolve => {
window.location.href="getallClasses.html";
});
}


function getAllClasses() {
    makeRequest("GET", "http://34.65.166.135:8888/SoloProj/api/classes/getAllClasses").then(value => {
        const container = document.getElementById('classTable');
    

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


         makeRequest("GET", "http://34.65.166.135:8888/SoloProj/api/classes/getAllClasses").then(value => {
            const container = document.getElementById('instructorTable');
    
             if (container.rows.length > 1) {
    
                 let tableSize = container.rows.length;
                 for (i = tableSize; i > 1; i--) {
                     container.deleteRow(i - 1);
                 }
    
            }
    
            
                 let myRow = document.createElement('tr');
                 container.appendChild(myRow);
                 let myInstructorid = document.createElement('td');
                 myInstructorid.innerHTML = value[classiq-1].instructors.instructorid;
                 let myFirstName = document.createElement('td');
                 myFirstName.innerHTML = value[classiq-1].instructors.firstname;
                 let myLastName = document.createElement('td');
                 myLastName.innerHTML = value[classiq-1].instructors.lastname;
    
                 myRow.appendChild(myInstructorid);
                myRow.appendChild(myFirstName);
                myRow.appendChild(myLastName);
        
            

            })
            .catch((error) => console.log(error.message));
            return false;
          }

          const detail2Button2Handler = () => {

            sessionStorage.setItem('classid', event.target.id)
       
                const classiq = sessionStorage.getItem('classid');

                makeRequest("DELETE", "http://34.65.166.135:8888/SoloProj/api/classes/deleteClass/" + classiq).then(resolve => { console.log(resolve) });

            }
        
     function updateClass() {
          let cla = {
              classname: document.getElementById('classname2').value,
              instructors: {
                instructorid: Number(document.getElementById('instructorid2').value)
              }
          };
          let id = Number(document.getElementById("classid2").value);
          makeRequest("PUT", "http://34.65.166.135:8888/SoloProj/api/classes/updateClass/" + id, JSON.stringify(cla)).then(resolve => { 
          window.location.href="getallClasses.html";
        });
     }

     function findClass(){
         let id=Number(document.getElementById('classid3').value)
        makeRequest("GET", "http://34.65.166.135:8888/SoloProj/api/classes/findClass/" +id).then(value => {
     
        const container = document.getElementById('classTable');

        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (i = tableSize; i > 1; i--) {
                container.deleteRow(i - 1);
            }

       }
            let myRow = document.createElement('tr');
            container.appendChild(myRow);
            let myClassid = document.createElement('td');
            myClassid.innerHTML = value.classid;
            let myClassName = document.createElement('td');
            myClassName.innerHTML = value.classname;

            myRow.appendChild(myClassid);
           myRow.appendChild(myClassName);
   



         let detail = document.createElement('td');
            let detailButton = document.createElement('button');

            detailButton.id = value.classid;
           detailButton.innerText = "Instructor information";
            detailButton.onclick = detailButtonHandler;
            detail.innerHTML = detailButton;

            myRow.appendChild(detailButton);

            let detail2 = document.createElement('td');
            let detail2Button2 = document.createElement('button');

            detail2Button2.id = value.classid;
            detail2Button2.innerText = "Delete Class";
            detail2Button2.onclick = detail2Button2Handler;
            detail2.innerHTML = detail2Button2;

            myRow.appendChild(detail2Button2);


    })
        .catch((error) => console.log(error.message));
    return false;
}


   
