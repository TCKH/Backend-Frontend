/**
 * Created by KinLucky on 10/29/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config','$sce'];

    var ViewController = function ($scope, $rootScope, $location, $timeout, config, $sce) {
        var vm = this;
        vm.renderHtml = function (htmlCode) {
            return $sce.trustAsHtml(htmlCode);
        }
    };
    ViewController.$inject = injectParams;
    angular.module('appManager')
        .controller('ViewController', ViewController);

}());
