/**
 * Created by KienNH2 on 10/25/2016.
 */

(function () {
    'use strict';

    angular
        .module('appManager')
        .factory('RegisterService', RegisterService);

    RegisterService.$inject = ['$http', '$rootScope', 'config'];
    function RegisterService($http, $rootScope, config) {
        var service = {};

        service.Register = Register;
        service.Login = Login;
        return service;

        function Register(registerInfo, callback) {
            /* Use this for real authentication
             ----------------------------------------------*/
            $http.post(config.backEndUrl + 'register',registerInfo)
                .success(function (response) {
                    callback(response);
                });
        }
        function Login(loginInfo, callback) {
            $http.post(config.backEndUrl + 'login',loginInfo)
                .success(function (response) {
                    callback(response);
                });
            /*$http({
                method: 'GET',
                url: config.backEndUrl + 'login',
                headers: {
                    'Content-Type': undefined
                },
                data: {
                    username: loginInfo.username,
                    password: loginInfo.password
                }
            }).then(function successCallback(response) {
                callback = response;
            }, function errorCallback(response) {

            });*/
        }
    }
})();