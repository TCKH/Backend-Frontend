/**
 * Created by KinLucky on 10/20/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var NewController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    NewController.$inject = injectParams;
    angular.module('appManager')
        .controller('NewController', NewController);

}());