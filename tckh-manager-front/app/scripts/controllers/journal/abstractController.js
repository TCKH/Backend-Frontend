/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var AbstractController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    AbstractController.$inject = injectParams;
    angular.module('appManager')
        .controller('AbstractController', AbstractController);

}());