/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var RequestPasswordController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    RequestPasswordController.$inject = injectParams;
    angular.module('appManager')
        .controller('RequestPasswordController', RequestPasswordController);

}());