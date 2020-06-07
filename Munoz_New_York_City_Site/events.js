// David Munoz
// 25 April 2019
// COP 2831
// Professor Gabel
// form handling javascript is located in this file as well as a countdown timer in function timeUntil() and an iframe that is the target for the links below it

window.addEventListener("load",initAll,false);

function initAll(){
	document.forms[0].onsubmit = validForm;
	
	timeUntil();
}

function validForm(){
	var allGood = true;
	
	resetClasses();
	
	var allTags = document.forms[0].getElementsByTagName("*");
	
	// this for loop accesses each tag in the document and calls the validTag function to start validation, the if statement changes var allGood to false if the current returns invalid
	for (var i = 0; i < allTags.length; i++) {
		if (!validTag(allTags[i])) {
			allGood = false;
		}
	}
	return allGood;
	
	// function validTag takes parameter thisTag and looks at the class names in each tag
	function validTag(thisTag){
		var outClass = "";
		var allClasses = thisTag.className.split(" ");
		
		// this for loop accesses each class in the current tag, calls the validBasedOnClass function passing it the current class at index j being observed
		for (var j = 0; j < allClasses.length; j++){
			outClass += validBasedOnClass(allClasses[j]) + " ";
		}
		
		thisTag.className = outClass;
		
		// if invalid is found anywhere in outClass, invalidLabel function is called and sent the label for the tag, and problematic tag is given focus
		if (outClass.indexOf("invalid") > -1) {
			invalidLabel(thisTag.parentNode);
			thisTag.focus();
			
			// if problematic tag is of type "input", then it is selected
			if (thisTag.nodeName == "INPUT") {
				thisTag.select();
			}
			return false;
		}
		return true;
		
		// function validBasedOnclass tests the class passed to it against the ones in the switch statement to validate based upon class names
		function validBasedOnClass(thisClass) {
			var classBack = "";
			
			switch(thisClass) {
				case "":
				case "invalid":
					break;
				case "reqd":
					if (allGood && thisTag.value == "") {
							classBack = "invalid ";
					}
					classBack += thisClass;
					break;
				case "radio":
					if (allGood && !radioPicked(thisTag.name)) {
						classBack = "invalid ";
					}
					classBack += thisClass;
					break;
				case "email":
					if (allGood && !validEmail(thisTag.value)) {
						classBack = "invalid ";		
					}
					classBack += thisClass;
					break;
				case "confirm":
					if(document.getElementById("email").value != document.getElementById("confirmEmail").value){
						classBack = "invalid ";
					}
					classBack += thisClass;
					break;
				case "phone":
					if (allGood && !validPhone(thisTag.value)){
						classBack = "invalid ";
					}
					classBack += thisClass;
					break;
				default:
					if (allGood && !crossCheck(thisTag,thisClass)) {
						classBack = "invalid ";
					}
					classBack += thisClass;
			}
			return classBack;
			
			// function crossCheck takes parameters for current tag being observed as inTag and current class being observed as otherFieldID
			// if otherFieldID doesn't exist there's a problem, return false
			// finally, boolean var is returned dependent upon whether the values for these parameters match or not
			function crossCheck(inTag,otherFieldID) {
              if (!document.getElementById(otherFieldID)) {
                 return false;
              }
              return (inTag.value == document.getElementById(otherFieldID).value);
           }
		}
		
		// function validEmail validates email field
		// first it checks for invalid characters, then checks that email is not empty, then checks that there is only one @ sign in the second position or beyond
		// then checks for a period after the @ sign, and finally, validEmail makes sure that there are at least two characters after the period in the address
		function validEmail(email) {
			var invalidChars = " /:,;";

			if (email == "") {
			   return false;
			}
			for (var k=0; k<invalidChars.length; k++) {
				var badChar = invalidChars.charAt(k);
				if (email.indexOf(badChar) > -1) {
					return false;
				}
			}
			var atPos = email.indexOf("@",1);
			if (atPos == -1) {
				return false;
			}
			if (email.indexOf("@",atPos+1) != -1) {
				return false;
			}
			var periodPos = email.indexOf(".",atPos);
			if (periodPos == -1) {
				return false;
			}
			if (periodPos+3 > email.length)  {
				return false;
			}
			return true;
		}
		
		// function radioPicked takes radio set name as a parameter and returns true if on of the radio buttons is checked
		// otherwise false is returned
		function radioPicked(radioName) {
			var radioSet = document.forms[0][radioName];

			if (radioSet) {
				for (k=0; k<radioSet.length; k++) {
					if (radioSet[k].checked) {
						return true;
					}
				}
			}
			return false;
		}
		
		// regex to validate that phone number is correct
		function validPhone(thisPhone){
			var re = /^\d\d\d[-]?\d\d\d[-]?\d\d\d\d$/;
			
			var test = re.test(thisPhone);
			
			if (test == false){
				return false;
			}
			else{
				return true;
			}
		}
	}
	
	// function invalidLabel takes parameter parentTag
	// then identifies if it is a label, then adds the string " invalid" to the class
	function invalidLabel(parentTag) {
        if (parentTag.nodeName == "LABEL") {
           parentTag.className += " invalid";
        }
    }
	
	// function resetClasses resets the classNames for all the tags in the form
	function resetClasses(){
		
		var allTags = document.forms[0].getElementsByTagName("*");
		
		for(var d = 0; d < allTags.length; d++){
			if(allTags[d].nodeName == "INPUT"){
				allTags[d].className = "";
			}
			if(allTags[d].nodeName == "LABEL"){
				allTags[d].className = "";
			}
		}
		
		document.getElementById("firstName").className = "reqd";
		document.getElementById("lastName").className = "reqd";
		document.getElementById("email").className = "reqd email";
		document.getElementById("confirmEmail").className = "reqd email confirm";
		document.getElementById("phone").className = "reqd phone";
	}
}

// function timeUntil gets today's date, and the date of the next event lined up, and subtracts the two
// then updates li timeUntil id 

function timeUntil(){
		var now = new Date();
		var checkDate = new Date(2019, 4, 1);
		
		var nowDays = now / (1000 * 60 * 60 * 24);
		var checkDateDays = checkDate / (1000 * 60 * 60 * 24);
		
		var timeUntil = Math.ceil(checkDateDays - nowDays);
		
		document.getElementById("timeUntil").innerHTML = "Only " + timeUntil + " days until the next event!";
	}


