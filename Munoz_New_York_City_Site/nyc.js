// David Munoz
// 25 April 2019
// COP 2831
// Professor Gabel
// cookie usage is demonstrated in this file, as well as time of day usage

window.addEventListener("load",initAll,false);

// function initAll is called after page loads
function initAll(){
	var expireDate = new Date();
	var person;
	
	var currentTime;
	var currentHour;
	var currentMinute;
	var ampm;
	var date = new Date();
	
	expireDate.setMonth(expireDate.getMonth()+6);
	
	var thisCookie = document.cookie.split('; ');
	
	getTime();
	
	// this for loop checks for a "name" cookie, if one exists it is placed into var person then greeting message is displayed in greeting div
	for(var i = 0; i < thisCookie.length; i++){
		if ("name" == thisCookie[i].split('=')[0]){
			person = thisCookie[i].split("=")[1];
			document.getElementById("greeting").innerHTML = "Welcome back " + person + "! The time is now " + currentTime;
		}
	}
	
	// if person is null, prompt user to enter name, then store name in cookie and create greeting message in greeting div
	if(person == ""){
		person = prompt("Please enter your name:", "");
		
		if(person != null || person != ""){
			document.cookie = "name=" + person + ";expires=" + expireDate.toGMTString();
			
			document.getElementById("greeting").innerHTML = "Welcome " + person + "! The time is now " + currentTime;
		}
	
	}
	
	function getTime(){
		// if current hour is greater than 12, subtract by 12 so that we are not using army time, and store in var currentHour
		if(date.getHours() > 12){
			currentHour = date.getHours() - 12;
		}
		else{
			currentHour = date.getHours();
		}
		
		// if current minute is less than 10, add a 0 in front of number and store in var currentMinute
		if(date.getMinutes() < 10){
			currentMinute = "0" + date.getMinutes();
		}
		else { // else we just store current minute in var currentMinute
			currentMinute = date.getMinutes();
		}
		
		// if current hour is after noon, store pm in var ampm
		if(date.getHours() > 11){
			ampm = "pm";
		} 
		else if(date.getHours() < 12){ // else if current hour is before noon, store am in var ampm 
			ampm = "am";
		}
		
		// create time string then update currentTime span with new string
		currentTime = currentHour + ":" + currentMinute + " " + ampm;
		
	}
	
}