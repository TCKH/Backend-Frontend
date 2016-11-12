/**
 * Created by KinLucky on 10/18/2016.
 */
(function () {
    'use strict';

    var injectParams = ['$scope', '$rootScope', '$location', '$timeout', 'config', 'HomeService', 'NgTableParams','RegisterService'];

    var GuidelineController = function ($scope, $rootScope, $location, $timeout, config, HomeService, NgTableParams,RegisterService) {
        var vm = this;
        vm.listUser = [];
        HomeService.LoadListUsers(loginSuccessCallback);
        function loginSuccessCallback(response) {
            vm.listUser =  new NgTableParams({}, { dataset: response});
        }
        vm.userEdit = {};
        vm.editUser = function (user) {
            vm.userEdit = user;
            HomeService.ListCategory(function (response) {
                if(response){
                    vm.listCategory = response;
                }
            })
            vm.money = "false";
            vm.category = user.userType;
            vm.firstname = user.firstname;
            vm.lastname = user.lastname;
            vm.email = user.email;
            vm.username = user.username;
            vm.password = user.password;
            $("#modalEditUser").modal('show');
        }
        vm.editSubmit = function () {
            vm.userEdit.userType = vm.category;
            vm.userEdit.firstname = vm.firstname;
            vm.userEdit.lastname = vm.lastname;
            vm.userEdit.email = vm.email;
            vm.userEdit.money = vm.money;
            console.log(vm.userEdit);
            RegisterService.EditUser(vm.userEdit , function (res) {
                console.log(res);
                $("#modalEditUser").modal('hide');
            })

        }
        vm.deleteUser = function (user) {
            RegisterService.DeleteUser(user,function (response) {
                vm.listUser =  new NgTableParams({}, { dataset: response});
            })
        }
    };
    GuidelineController.$inject = injectParams;
    angular.module('appManager')
        .controller('GuidelineController', GuidelineController);

}());