/**
 * Created by KinLucky on 10/20/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var TopArticlesController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    TopArticlesController.$inject = injectParams;
    angular.module('appManager')
        .controller('TopArticlesController', TopArticlesController);

}());