	function calculateZodiac() {
		var birthdate = new Date(document.getElementById("birthdate").value);

		var month = birthdate.getMonth() + 1;
		var day = birthdate.getDate();

		var zodiacSigns = ["Capricorn", "Văsător", "Pești", "Berbec", "Taur", "Gemeni", "Rac", "Leu", "Fecioara", "Balanta", "Scorpion", "Săgetător"];
		var zodiacDates = ["01/20", "02/19", "03/20", "04/20", "05/21", "06/21", "07/22", "08/23", "09/23", "10/23", "11/22", "12/22"];
	var zodiacIndex = month ;
	if (day < parseInt(zodiacDates[zodiacIndex].substring(3, 5))) {
		zodiacIndex--;
	}

	if (zodiacIndex < 0) {
		zodiacIndex = 11;
	}

	var zodiac = zodiacSigns[zodiacIndex];

	// display the zodiac sign
	document.getElementById("zodiac").innerHTML = "Zodia ta este: " + zodiac + ".";
}

