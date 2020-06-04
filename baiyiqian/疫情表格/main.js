var columnDefs = [
    { headerName: "疫情地区", field: "provinceName" },
    { headerName: "累计", field: "confirmedCount" },
    // { headerName: "新增", field: "model" },
    { headerName: "疑似", field: "suspectedCount" },
    { headerName: "现有", field: "currentConfirmedCount" },
    { headerName: "治愈", field: "curedCount" },
    { headerName: "死亡", field: "deadCount" }
];


// let the grid know which columns and what data to use
var gridOptions = {
    columnDefs: columnDefs,
    rowData: [],
    defaultColDef: {
        resizable: true,
        animateRows:true,
        sortable: true
    },
    onFirstDataRendered: onFirstDataRendered,
};

function onFirstDataRendered(params) {
    params.api.sizeColumnsToFit();
  }
  

// setup the grid after the page has finished loading
document.addEventListener('DOMContentLoaded', function () {
    get().then(res => {
        console.log(res);
        let arr = JSON.parse(res).results;
        console.log(arr);
        
       let data = arr.filter((item) => {
            console.log(item);
            return item.countryEnglishName ===  'China';
          });

        console.log(data);
        gridOptions.rowData = data;
        console.log(gridOptions.rowData);
        var gridDiv = document.querySelector('#myGrid');
        new agGrid.Grid(gridDiv, gridOptions);
    }).catch(error => {
        console.log(error);
    })


});
//  获取数据
function get() {
    return new Promise(function (resolve, reject) {
        try {

            let xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && (xhr.status === 200 || xhr.status === 304)) {
                    console.log(xhr.responseText);
                }
            };
            xhr.open("GET", "https://lab.isaaclin.cn/nCoV/api/area", true);
            xhr.send();

            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    resolve(xhr.responseText)
                }
            }

        } catch (error) {
            reject(error)
        }
    })
};