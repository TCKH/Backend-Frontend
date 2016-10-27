/**
 * Created by KinLucky on 10/17/2016.
 */

(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var EditorBoardController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;

    };
    EditorBoardController.$inject = injectParams;
    angular.module('appManager')
        .controller('EditorBoardController', EditorBoardController);

}());