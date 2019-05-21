const x = 50;
const y = 50;

window.onload = function() {
	// JSONファイルを読み込む
	fetch("gen0.json").then(function(response) {
		response.json().then(function(json) {
			// canvasを取得する
			let canvas = document.getElementById("lifegame").getContext("2d");

			// 描画
			for (let i = 0; i < y; i++) {
				for (let j = 0; j < x; j++) {
					if (json.field.field[x * i + j].live == true) {
						canvas.fillStyle = "black";
						canvas.fillRect(10 * i, 10 * j, 10, 10);
					}
					else {
						canvas.fillStyle = "white";
						canvas.fillRect(10 * i, 10 * j, 10, 10);
					}
				}
			}
		});
	});
}