"use strict";

function antallTerningerPaaKast(T1, T2, T3, T4, T5, Id) {
	let ID = Id;
	let sumTerningKast = 0;

	switch (ID) {
		case "1":
			sumTerningKast = enere(T1, T2, T3, T4, T5);
			break;

		case "2":
			sumTerningKast = toere(T1, T2, T3, T4, T5);
			break;

		case "3":
			sumTerningKast = treere(T1, T2, T3, T4, T5);
			break;

		case "4":
			sumTerningKast = firere(T1, T2, T3, T4, T5);
			break;

		case "5":
			sumTerningKast = femmer(T1, T2, T3, T4, T5);
			break;
		case "6":
			sumTerningKast = seksere(T1, T2, T3, T4, T5);
			break;

		case "7":
			sumTerningKast = ettPar(T1, T2, T3, T4, T5);
			break;

		case "8":
			sumTerningKast = toPar(T1, T2, T3, T4, T5);
			break;

		case "9":
			sumTerningKast = treLike(T1, T2, T3, T4, T5);
			break;

		case "10":
			sumTerningKast = fireLike(T1, T2, T3, T4, T5);
			break;

		case "11":
			sumTerningKast = litenStraight(T1, T2, T3, T4, T5);
			break;

		case "12":
			sumTerningKast = storStraight(T1, T2, T3, T4, T5);
			break;

		case "13":
			sumTerningKast = hus(T1, T2, T3, T4, T5);
			break;

		case "14":
			sumTerningKast = sjanse(T1, T2, T3, T4, T5);
			break;

		case "15":
			sumTerningKast = yatzy(T1, T2, T3, T4, T5);
			break;

		default:
	}

	return sumTerningKast;
}

function enere(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	let antall = 0;

	arrayForTerninger
		.filter((Terning) => Terning == 1)
		.forEach((Terning) => antall++);
	return antall;
}

function toere(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	let antall = 0;

	arrayForTerninger
		.filter((Terning) => Terning == 2)
		.forEach((Terning) => antall++);
	return antall * 2;
}

function treere(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	let antall = 0;

	arrayForTerninger
		.filter((Terning) => Terning == 3)
		.forEach((Terning) => antall++);
	return antall * 3;
}

function firere(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	let antall = 0;

	arrayForTerninger
		.filter((Terning) => Terning == 4)
		.forEach((Terning) => antall++);
	return antall * 4;
}

function femmer(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	let antall = 0;

	arrayForTerninger
		.filter((Terning) => Terning == 5)
		.forEach((Terning) => antall++);
	return antall * 5;
}

function seksere(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	let antall = 0;

	arrayForTerninger
		.filter((Terning) => Terning == 6)
		.forEach((Terning) => antall++);
	return antall * 6;
}

function ettPar(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	let retursum = 0;

	arrayForTerninger.sort((a, b) => a - b);

	for (let i = 0; i < arrayForTerninger.length; i++) {
		for (let x = 1; x < arrayForTerninger.length - 1; x++) {
			if (arrayForTerninger[i] === arrayForTerninger[x]) {
				retursum = arrayForTerninger[i] * 2;
			}
		}
	}
	return retursum;
}

function toPar(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	let retursum = 0;
	let retursum1 = 0;

	arrayForTerninger.sort((a, b) => a - b);

	retursum = ettPar(T1, T2, T3, T4, T5);
	for (let i = 0; i < arrayForTerninger.length; i++) {
		for (let x = 1; x < arrayForTerninger.length - 1; x++) {
			if (
				arrayForTerninger[i] === arrayForTerninger[x] &&
				arrayForTerninger[i] != retursum / 2
			) {
				retursum1 = arrayForTerninger[i] * 2;
			}
		}
	}
	if (retursum != 0 && retursum1 != 0) {
		return retursum + retursum1;
	} else {
		return 0;
	}
}

function treLike(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	let arrayEnere = [];
	let arrayToere = [];
	let arrayTreere = [];
	let arrayFirere = [];
	let arrayFemmere = [];
	let arraySeksere = [];
	arrayForTerninger.sort((a, b) => a - b);

	for (let i = 0; i < arrayForTerninger.length; i++) {
		switch (arrayForTerninger[i]) {
			case 1:
				arrayEnere[i] = arrayForTerninger[i];
				break;
			case 2:
				arrayToere[i] = arrayForTerninger[i];
				break;
			case 3:
				arrayTreere[i] = arrayForTerninger[i];
				break;
			case 4:
				arrayFirere[i] = arrayForTerninger[i];
				break;
			case 5:
				arrayFemmere[i] = arrayForTerninger[i];
				break;
			case 6:
				arraySeksere[i] = arrayForTerninger[i];
				break;
			default:
		}
	}

	if (arraySeksere.length == 3) {
		return 3 * arraySeksere.length;
	} else if (arrayFemmere.length == 3) {
		return 3 * arrayFemmere.length;
	} else if (arrayFemmere.length == 3) {
		return 3 * arrayFemmere.length;
	} else if (arrayFirere.length == 3) {
		return 3 * arrayFirere.length;
	} else if (arrayTreere.length == 3) {
		return 3 * arrayTreere.length;
	} else if (arrayToere.length == 3) {
		return 3 * arrayToere.length;
	} else if (arrayEnere.length == 3) {
		return 3 * arrayEnere.length;
	} else {
		return 0;
	}
}

