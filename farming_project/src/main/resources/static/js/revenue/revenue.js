//document.addEventListener("DOMContentLoaded", function() {
//getList();
//});
//
//
//
const cropBtn = document.querySelectorAll(".custom-control-input");
const area = document.querySelector("#area");

//작물 버튼 선택
cropBtn.forEach(function(event) {
event.addEventListener('click', (e) => {
let selectedCrop =e.target.value;
area.innerHTML ="";
getAreaList(selectedCrop);
});
})




function getAreaList(selectedCrop){
    fetch(`/areaList/${selectedCrop}`, {
    Method : "GET",
    headers : {
    "Content-Type" : "application/json",
    },
    })
    .then((response) => response.json())
    .then(data => {
    showAreaList(data);
    showCropInfo(selectedCrop);
    })
    .catch((e) => {
    console.log(e);
    });
}
//
function showAreaList(data){
const areaTable = document.querySelector("#area");

if(data){
for(let i=0; i<data.length; i++){
    let tr = document.createElement("tr");
    let td = document.createElement("td");

    tr.innerText = data[i].areaName;

    tr.appendChild(td);

    areaTable.appendChild(tr);
}
}
}

function showCropInfo(selectedCrop){
const areaImage = document.querySelector(".page");
areaImage.innerHTML ='';
cropImage = selectedCrop.trim();

const image = new Image();
image.src=`../images/${cropImage}.jpg`
areaImage.appendChild(image);
}

function modalOpen(){
	const openModalBtn = document.querySelector("#open-modal");

		openModalBtn.addEventListener("click", ()=>{
		  const ctx = document.getElementById('myChart').getContext('2d');
          const myChart = new Chart(ctx, {
              type: 'line',
              data: {
                  labels: ['Green'],
                  datasets: [{
                      label: 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014,
                             2015, 2016, 2017, 2018, 2019, 2020, 2021, 2023,
                      data: [12, 19, 3, 5, 2, 3],
                      backgroundColor: [
                          'rgba(75, 192, 192, 0.2)'
                      ],
                      borderColor: [
                          'rgba(75, 192, 192, 1)'
                      ],
                      borderWidth: 1
                  }]
              },
              options: {
                  scales: {
                      y: {
                          beginAtZero: false
                      }
                  }
              }
          });
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

//저장 버튼 클릭
insertBtn.addEventListener('click', ()=>{

});



