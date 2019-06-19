function makeRequest(method, url, body) {

    return new Promise(function (resolve, reject) {
        const req = new XMLHttpRequest

        req.open(method, url);
        req.send(body);
        req.onload = function () {
            const data = JSON.parse(req.responseText);
            if (req.status === 200) {
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

function createMember() {
    let user = {
        firstname: document.getElementById('firstname').value,
        lastname: document.getElementById('lastname').value
    };
    makeRequest("Post", "http://localhost:8080/SoloProj/api/members/createMember", JSON.stringify(user)).then(resolve => { console.log(resolve) });

}


function getAllMembers() {
    makeRequest("GET", "http://localhost:8080/SoloProj/api/members/getAllMembers").then(value => {

        let data = JSON.stringify(value);
        const container = document.getElementById('membersTable');
        console.log(value[0]);

        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (i = tableSize; i > 1; i--) {
                container.deleteRow(i - 1);
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

            // let detail2 = document.createElement('td');
            // let detail2Button2 = document.createElement('button');

            //     detail2Button2.id = value[i].memberid;
            // detail2Button2.innerText = "Update Member";
            // detail2.innerHTML = detail2Button2;

            // myRow.appendChild(detail2Button2);
        }

    })
        .catch((error) => console.log(error.message));
    return false;
}

const detailButtonHandler = () => {


    sessionStorage.setItem('memberid', event.target.id)
   



        const memberiq = sessionStorage.getItem('memberid');


        makeRequest("DELETE", "http://localhost:8080/SoloProj/api/members/deleteMember/" + memberiq).then(resolve => { console.log(resolve) });

}

    function updateMember() {
        let user = {
            firstname: document.getElementById('firstname2').value,
            lastname: document.getElementById('lastname2').value
        };
        let id = Number(document.getElementById("memberid").value);
        makeRequest("PUT", "http://localhost:8080/SoloProj/api/members/updateMember/" + id, JSON.stringify(user)).then(resolve => { console.log(resolve) });
       
    }
