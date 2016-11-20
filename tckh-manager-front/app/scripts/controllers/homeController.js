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
        vm.success = false;
        vm.articleReviewer = [];
        vm.reviewerSelect = [];
        vm.acceptSelect = [];
        vm.listArticle = [];
        vm.reviewer = [

        ];
        $rootScope.Article = {};
        HomeService.LoadData(loginSuccessCallback);
        function loginSuccessCallback(response) {
            vm.allArticle = response;
            vm.allArticle.forEach(function (res) {
                vm.reviewerSelect[res.id] = res.reviewer;
                vm.acceptSelect[res.id] = res.accept;
            })
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
                if(vm.allArticle[i].accept == 'true'){
                    vm.listArticle.push(vm.allArticle[i]);
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
            var comment = {
                articleId: vm.articleComment.id,
                version: vm.version,
                content: vm.content,
                title: vm.title,
                type: vm.type,
                date: new Date().toString()
            }
            console.log(comment);
            if(comment){
                HomeService.SaveComment(comment, function (response) {
                    console.log(response);
                })
            }


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
                if(vm.acceptSelect[data.id] !== undefined){
                    data.accept = vm.acceptSelect[data.id];
                }else {
                    data.accept = null;
                }
                HomeService.SaveArticle(data, function (response) {
                    vm.success = true;
                    $timeout(function () {
                        vm.success = false;
                    },5000)
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
        vm.viewComment = function (id) {
            $rootScope.viewCommentId = id;
            console.log(id);
            $location.path("/view");
        }
    };
    HomeController.$inject = injectParams;
    angular.module('appManager')
        .controller('HomeController', HomeController);

}());