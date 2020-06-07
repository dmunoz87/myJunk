// David Munoz
// 25 April 2019
// COP 2831
// Professor Gabel
// onmouseout and onmouseover event handlers are demonstrated here

window.addEventListener("load", initAll, false);

var downTownDesc = "<p>Downtown is the southermost part of Manhattan. It is the central borough for business, culture and government in the City of New York. The World Trade Center, and Wall Street are located here as well as many court and government buildings.</p>";
var midTownDesc = "<p>Midtown is home to some of the city's most iconic buildings, including the Empire State Building, the Headquarters of the United Nations, Grand Central Terminal, the Rockefeller Center, Times Square and Broadway.</p>";
var upTownDesc = "<p>Uptown includes the neighborhoods of Harlem, and Washington Heights. It is not a major center of tourism like down town and mid town, but some tourist attractions lie within it, like Grant's Tomb, the Apollo Theater and the National Jazz Museum in Harlem.</p>";

var originalDesc = "Place mouse over one of the headings to see a description in this box.";

//function initAll sets onmouseover event for the headings on the page, and also sets the onmouseout events
function initAll(){
	document.getElementById("downTown").onmouseover = downTown;
	document.getElementById("midTown").onmouseover = midTown;
	document.getElementById("upTown").onmouseover = upTown;
	
	var mouseOutArray = document.getElementsByClassName("envHeadings");
	
	for(var i = 0; i < mouseOutArray.length; i++){
		mouseOutArray[i].onmouseout = mouseOut;
	}
}

// function downTown sets environmentTarget's innerHTML to downTownDesc string
function downTown(){
	document.getElementById("environmentTarget").innerHTML = downTownDesc;
}

// function midTown sets environmentTarget's innerHTML to midTownDesc string
function midTown(){
	document.getElementById("environmentTarget").innerHTML = midTownDesc;
}

// function upTown sets environmentTarget's innerHTML to upTownDesc string
function upTown(){
	document.getElementById("environmentTarget").innerHTML = upTownDesc;
}

// function mouseOut sets environmentTarget's innerHTML to default originalDesc string when user moves mouse away from heading
function mouseOut(){
	document.getElementById("environmentTarget").innerHTML = originalDesc;
}