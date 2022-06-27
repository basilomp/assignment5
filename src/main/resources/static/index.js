angular.module('products', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/shop';



    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                    $scope.productList = response.data;
            });
    };

    $scope.filterProducts = function (min, max) {
        console.log($scope.filterPrice)
        $http({
            url: contextPath + '/products/findBetween',
            method: 'get',
            params:
                {
                    min: $scope.filterPrice.min,
                    max: $scope.filterPrice.max,
                }
        }).then(function (response) {
            $scope.productList = response.data;
        });
    };

    $scope.removeFromList = function (id) {
        $http({
            url: contextPath + '/products/remove',
            method: 'DELETE',
            params:
                {
                    id: id
                }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.addToCart = function (id) {
        $http({
            url: contextPath + '/products/add',
            method: 'POST',
            params: {
                id: id
            }
        });
    };

    $scope.loadProducts();

});