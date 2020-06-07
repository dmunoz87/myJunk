// David Munoz
// 25 April 2019
// COP 2831
// Professor Gabel
// image slideshow is demonstrated in this file

window.addEventListener("load", initAll, false);

var currImg = 0;
var imgTitle = ["Statue of Liberty", "Twin Towers", "Teardrop Memorial", "Ellis Island", "Times Square"];
var imgCaption = ["The Statue of Liberty is a colossal neoclassical sculpture on Liberty Island in New York Harbor in New York. It was dedicated on October 28, 1886 and stands 151 feet tall.",
				  "The Twin Towers opened in 1973. Standing at 110 stories tall, these buildings were the cherry on top for the New York skyline. They were destroyed in 2001.",
				  "The Teardrop Memorial was dedicated on September 11, 2006. It is in rememberance of the terrorist attacks on New York City from 9/11.",
				  "Ellis Island was opened January 1, 1892. It was the gateway for over 12 million immigrants to the United States.",
				  "Times Square is a major commercial intersection, tourist destination, entertainment center and neighborhood in New York City. It is the site of the annual New Years Eve Ball Drop which began in 1907 and continues today."];

// function initAll() sets the image title and caption to the item in the 0 index of each array
// and adds event listeners for the previous and next buttons that call newSlide() function
function initAll(){
	document.getElementById("imgTitle").innerHTML = imgTitle[currImg];
	document.getElementById("imgCaption").innerHTML = imgCaption[currImg];
	document.getElementById("prevLink").addEventListener("click",function() {newSlide(-1);},false);
	document.getElementById("nextLink").addEventListener("click",function() {newSlide(1);},false);
}

// function newSlide() takes an integer parameter
// var imgCt is set to 6 which, the size of imgCaption array
// currImg is added to direction integer that was passed in
// if currImg is less than 0, currImg is set to 5
// if currImg is equal to imgCt, which is 6, currImg is set to 0, this way the previous and next buttons keep cycling through the images in the folder
// then image is changed to currImg number, the title is changed to value in the currImg index of array imgTitle, and the caption is changed to the value
// in the currImg index array of imgCaption
function newSlide(direction) {
	var imgCt = imgCaption.length;
	
	currImg = currImg + direction;
	if (currImg < 0){
		currImg = imgCt - 1;
	}
	if (currImg == imgCt) {
		currImg = 0;
	}
	document.getElementById("slideshow").src = "images/image" + currImg + ".jpg";
	document.getElementById("imgTitle").innerHTML = imgTitle[currImg];
	document.getElementById("imgCaption").innerHTML = imgCaption[currImg];
}