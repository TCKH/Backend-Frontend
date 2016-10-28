/**
 * Created by KienNH2 on 10/25/2016.
 */

(function () {
    'use strict';

    angular
        .module('appManager')
        .factory('RegisterService', RegisterService);

    RegisterService.$inject = ['$http', '$rootScope', 'config', '$cookieStore'];
    function RegisterService($http, $rootScope, config, $cookieStore) {
        var service = {};

        service.Register = Register;
        service.Login = Login;
        service.SetCredentials = SetCredentials;
        service.ClearCredentials = ClearCredentials;
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
        }
        function ClearCredentials() {
            $rootScope.globals = undefined;
            $cookieStore.remove('globals');
            /*$http.defaults.headers.common.Authorization = '';*/
        }
        function SetCredentials(user) {
            $rootScope.globals = {
                currentUser: {
                    username: user.username
                }
            };
            $cookieStore.put('globals', $rootScope.globals);
            /*$http.defaults.headers.common['Authorization'] = username + ' ' + token;*/ // jshint ignore:line

        }
    }
})();