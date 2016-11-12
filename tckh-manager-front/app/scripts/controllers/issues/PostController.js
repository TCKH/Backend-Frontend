/**
 * Created by KinLucky on 10/25/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$q','$scope', '$rootScope', '$location', '$timeout', 'config', 'HomeService', '$http'];

    var PostController = function ($q, $scope, $rootScope, $location, $timeout, config, HomeService, $http) {
        var vm = this;
        vm.Error = false;
        if($rootScope.globals === undefined){
            $location.path('/login');
        }
        if(!jQuery.isEmptyObject($rootScope.Article)){
            vm.keyword = $rootScope.Article.keyword;
            vm.title = $rootScope.Article.title;
            vm.nameAuthor = $rootScope.Article.nameAuthor;
        }
        vm.postArticle = function () {
            var uploadUrl= config.backEndUrl + "continueFileUpload";
            var formData=new FormData();
            formData.append("file",file.files[0]);
            var article = {
                name: file.files[0].name,
                keyword: vm.keyword,
                title: vm.title,
                nameAuthor: vm.nameAuthor,
                size: file.files[0].size,
                lastModified: file.files[0].lastModified.toString(),
                usernameId:  $rootScope.globals.currentUser.username
            }
            if(!jQuery.isEmptyObject($rootScope.Article)){
                article.id = $rootScope.Article.id;
            }
            if(article){
                HomeService.SaveArticle(article, function (data) {
                    if(data){
                        $http({
                            method: 'POST',
                            url: uploadUrl,
                            headers: {'Content-Type': undefined},
                            data: formData
                        }).success(function(data) {
                            console.log(data);
                        })
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