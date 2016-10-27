/**
 * Created by KinLucky on 10/15/2016.
 */

(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config','HomeService'];

    var IssuesController = function ($scope, $rootScope, $location, $timeout, config, HomeService) {
        var vm = this;
        HomeService.ListIssues(loginSuccessCallback);
        function loginSuccessCallback(response) {
            vm.dataContact = response;
        }
    };
    IssuesController.$inject = injectParams;
    angular.module('appManager')
        .controller('IssuesController', IssuesController);

}());