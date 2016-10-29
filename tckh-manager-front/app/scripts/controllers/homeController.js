/**
 * Created by KinLucky on 10/13/2016.
 */

(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config','HomeService'];

    var HomeController = function ($scope, $rootScope, $location, $timeout, config, HomeService) {
        var vm = this;
        vm.allArticle = [];
        HomeService.LoadData(loginSuccessCallback);
        function loginSuccessCallback(response) {
            vm.allArticle = response;
        }
        vm.viewArticle = function (id) {
            var dataObj = {
                id: id
            }
            HomeService.GetArticle(dataObj,function (data) {
                $rootScope.viewArticle = data;
                $location.path("/view");
            })
        }
        vm.editArticle = function (articleId) {
            var dataObj = {
                id: articleId
            }
            HomeService.GetArticle(dataObj,function (data) {
                $rootScope.viewArticle = data;
                $location.path("/post-article");
            })
        }
        vm.deleteArticle = function (articleId) {
            var dataObj = {
                id: articleId
            }
            HomeService.DeleteArticle(dataObj,function (data) {
                vm.allArticle = data;
            })
        }
    };
    HomeController.$inject = injectParams;
    angular.module('appManager')
        .controller('HomeController', HomeController);

}());