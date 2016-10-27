/**
 * Created by KinLucky on 10/25/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var PostController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    PostController.$inject = injectParams;
    angular.module('appManager')
        .controller('PostController', PostController);

}());