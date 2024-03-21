        console.log(loginUser);
        if(loginUser != null){
        document.querySelector('#loginModalBtn').classList.add('d-none');
        document.querySelector('#logout').classList.remove('d-none');
        console.log("로그인 완료");
        } else if (loginUser == null) {
        document.querySelector('#loginModalBtn').classList.remove('d-none');
        document.querySelector('#logout').classList.add('d-none');
        console.log('로그아웃 완료');
        }
const userId = loginUser.userid;
console.log(userId);
const revenueTable = document.querySelector("#revenueTable");

 const historyLoadBtn = document.querySelector("#historyLoad");
 historyLoadBtn.addEventListener('click', ()=>{
 revenueTable.innerHTML ='';
 historyLoad(userId);
 });

function historyLoad(userId){
    fetch(`/historyLoad/${userId}`, {
    method : 'GET' ,
    headers : {
    'Content-Type' : 'application/json',
    },
    })
    .then((response) => response.json())
    .then(data => {
    console.log(data);
    inputData(data);
    })
    .catch((e) => {
    console.log(e);
    });
}

function inputData(data){

        data.forEach((item)=>{
        var row = document.all['revenueTable'].insertRow();

        var cellCrop = row.insertCell();
        var cellArea = row.insertCell();
        var cellRevenue = row.insertCell();

        cellCrop.innerHTML = "<input type='text'/>";
        cellCrop.innerText = item.cropId;
        cellArea.innerHTML = "<input type='text'/>";
        cellArea.innerText = item.areaId;
        cellRevenue.innerHTML = "<input type='text'/>";
        cellRevenue.innerText = item.salesResult;
        });
}
