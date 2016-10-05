 var scotchApp = angular.module('scotchApp', ['ui.bootstrap','ngRoute']);

    scotchApp.config(['$routeProvider',
            function($routeProvider) {
                $routeProvider
                    .when('/', {
                    templateUrl: 'html/mainPage.html'
                    })
                    .when('/regform', {
                        templateUrl: 'html/regform.html'
                    });
            }]);

    scotchApp.controller('mainController', function($scope,$http) {
        $http({
            method: 'GET',
            url: '/api/user',
            headers: {
                'X-Requested-With': 'XMLHttpRequest'
            }
        }).then(function successCallback(response) {
            $scope.authenticated = true;
        }, function errorCallback(response) {
            $scope.authenticated = false;
        });
        $scope.auth = function () {
            var auth = btoa($scope.user.name+':'+$scope.user.password);
            $http({
                method: 'GET',
                url: '/api/user',
                headers: {
                    'Authorization':'Basic '+auth,
                    'X-Requested-With': 'XMLHttpRequest'
                }
            }).then(function successCallback(response) {
                console.log(response);
            }, function errorCallback(response) {
                console.log(response);
            });
        }
    });