/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config'];

    var StatusController = function ($scope, $rootScope, $location, $timeout, config) {
        var vm = this;
        function validate()
        {
            var message = "";
            if (document.forms["loginForm"]["paperid"].value=="")
            {
                message = message + "Insert your Paper ID.\n";
            }
            if(document.forms["loginForm"]["email"].value=="")
            {
                message = message + "Insert your Contact Author's e-mail.";
            }

            if(message.length>0)
            {
                alert(message);
                return false;
            }
            else
            {
                return true;
            }
        }
    };
    StatusController.$inject = injectParams;
    angular.module('appManager')
        .controller('StatusController', StatusController);

}());