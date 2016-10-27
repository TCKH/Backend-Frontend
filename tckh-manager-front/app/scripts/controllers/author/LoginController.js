/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config', 'RegisterService'];

    var LoginController = function ($scope, $rootScope, $location, $timeout, config, RegisterService) {
        var vm = this;
        vm.username = $rootScope.author.username;
        vm.password = $rootScope.author.password;
        vm.login = function () {
            var login_info = {
                username: vm.username,
                password: vm.password
            }
            if(login_info){
                RegisterService.Login(login_info, function(res){
                    if(res){
                        $rootScope.checkLogin = true;
                        $rootScope.userInfo = res;
                        console.log($rootScope.userInfo.username)
                        $location.path('/');
                    }
                });
            }
        }
    };
    LoginController.$inject = injectParams;
    angular.module('appManager')
        .controller('LoginController', LoginController);

}());