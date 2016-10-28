/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config', 'RegisterService'];

    var LoginController = function ($scope, $rootScope, $location, $timeout, config, RegisterService) {
        var vm = this;
        vm.error = false;
        vm.username = $rootScope.author.username;
        vm.password = $rootScope.author.password;
        vm.login = function () {
            RegisterService.ClearCredentials();
            var login_info = {
                username: vm.username,
                password: vm.password
            }
            if(login_info){
                RegisterService.Login(login_info, function(response){
                    if(response){
                        RegisterService.SetCredentials(response);
                        $location.path('/');
                    }else {
                        vm.error = true;
                        $timeout(function () {
                            vm.error = false;
                        }, 5000);
                    }
                });
            }
        }
    };
    LoginController.$inject = injectParams;
    angular.module('appManager')
        .controller('LoginController', LoginController);

}());