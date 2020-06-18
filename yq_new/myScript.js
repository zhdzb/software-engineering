
function myFunction()
{
   let url = "https://lab.isaaclin.cn/nCoV/api/overall";

  $.getJSON(url,function(data,status){
	
      let res = data["results"][0].globalStatistics;

      $("#gconfirmedCount").text(res["confirmedCount"]);

      $("#gcurrentConfirmedCount").text(res["currentConfirmedCount"]);

      $("#gcuredCount").text(res["curedCount"]);

      $("#gdeadCount").text(res["deadCount"]);  

    }).fail(function () {
});
    
}
