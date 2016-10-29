/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var ArticlesController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;


    };
    ArticlesController.$inject = injectParams;
    angular.module('appManager')
        .controller('ArticlesController', ArticlesController);

}());