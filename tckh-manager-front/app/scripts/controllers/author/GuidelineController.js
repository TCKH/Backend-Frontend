/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var GuidelineController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    GuidelineController.$inject = injectParams;
    angular.module('appManager')
        .controller('GuidelineController', GuidelineController);

}());