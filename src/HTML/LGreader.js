const X = 50;
const Y = 50;

let generation = new class {
	constructor() {
		this.gen = 0;
		this.json;
	}

	getGen() {
		return this.gen;
	}

	setGen(gen) {
		if (gen < 0 || gen >= 50) {
			throw new Error();
		}
		else {
			this.gen = gen;
		}
	}
}();

let painter = json => {
	// canvasを取得する
	let canvas = document.getElementById("lifegame").getContext("2d");

	// セルの描画
	for (let i = 0; i < Y; i++) {
		for (let j = 0; j < X; j++) {
			if (json.field.field[X * i + j].live) {
				canvas.fillStyle = "black";
				canvas.fillRect(10 * i, 10 * j, 10, 10);
			}
			else {
				canvas.fillStyle = "white";
				canvas.fillRect(10 * i, 10 * j, 10, 10);
			}
		}
	}

	// グリッドの描画
	for (let i = 0; i < X; i++) {
		canvas.beginPath();
		canvas.moveTo(10 * i, 0);
		canvas.lineTo(10 * i, 500);
		canvas.moveTo(0, 10 * i);
		canvas.lineTo(500, 10 * i);
		canvas.closePath();
		canvas.stroke();
	}
}

// Fetch JSON File
let fetchJSON = string => {
	// JSONファイルを読み込む
	fetch(string).then(function(response) {
		return response.json();
	}).then(function(response) {
		painter(response);
	});
}

// Event Handler
window.onload = () => {
	fetchJSON("gen" + generation.getGen() + ".json");
	document.getElementById("generation").innerHTML = "generation: " + generation.getGen();
}

let prev = () => {
	try {
		generation.setGen(generation.getGen() - 1);
	}
	catch (e) {
		alert("それ以上戻れません。")
	}
	fetchJSON("gen" + generation.getGen() + ".json");
	document.getElementById("generation").innerHTML = "generation: " + generation.getGen();
}

let next = () => {
	try {
		generation.setGen(generation.getGen() + 1);
	}
	catch (e) {
		alert("それ以上進めません。");
	}
	fetchJSON("gen" + generation.getGen() + ".json");
	document.getElementById("generation").innerHTML = "generation: " + generation.getGen();
}