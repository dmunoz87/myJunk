// David Munoz
// 25 April 2019
// COP 2831
// Professor Gabel
// JSON weather feed is demonstrated in this file

window.addEventListener("load", initAll, false);
var xhr = false;

// initAll function creates new XMLHttpRequest object, then adds an event listener for readystatechange, and when that happens we call showWeather function
function initAll(){
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	}
	else{
		if(window.ActiveXObject){
			try{
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(e){
				
			}
		}
	}
	if (xhr) {
		xhr.addEventListener("readystatechange", showWeather, false);
		xhr.open("GET", "http://api.openweathermap.org/data/2.5/weather?lat=40.71&lon=-74.01&units=imperial&APPID=0d8d1938fe0f5699ac3353930554bcf4&format=json", true);
		xhr.send(null);
	}
	else {
        alert("Sorry, but I couldn't create an XMLHttpRequest");
    }
}

// function showWeather creates new div containers to hold parameters from json file
// then checks that XMLHttpRequest is ready, then creates new strings for each parameter from request, appends that to created divs, then the divs are appended to document.body

function showWeather(){
	var nameDiv = document.createElement("div");
	var tempDiv = document.createElement("div");
	var lowTempDiv = document.createElement("div");
	var highTempDiv = document.createElement("div");
	var conditionsDiv = document.createElement("div");
	
	if (xhr.readyState == 4){
		if (xhr.status == 200){
			var r = JSON.parse(xhr.response);
			
			var name = document.createTextNode(r.name);
			nameDiv.innerHTML = "City Name: ";
			nameDiv.appendChild(name);
			
			var temp = document.createTextNode(r.main.temp);
			tempDiv.innerHTML = "Temperature: ";
			tempDiv.appendChild(temp);
			
			var lowTemp = document.createTextNode(r.main.temp_min);
			lowTempDiv.innerHTML = "Low Temp: ";
			lowTempDiv.appendChild(lowTemp);
			
			var highTemp = document.createTextNode(r.main.temp_max);
			highTempDiv.innerHTML = "High Temp: ";
			highTempDiv.appendChild(highTemp);
			
			var conditions = document.createTextNode(r.weather[0].description);
			conditionsDiv.innerHTML = "Current Conditions: ";
			conditionsDiv.appendChild(conditions);
			
			document.getElementById("weather").appendChild(nameDiv);
			document.getElementById("weather").appendChild(tempDiv);
			document.getElementById("weather").appendChild(lowTempDiv);
			document.getElementById("weather").appendChild(highTempDiv);
			document.getElementById("weather").appendChild(conditionsDiv);
		}
	}
}