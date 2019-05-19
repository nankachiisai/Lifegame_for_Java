let Lifegame;

// JSONファイルを読み込む
let txt;
fetch("gen0.json").then(function(response) {
	response.json().then(function(json) {
		Lifegame = json;
	});
});

