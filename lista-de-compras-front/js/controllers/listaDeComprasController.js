angular.module("listaDeCompras").controller("listaDeComprasCtrl", function ($scope, listaDeComprasAPI) {
	$scope.app = "Lista de Compras";
	$scope.produtos = [];

	var carregarListaDeCompras = function () {
		listaDeComprasAPI.getProdutos().then(function successCallback(response) {
			$scope.produtos = response.data;
		}, function errorCallback(response) {
			$scope.message = "Aconteceu um problema: " + response.data;
		});
	};

	$scope.$watchCollection('produtos',function() {
		$scope.total = 0;  
		angular.forEach($scope.produtos, function(value, key) {
		$scope.total += value.quantidade * value.valor;
		})
	});

	$scope.adicionarProduto = function (produto) {
		listaDeComprasAPI.saveProduto(produto).then(function successCallback(response) {
			delete $scope.produto;
			$scope.produtoForm.$setPristine();
			carregarListaDeCompras();
			$scope.message = "Produto inserido com sucesso!";
		});
	};

	carregarListaDeCompras();
});