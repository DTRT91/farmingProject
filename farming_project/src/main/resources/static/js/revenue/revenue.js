const cropBtn = document.querySelectorAll(".custom-control-input");
const area = document.querySelector("#area");
const modal = new bootstrap.Modal(document.getElementById('myModal')); //모달 버튼
const openModalBtn = document.querySelector("#open-modal");

//작물 버튼 클릭
cropBtn.forEach(function(event) {
    event.addEventListener('click', (e) => {
        const selectedCrop =e.target.value;
        const cropLabel = document.getElementsByClassName('custom-control-label');
        const openModalBtn = document.querySelector("#open-modal");

        openModalBtn.dataset.selectedCrop = selectedCrop;

        area.innerHTML ="";

        for(let i =0; i<cropLabel.length; i++){
            if(cropLabel[i].getAttribute("value") === selectedCrop){
                console.log(cropLabel[i].getAttribute("for"));
                const selectedCropId = (i+1);
                console.log(selectedCropId);
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
        newButton.setAttribute("value",data[i].areaName);
        newButton.textContent = data[i].areaName;
        newCell.appendChild(newButton);
        }
        let areaButtons = document.querySelectorAll(".btn-area");

        areaButtons.forEach((item)=>{
            item.addEventListener("click",(e)=>{
                openModalBtn.dataset.selectedArea = e.target.value;
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

function getSelectedArea(){
const areaTable = document.querySelector("#area");
openModalBtn.dataset.selectedArea = selectedArea.value;;

areaTable.addEventListener('click', ()=>{
    getSelectedArea();
    console.log()
})
}



function modalOpen(){
	const selectedCrop = openModalBtn.dataset.selectedCrop;
	console.log(selectedCrop);
	const selectedArea = openModalBtn.dataset.selectedArea;
	console.log(selectedArea);
    const params = {
                "areaName" : selectedArea,
                "cropName" : selectedCrop
            }

		openModalBtn.addEventListener("click", ()=>{
		modal.show();
        getCropAreaRevenue(params);

          const insertBtn = document.querySelector("#insertBtn");
		});
	}


function modalClose(){
	const closeModalBtn = document.querySelectorAll(".close");
	closeModalBtn.forEach( (e)=>{
		e.addEventListener('click', ()=>{
			console.log("닫기 버튼 활성화");
			modal.hide();
		});
	});
}

//매출 가져오는 로직
function getCropAreaRevenue(params){

fetch(`/getCropAreaRevenue/${params}`, {
    Method : "GET",
    headers : {
    "Content-Type" : "application/json",
    },
    })
    .then((response) => response.json())
    .then(data => {
    console.log(data);
//    drawChart();
    })
    .catch((e) => {
    console.log(e);
    });
}
modalOpen();
modalClose();

////차트 그리는 로직
//function drawChart(cropAreaDto)
//const ctx = document.getElementById('myChart').getContext('2d');
//          const myChart = new Chart(ctx, {
//              type: 'line',
//              data: {
//                  labels: ['Green'],
//                  datasets: [{
//                      label: 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014,
//                             2015, 2016, 2017, 2018, 2019, 2020, 2021, 2023,
//                      data: [12, 19, 3, 5, 2, 3],
//                      backgroundColor: [
//                          'rgba(75, 192, 192, 0.2)'
//                      ],
//                      borderColor: [
//                          'rgba(75, 192, 192, 1)'
//                      ],
//                      borderWidth: 1
//                  }]
//              },
//              options: {
//                  scales: {
//                      y: {
//                          beginAtZero: false
//                      }
//                  }
//              }
//          });
//
//
//

//저장 버튼 클릭
//insertBtn.addEventListener('click', ()=>{
//
//});