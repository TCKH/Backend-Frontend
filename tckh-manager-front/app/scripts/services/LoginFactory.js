/**
 * Created by KienNH2 on 10/26/2016.
 */

(function () {
    'use strict';

    angular
        .module('appManager')
        .factory('LoginFactory', LoginFactory);

    LoginFactory.$inject = ['$resource', 'config'];
    function LoginFactory($resource, config) {
        return $resource(config.backEndUrl + 'login/:username/');
    }
})();