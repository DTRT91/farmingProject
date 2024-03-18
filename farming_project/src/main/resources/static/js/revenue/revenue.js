const cropBtn = document.querySelectorAll(".custom-control-input");
const area = document.querySelector("#area");
const modal = new bootstrap.Modal(document.getElementById('myModal'));//모달 버튼
const openModalBtn = document.querySelector("#open-modal");

//작물 버튼 클릭
cropBtn.forEach(function(event) {
    event.addEventListener('click', (e) => {
        const selectedCrop =e.target.value;
        const cropLabel = document.getElementsByClassName('custom-control-label');
        const openModalBtn = document.querySelector("#open-modal");

        area.innerHTML ='';

        for(let i =0; i<cropLabel.length; i++){
            if(cropLabel[i].getAttribute("value") === selectedCrop){
                console.log(cropLabel[i].getAttribute("for"));
                const selectedCropId = (i+1);
                 openModalBtn.dataset.selectedCropId = selectedCropId;
                getAreaList(selectedCropId);
            }
        }
    });
})

function getAreaList(selectedCropId){
    fetch(`/areaList/${selectedCropId}`, {
    Method : "GET",
    headers : {
    "Content-Type" : "application/json",
    },
    })
    .then((response) => response.json())
    .then(data => {
    showAreaList(data);
    showCropInfo(selectedCropId);
    })
    .catch((e) => {
    console.log(e);
    });
}
//
function showAreaList(data){
    if(data){
        for(let i=0; i<data.length; i++){
        const newRow = area.insertRow();
        const newCell = newRow.insertCell();
        const newButton = document.createElement("input");
        newButton.setAttribute("type", "button");
        newButton.classList.add("btn-area", "btn");
        newButton.setAttribute('value',data[i].areaName);
        newButton.textContent = data[i].areaName;
        newCell.appendChild(newButton);
        }
        let areaButtons = document.querySelectorAll(".btn-area");

        areaButtons.forEach((item)=>{
            item.addEventListener("click",(e)=>{
            const selectedArea = e.target.value;
            openModalBtn.dataset.selectedArea = selectedArea;
            for(let i=0; i<data.length; i++){
            if(selectedArea == data[i].areaName){
            openModalBtn.dataset.areaId = data[i].areaId;
             console.log(data[i].areaId);
            }
            }

            });
        });
    }
}

function showCropInfo(selectedCropId){
const areaImage = document.querySelector(".page");
const cropLabel = document.getElementsByClassName('custom-control-label');

areaImage.innerHTML ='';

    for(let i =0; i<cropLabel.length; i++){
        if(cropLabel[i].getAttribute("for") === "cropId" + `${selectedCropId}`){
            const selectedCrop = cropLabel[i].getAttribute("value");
            console.log(selectedCrop);
            cropImage = selectedCrop.trim();

            const image = new Image();
            image.src=`../images/${cropImage}.jpg`
            areaImage.appendChild(image);
        }
    }
}

//매출 확인 버튼
openModalBtn.addEventListener("click", ()=>{
        const cropId = openModalBtn.dataset.selectedCropId.trim();
        	console.log(cropId);
        	const areaId = openModalBtn.dataset.areaId;
        	console.log(areaId);
        	const insertBtn = document.querySelector("#insertBtn");
        	getCropAreaRevenue(cropId, areaId);

        	modal.show();
});

//닫기버튼
	const closeModalBtn = document.querySelectorAll(".close");
	closeModalBtn.forEach( (e)=>{
		e.addEventListener('click', ()=>{
			console.log("닫기 버튼 활성화");
			modal.hide();
		});
	});


//매출 가져오는 로직
function getCropAreaRevenue(cropId, areaId){
const insertBtn = document.querySelector("#insertBtn");
insertBtn.dataset.cropId = cropId;
insertBtn.dataset.areaId = areaId;

fetch(`/getCropAreaRevenue/?cropId=${cropId}&areaId=${areaId}`, {
    Method : "GET",
    headers : {
    "Content-Type" : "application/json",
    },
    })
    .then((response) => response.json())
    .then(data => {
    console.log(data);
    drawChart(data);
    })
    .catch((e) => {
    console.log(e);
    });
}

//차트 그리는 로직
function drawChart(data){
var years = new Array();
var salesResult = new Array();
console.log(data[0].salesResult);
for(var i=0; i<data.length; i++){
    years[i] = data[i].years;
}
years[data.length] = 2023;
console.log(years[data.length]);
for(var i=0; i<data.length; i++){
    salesResult[i] = data[i].salesResult / 10000;
}
salesResult[data.length] = data[0].preSalesResult;
console.log(salesResult[data.length]);

insertBtn.dataset.salesResult = salesResult;

const backgroundColor = [];
for (i=0; i< data.length; i++) {
    const r = Math.floor(Math.random() * 255);
    const g = Math.floor(Math.random() * 255);
    const b = Math.floor(Math.random() * 255);
    backgroundColor.push('rgba('+r+', '+g+', '+b+', 0.2)');
}

	let existingChart = Chart.getChart('myChart');
	if (existingChart) {
		existingChart.destroy();
		}

	var dbData = {
            			  labels: years,
            			  datasets: [
            			    {
            			      label: "매출 추이(10a, 원)",
            			      data: salesResult,
            			      fill: false,
            			      borderColor: backgroundColor,
            			      tension: 0.3,
            			    },
            			  ],
            			};
var ctx = document.getElementById('myChart').getContext('2d');
          const myChart = new Chart(ctx, {
              type: 'line',
              data: dbData,
              options: {}
          });
}


//저장 버튼 클릭
insertBtn.addEventListener('click', ()=>{
    historySave();
    });

function historySave(){
    const cropId = insertBtn.dataset.cropId.value;
    const areaId = insertBtn.dataset.areaId.value;
    const salesResult = insertBtn.dataset.salesResult;


    const historySaveData = {
        'cropId' : cropId,
        'areaId' : areaId,
        'salesResult' :  salesResult,
    }
    fetch(`/historySave`, {
            method : 'POST',
            headers : {
            'Content-Type' : 'application/json',
            },
            body : JSON.stringify(historySaveData),
            })
                .then((response) => response.json())
                .then(data => {
                console.log(data);
                if(data > 0){
                alert('저장되었습니다.');
                modal.hide();
                }else {
                alert('저장에 실패하였습니다.');
                modal.hide();
                }
                })
                .catch((e) => {
                console.log(e)
                });
    }


