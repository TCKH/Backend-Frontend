/**
 * Created by KinLucky on 10/13/2016.
 */
(function () {
    'use strict';

    angular
        .module('appManager')
        .factory('HomeService', HomeService);
    HomeService.$inject = ['$http', '$rootScope', 'config'];
    function HomeService($http, $rootScope, config) {
        var service = {};
        service.LoadData = LoadData;
        service.ListIssues = ListIssues;
        return service;

        function LoadData(callback) {
            /* Use this for real authentication
             ----------------------------------------------*/
            $http.get(config.backEndUrl + "post")
                .success(function (response) {
                    callback(response);
                });
        }
        function ListIssues(callback) {
            /* Use this for real authentication
             ----------------------------------------------*/
            $http.get(config.backEndUrl + "ListContact")
                .success(function (response) {
                    callback(response);
                });
        }
    }
})();