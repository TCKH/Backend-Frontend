/**
 * Created by KinLucky on 10/17/2016.
 */

(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var ScopeController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;

    };
    ScopeController.$inject = injectParams;
    angular.module('appManager')
        .controller('ScopeController', ScopeController);

}());
