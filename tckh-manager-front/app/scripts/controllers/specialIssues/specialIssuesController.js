/**
 * Created by KinLucky on 10/20/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var SpecialIssuesController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    SpecialIssuesController.$inject = injectParams;
    angular.module('appManager')
        .controller('SpecialIssuesController', SpecialIssuesController);

}());