/**
 * Created by KinLucky on 10/13/2016.
 */

(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config','HomeService'];

    var HomeController = function ($scope, $rootScope, $location, $timeout, config, HomeService) {
        var vm = this;
        HomeService.LoadData(loginSuccessCallback);
        function loginSuccessCallback(response) {
            vm.dataPost = response;
        }
        vm.downloadFile = function () {
            window.open("data/main.pdf");
        }
    };
    HomeController.$inject = injectParams;
    angular.module('appManager')
        .controller('HomeController', HomeController);

}());