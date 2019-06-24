
function createMember() {
    let user = {
        firstname: document.getElementById('firstname').value,
        lastname: document.getElementById('lastname').value
    };
    makeRequest("Post", path + "members/createMember", JSON.stringify(user)).then(resolve => {  
 window.location.href="getAllMembers.html";
   
});
}


function getAllMembers() {
    makeRequest("GET", path + "members/getAllMembers").then(value => {

        const container = document.getElementById('membersTable');

        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (let j = tableSize; j > 1; j--) {
                container.deleteRow(j - 1);
            }

        }

        for (let i = 0; i < value.length; i++) {
            let myRow = document.createElement('tr');
            container.appendChild(myRow);
            let myMemberid = document.createElement('td');
            myMemberid.innerHTML = value[i].memberid;
            let myFirstName = document.createElement('td');
            myFirstName.innerHTML = value[i].firstname;
            let myLastName = document.createElement('td');
            myLastName.innerHTML = value[i].lastname;

            myRow.appendChild(myMemberid);
            myRow.appendChild(myFirstName);
            myRow.appendChild(myLastName);



            let detail = document.createElement('td');
            let detailButton = document.createElement('button');

            detailButton.id = value[i].memberid;
            detailButton.innerText = "Delete Member";
            detailButton.onclick = detailButtonHandler;
            detail.innerHTML = detailButton;

            myRow.appendChild(detailButton);
        }

    })
        .catch((error) => console.log(error.message));
    return false;
}

const detailButtonHandler = () => {


    sessionStorage.setItem('memberid', event.target.id)
   



        const memberiq = sessionStorage.getItem('memberid');


        makeRequest("DELETE", path + "members/deleteMember/" + memberiq).then(resolve => { console.log(resolve) });

}

    function updateMember() {
        let user = {
            firstname: document.getElementById('firstname2').value,
            lastname: document.getElementById('lastname2').value
        };
        let id = Number(document.getElementById("memberid").value);
        makeRequest("PUT", path + "members/updateMember/" + id, JSON.stringify(user)).then(resolve => {  
        window.location.href="getAllMembers.html";
    });
    }


    function findMember(){
        let id=Number(document.getElementById('memberid3').value)
       makeRequest("GET", path + "members/findMember/" +id).then(value => {
    
       const container = document.getElementById('membersTable');

       if (container.rows.length > 1) {

           let tableSize = container.rows.length;
           for (k = tableSize; k > 1; k--) {
               container.deleteRow(k - 1);
           }

      }
           let myRow = document.createElement('tr');
           container.appendChild(myRow);
           let myMemberid = document.createElement('td');
           myMemberid.innerHTML = value.memberid;
           let myFirstName = document.createElement('td');
           myFirstName.innerHTML = value.firstname;
           let myLastName = document.createElement('td');
           myLastName.innerHTML = value.lastname;

           myRow.appendChild(myMemberid);
          myRow.appendChild(myFirstName);
          myRow.appendChild(myLastName);
  



        let detail = document.createElement('td');
           let detailButton = document.createElement('button');

           detailButton.id = value.memberid;
          detailButton.innerText = "Delete Member";
           detailButton.onclick = detailButtonHandler;
           detail.innerHTML = detailButton;

           myRow.appendChild(detailButton);

   })
       .catch((error) => console.log(error.message));
   return false;
}
    
