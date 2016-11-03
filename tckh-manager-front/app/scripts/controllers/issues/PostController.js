/**
 * Created by KinLucky on 10/25/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config', 'HomeService', 'Upload'];

    var PostController = function ($scope, $rootScope, $location, $timeout, config, HomeService, Upload) {
        var vm = this;
        vm.listCategory = [];
        vm.Error = false;
        vm.postArticle = function () {
            Upload.upload({
                url: config.backEndUrl + 'upload',
                data: {username: $scope.username, file: file},
            });
            console.log(vm.file)
            /*HomeService.SaveArticle(article, function (data) {
                if(data){
                    $location.path("/");
                }else {
                    vm.Error = true;
                    $timeout(function () {
                        vm.Error = false;
                    },10000)
                }
            })*/
        }
    };
    PostController.$inject = injectParams;
    angular.module('appManager')
        .controller('PostController', PostController);

}());