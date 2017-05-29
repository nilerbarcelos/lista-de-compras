angular.module("listaDeCompras").factory("listaDeComprasAPI", function ($http, config) {
	var _saveProduto = function (produto) {
		return $http.post(config.baseUrl + "/cadastrar", produto);
	};

	var _getProdutos = function () {
		return $http.get(config.baseUrl + "/lista-produtos");
	};

	return {
		saveProduto: _saveProduto,
		getProdutos: _getProdutos
	};
});