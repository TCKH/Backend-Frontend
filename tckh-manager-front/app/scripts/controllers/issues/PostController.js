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
            vm.upload(vm.file);
        }
        vm.upload = function (file) {
            var article = {
                name: file.name,
                keyword: vm.keyword,
                title: vm.title,
                nameAuthor: vm.nameAuthor,
                lastModified: file.lastModified.toString(),
                usernameId:  $rootScope.globals.currentUser.username
            }
            console.log(article)
            if(article){
                HomeService.SaveArticle(article, function (data) {
                    if(data){
                        Upload.upload({
                            url: 'upload',
                            data: {file: file}
                        }).then(function (resp) {
                            console.log(resp);
                        }, function (resp) {

                        });
                        $location.path("/");
                    }else {
                        vm.Error = true;
                        $timeout(function () {
                            vm.Error = false;
                        },10000)
                    }
                })
            }

        }
    };
    PostController.$inject = injectParams;
    angular.module('appManager')
        .controller('PostController', PostController);

}());