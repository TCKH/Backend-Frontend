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
        service.ListCategory = ListCategory;
        service.SaveArticle = SaveArticle;
        service.GetArticle = GetArticle;
        service.DeleteArticle = DeleteArticle;
        return service;

        function LoadData(callback) {
            /* Use this for real authentication
             ----------------------------------------------*/
            $http.get(config.backEndUrl + "ListArticle")
                .success(function (response) {
                    callback(response);
                });
        }
        function ListCategory(callback) {
            /* Use this for real authentication
             ----------------------------------------------*/
            $http.get(config.backEndUrl + "ListCategory")
                .success(function (response) {
                    callback(response);
                });
        }
        function SaveArticle(article, callback) {
            $http.post(config.backEndUrl + 'NewArticle',article)
                .success(function (response) {
                    callback(response);
                });
        }

        function GetArticle(article, callback) {
            $http.post(config.backEndUrl + 'GetArticle',article)
                .success(function (response) {
                    callback(response);
                });
        }
        function DeleteArticle(article, callback) {
            $http.post(config.backEndUrl + 'DeleteArticle',article)
                .success(function (response) {
                    callback(response);
                });
        }
    }
})();