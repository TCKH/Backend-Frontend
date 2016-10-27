/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var AlertController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    AlertController.$inject = injectParams;
    angular.module('appManager')
        .controller('AlertController', AlertController);

}());