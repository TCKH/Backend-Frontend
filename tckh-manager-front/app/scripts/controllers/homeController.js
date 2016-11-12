/**
 * Created by KinLucky on 10/13/2016.
 */

(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config','HomeService', '$window'];

    var HomeController = function ($scope, $rootScope, $location, $timeout, config, HomeService, $window) {
        var vm = this;
        vm.allArticle = [];
        vm.msgError = false;
        vm.articleReviewer = [];
        vm.reviewer = [

        ];
        $rootScope.Article = {};
        HomeService.LoadData(loginSuccessCallback);
        function loginSuccessCallback(response) {
            vm.allArticle = response;
            vm.convertedSize = [];
            vm.byte = [];
            for(var i = 0; i < vm.allArticle.length; i++){
                var byteSize = vm.allArticle[i].size;
                var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB'];
                if (byteSize == 0)
                    vm.convertedSize[vm.allArticle[i].id] = '0 Byte';
                else {
                    vm.byte[vm.allArticle[i].id] = parseInt(Math.floor(Math.log(byteSize) / Math.log(1024)));
                    vm.convertedSize[vm.allArticle[i].id] = Math.round(byteSize / Math.pow(1024, vm.byte[vm.allArticle[i].id]), 2) + ' ' + sizes[vm.byte[vm.allArticle[i].id]];
                }
                if($rootScope.globals !== undefined && vm.allArticle[i].reviewer === $rootScope.globals.currentUser.username){
                    vm.articleReviewer.push(vm.allArticle[i]);
                }

            }

        }
        vm.articleComment = {};
        vm.commentArticle = function (article) {
            vm.articleComment = article;
            if(article.comment != undefined){
                vm.comment = article.comment;
            }
            $("#modalComment").modal('show');
        }
        vm.commentSubmit =function () {
            $("#modalComment").modal('hide');
            vm.articleComment.comment = vm.comment;
            HomeService.SaveArticle(vm.articleComment, function (response) {
                console.log(response);
            })

        }
        HomeService.LoadUserType(UserType);
        function UserType(response) {
            response.forEach(function (article) {
                if(article.userType === 'PHAN BIEN'){
                    vm.obj = {
                        id: article.id,
                        username: article.username
                    };
                    vm.reviewer.push(vm.obj);
                }
            })
        }
        vm.saveReviewerSelect = function () {
            vm.allArticle.forEach(function (data) {
                var data = {
                    id: data.id,
                    name: data.name,
                    keyword: data.keyword,
                    title: data.title,
                    nameAuthor: data.nameAuthor,
                    size: data.size,
                    lastModified: data.lastModified,
                    usernameId:  data.usernameId
                }
                if(vm.reviewerSelect[data.id] !== undefined){
                    data.reviewer = vm.reviewerSelect[data.id];
                }else {
                    data.reviewer = null;
                }
                HomeService.SaveArticle(data, function (response) {
                    console.log(response);
                })

            })
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
        vm.viewPDF = function (fileName) {
            if($rootScope.globals.currentUser.userType === "DOC GIA"){
                if($rootScope.globals.currentUser.money === "true"){
                    $window.open("data/"+ fileName +"");

                }else {
                    vm.msgError = true;
                    $timeout(function () {
                        vm.msgError = false;
                    },5000)
                }

            }else {
                $window.open("data/"+ fileName +"");
            }
        }
        vm.editArticle = function (articleId) {
            var dataObj = {
                id: articleId
            }
            HomeService.GetArticle(dataObj,function (data) {
                $rootScope.Article = data;
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