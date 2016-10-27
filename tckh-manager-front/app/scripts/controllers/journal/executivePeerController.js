/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var ExecutiveController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    ExecutiveController.$inject = injectParams;
    angular.module('appManager')
        .controller('ExecutiveController', ExecutiveController);

}());