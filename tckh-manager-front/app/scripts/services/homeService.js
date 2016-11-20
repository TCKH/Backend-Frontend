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
        service.LoadListUsers = LoadListUsers;
        service.LoadUserType = LoadUserType;
        service.ListCategory = ListCategory;
        service.SaveArticle = SaveArticle;
        service.GetArticle = GetArticle;
        service.DeleteArticle = DeleteArticle;
        service.Upload = Upload;
        service.SaveComment = SaveComment;
        service.LoadComment = LoadComment;
        return service;
        function LoadComment(callback) {
            $http.get(config.backEndUrl + "ListComment")
                .success(function (response) {
                    callback(response);
                });
        }
        function SaveComment(comment, callback) {
            $http.post(config.backEndUrl + 'NewComment',comment)
                .success(function (response) {
                    callback(response);
                });
        }

        function LoadData(callback) {
            /* Use this for real authentication
             ----------------------------------------------*/
            $http.get(config.backEndUrl + "ListArticle")
                .success(function (response) {
                    callback(response);
                });
        }
        function LoadListUsers(callback) {
            /* Use this for real authentication
             ----------------------------------------------*/
            $http.get(config.backEndUrl + "ListUsers")
                .success(function (response) {
                    callback(response);
                });
        }
        function LoadUserType(callback) {
            /* Use this for real authentication
             ----------------------------------------------*/
            $http.get(config.backEndUrl + "UserType")
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
        function Upload(file, callback) {
            $http({
                method: 'POST',
                url: config.backEndUrl + 'upload',
                data: file,
                headers: { 'Content-Type': 'multipart/form-data'}
            },function (response) {
                    callback(response);
                }
            );
            /*$http.post(config.backEndUrl + 'upload',file)
                .success(function (response) {
                    callback(response);
                });*/
        }
    }
})();