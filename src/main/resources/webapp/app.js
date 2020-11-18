var app = angular.module('aitu-project', []);

app.controller('ProductCtrl', function ($scope, $http) {
    $scope.productList = [];
    $scope.categoryList = [];

    $scope.getProducts = function () {
        $http({
            url: 'http://127.0.0.1:5000/api/products',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.productList = response.data;
                },
                function (response) {
                    console.log(response);
                });
    };

    $scope.getCategories = function () {
        $http({
            url: 'http://127.0.0.1:5000/api/categories',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.categoryList = response.data;
                },
                function (response) {
                    console.log(response);
                });
    };

    $scope.getProductsByCategory = function (categoryID) {
        $http({
            url: 'http://127.0.0.1:5000/api/products/category/' + categoryID,
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.productList = response.data;
                },
                function (response) {
                    console.log(response);
                });
    };

    $scope.getCategories();
    $scope.getProducts();


    $scope.auth = {
        login: '',
        password: ''
    };

    $scope.customer = {};

    $scope.login = function (auth) {
        $http({
            url: 'http://127.0.0.1:5000/login',
            method: "POST",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            },
            data: auth
        })
            .then(function (response) {
                    $scope.auth = response.data;

                    $scope.getMe();
                },
                function (response) {
                    $scope.auth = {};
                });
    };

    $scope.getMe = function () {
        $http({
            url: 'http://127.0.0.1:5000/customers/me',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "Auth": $scope.auth.token
            }
        })
            .then(function (response) {
                    $scope.customer = response.data;
                },
                function (response) {
                    console.log(response);
                    $scope.customer = {};
                });
    };


    let order = 0;
    $scope.totalPrice;

    $scope.orderData = {
        totalPrice: $scope.totalPrice
    };

    $scope.insertCustomerOrder = function () {
        $http({
            url: 'http://127.0.0.1:5000/api/customerorders',
            method: "POST",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "Token": $scope.auth.token
            },
            data: {
                totalPrice: $scope.totalPrice
            }
        })
            .then(function (response) {

                    console.log(response);
                },
                function (response) {
                    $scope.orderData = {};
                });
    };


    $scope.getCustomerOrderId = function () {
        $http({
            url: 'http://127.0.0.1:5000/api/customerorders/me',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "Token": $scope.auth.token

            }
        })
            .then(function (response) {

                    $scope.orderItem.orderId = response.data;
                    console.log(order);
                },
                function (response) {
                    console.log(response);
                });
    };


    $scope.orderItem = {
        quantity: '',
        productId: '',
        orderId: ''
    };


    $scope.bucket = {};
    $scope.incrementProduct = function (product) {
        if ($scope.bucket[product.productId] === undefined) {
            $scope.bucket[product.productId] = {
                productId: product.productId,
                name: product.name,
                description: product.description,
                price: product.price,
                quantity: 0
            };
        }
        $scope.orderItem.productId = product.id;
        $scope.bucket[product.productId].quantity += 1;
    };

    $scope.FindTotalPrice = function () {
        console.log($scope.bucket);
        $scope.totalPrice = 0
        angular.forEach($scope.bucket, function (value) {
            $scope.totalPrice += value.price * value.quantity;
        });

        console.log($scope.totalPrice);
    };

    $scope.deleteProduct = function (product) {
        if ($scope.bucket[product.productId].quantity > 0) {
            $scope.bucket[product.productId].quantity = $scope.bucket[product.productId].quantity - 1;
        } else {
            delete $scope.bucket[product.productId];
        }
    };

    $scope.insertOrderItem = function () {
        $http({
            url: 'http://127.0.0.1:5000/api/orderitems',
            method: "POST",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",

            },
            data: {
                'productId': $scope.orderItem.productId,
                'quantity': $scope.orderItem.quantity,
                'orderId': $scope.orderItem.orderId
            }
        })
            .then(function (response) {

                    console.log(response);
                    console.log($scope.orderItem);
                    $scope.getCustomerOrder();
                },
                function (response) {
                });
    };

    $scope.orderList = [];
    $scope.getCustomerOrder = function () {
        $http({
            url: 'http://127.0.0.1:5000/api/customerorders/customers/' + $scope.customer.id,
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
            }
        })
            .then(function (response) {
                    console.log(response);

                    $scope.orderList = response.data;
                    },
                function (response) {
                    console.log(response);
                });
    };
    $scope.getCustomerOrder();

});