function fireLike(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	let arrayEnere = [];
	let arrayToere = [];
	let arrayTreere = [];
	let arrayFirere = [];
	let arrayFemmere = [];
	let arraySeksere = [];
	arrayForTerninger.sort((a, b) => a - b);

	for (let i = 0; i < arrayForTerninger.length; i++) {
		switch (arrayForTerninger[i]) {
			case 1:
				arrayEnere[i] = arrayForTerninger[i];
				break;
			case 2:
				arrayToere[i] = arrayForTerninger[i];
				break;
			case 3:
				arrayTreere[i] = arrayForTerninger[i];
				break;
			case 4:
				arrayFirere[i] = arrayForTerninger[i];
				break;
			case 5:
				arrayFemmere[i] = arrayForTerninger[i];
				break;
			case 6:
				arraySeksere[i] = arrayForTerninger[i];
				break;
			default:
		}
	}

	if (arraySeksere.length == 4) {
		return 3 * arraySeksere.length;
	} else if (arrayFemmere.length == 4) {
		return 3 * arrayFemmere.length;
	} else if (arrayFemmere.length == 4) {
		return 3 * arrayFemmere.length;
	} else if (arrayFirere.length == 4) {
		return 3 * arrayFirere.length;
	} else if (arrayTreere.length == 4) {
		return 3 * arrayTreere.length;
	} else if (arrayToere.length == 4) {
		return 3 * arrayToere.length;
	} else if (arrayEnere.length == 4) {
		return 3 * arrayEnere.length;
	} else {
		return 0;
	}
}

function litenStraight(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	arrayForTerninger.sort((a, b) => a - b);

	if (
		checkIfArrayIsUnique(arrayForTerninger) &&
		checkSumValueOfArray(arrayForTerninger) == 15
	) {
		return checkSumValueOfArray(arrayForTerninger);
	} else {
		return 0;
	}
}

function storStraight(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	arrayForTerninger.sort((a, b) => a - b);

	if (
		checkIfArrayIsUnique(arrayForTerninger) &&
		checkSumValueOfArray(arrayForTerninger) == 20
	) {
		return checkSumValueOfArray(arrayForTerninger);
	} else {
		return 0;
	}
}

function hus(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	arrayForTerninger.sort((a, b) => a - b);

	let retursum = 0;

	if (toPar(arrayForTerninger) > 0 && treLike(arrayForTerninger) > 0) {
		return checkSumValueOfArray(arrayForTerninger);
	} else {
		return 0;
	}
}

function yatzy(T1, T2, T3, T4, T5) {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	arrayForTerninger.sort((a, b) => a - b);

	if (
		arrayForTerninger[0] === arrayForTerninger[1] &&
		arrayForTerninger[2] === arrayForTerninger[3] &&
		arrayForTerninger[4] === arrayForTerninger[5]
	) {
		return 50;
	} else {
		return 0;
	}
}

function sjanse() {
	let arrayForTerninger = [T1, T2, T3, T4, T5];
	arrayForTerninger.sort((a, b) => a - b);

	return checkSumValueOfArray(arrayForTerninger);
}

function checkIfArrayIsUnique(inputArray) {
	let rl = true;

	for (let i = 0; i < inputArray.length; i++) {
		for (let x = 0; x < inputArray.length - 1; x++) {
			if (inputArray[i] === inputArray[x]) {
				rl = false;
			}
		}
	}
	return rl;
}

function checkSumValueOfArray(x) {
	let sum = 0;

	for (let i = 0; i < x.length; i++) {
		sum = x[i] + sum;
	}
	return sum;
}

function log(id, result, spillerID) {
	switch (id) {
		case "1":
			let ones = document.getElementById(spillerID + 'ones');
			ones.innerHTML = result;
			break;
		case "2":
			let twos = document.getElementById(spillerID + 'twos');
			twos.innerHTML = result;
			break;
		case "3":
			let threes = document.getElementById(spillerID + 'threes');
			threes.innerHTML = result;
			break;
		case "4":
			let fours = document.getElementById(spillerID + 'fours');
			fours.innerHTML = result;
			break;
		case "5":
			let fives = document.getElementById(spillerID + 'fives');
			fives.innerHTML = result;
			break;
		case "6":
			let sixes = document.getElementById(spillerID + 'sixes');
			sixes.innerHTML = result;
			break;
		case "7":
			let sum = document.getElementById(spillerID + 'sum');
			sum.innerHTML = result;
			break;
		case "8":
			let bonus = document.getElementById(spillerID + 'bonus');
			bonus.innerHTML = result;
			break;
		case "9":
			let onePair = document.getElementById(spillerID + 'one-pair');
			onePair.innerHTML = result;
			break;
		case "10":
			let twoPair = document.getElementById(spillerID + 'two-pair');
			twoPair.innerHTML = result;
			break;
		case "11":
			let threeKind = document.getElementById(spillerID + 'three-kind');
			threeKind.innerHTML = result;
			break;
		case "12":
			let fourKind = document.getElementById(spillerID + 'four-kind');
			fourKind.innerHTML = result;
			break;
		case "13":
			let house = document.getElementById(spillerID + 'full-house');
			house.innerHTML = result;
			break;
		case "14":
			let sStraight = document.getElementById(spillerID + 'small-straight');
			sStraight.innerHTML = result;
			break;
		case "15":
			let lStraight = document.getElementById(spillerID + 'large-straight');
			lStraight.innerHTML = result;
			break;
		case "16":
			let chance = document.getElementById(spillerID + 'chance');
			chance.innerHTML = result;
			break;
		case "17":
			let yatzy = document.getElementById(spillerID + 'yatzy');
			yatzy.innerHTML = result;
			break;
		default:
	}
}















