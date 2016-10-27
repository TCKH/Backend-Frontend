/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config', 'RegisterService'];

    var RegisterController = function ($scope, $rootScope, $location, $timeout, config , RegisterService) {
        var vm = this;
        vm.msgError = false;
        vm.register = function () {
            var register = {
                username: vm.username,
                password: vm.password,
                lastname: vm.lastname,
                firstname: vm.firstname,
                email: vm.email
            }
            if(register){
                RegisterService.Register(register, function (response) {
                    if (response) {
                        $rootScope.author = {
                            username: vm.username,
                            password: vm.password
                        };
                        $location.path('/login');
                    } else {
                        vm.msgError = true;
                        $timeout(function () {
                            vm.msgError = false;
                        },5000)
                    }
                });
            }
        }
    };
    RegisterController.$inject = injectParams;
    angular.module('appManager')
        .controller('RegisterController', RegisterController);

}());