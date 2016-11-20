/**
 * Created by KinLucky on 10/29/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config','HomeService', 'NgTableParams'];

    var ViewController = function ($scope, $rootScope, $location, $timeout, config, HomeService, NgTableParams) {
        var vm = this;
        vm.list = [];
        vm.listComment = [];
        HomeService.LoadComment(loginSuccessCallback);
        function loginSuccessCallback(response) {
            response.forEach(function (comment) {
                if(comment.articleId == $rootScope.viewCommentId){
                    vm.list.push(comment);
                }
            })
            console.log(vm.list)
            vm.listComment =  new NgTableParams({}, { dataset: vm.list});
        }
    };
    ViewController.$inject = injectParams;
    angular.module('appManager')
        .controller('ViewController', ViewController);

}());
