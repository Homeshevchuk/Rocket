 var scotchApp = angular.module('scotchApp', []);
    scotchApp.controller('mainController', function($scope,$http) {
        $scope.counter = 0;
        $scope.user = {
            name:'',
            password:''
        }
        $scope.send = function () {
            $http({
                method: 'POST',
                url: '/registration',
                data: $scope.user
            }).then(function successCallback(response) {
                console.log(response);
            }, function errorCallback(response) {
                console.log(response);
            });
        }

    });