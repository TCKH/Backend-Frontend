/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var SubscriptionController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
    };
    SubscriptionController.$inject = injectParams;
    angular.module('appManager')
        .controller('SubscriptionController', SubscriptionController);

}());