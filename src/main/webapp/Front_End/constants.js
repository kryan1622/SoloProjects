const path = "http://34.65.166.135:8888/SoloProj/api/";


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