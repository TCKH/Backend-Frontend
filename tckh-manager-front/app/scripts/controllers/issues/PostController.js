/**
 * Created by KinLucky on 10/25/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config', 'HomeService'];

    var PostController = function ($scope, $rootScope, $location, $timeout, config, HomeService) {
        var vm = this;
        vm.listCategory = [];
        vm.Error = false;
        HomeService.ListCategory(function (response) {
            if(response){
                vm.listCategory = response;
            }
        })
        if($rootScope.viewArticle){
            vm.category = $rootScope.viewArticle.categoryId;
            vm.name = $rootScope.viewArticle.name;
            vm.content = $rootScope.viewArticle.content;
            $('.media-container img').valueOf($rootScope.viewArticle.image);
        }
        vm.postArticle = function () {
            var article = {
                name: vm.name,
                image: $('.media-container img').attr('src'),
                content: vm.content,
                createTime: Date.now().toString(),
                categoryId: parseInt(vm.category),
                usernameId: $rootScope.globals.currentUser.username
            }
            if($rootScope.viewArticle){
                article.id = $rootScope.viewArticle.id;
            }
            if(article.name !== undefined && article.image !== undefined
            && article.content!== undefined && article.categoryId !== undefined){
                HomeService.SaveArticle(article, function (data) {

                    $location.path("/");
                })
            }else {
                vm.Error = true;
                $timeout(function () {
                    vm.Error = false;
                },10000)
            }
        }
    };
    PostController.$inject = injectParams;
    angular.module('appManager')
        .controller('PostController', PostController);

}());