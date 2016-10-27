/**
 * Created by KinLucky on 10/20/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var PastIssuesController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    PastIssuesController.$inject = injectParams;
    angular.module('appManager')
        .controller('PastIssuesController', PastIssuesController);

}());