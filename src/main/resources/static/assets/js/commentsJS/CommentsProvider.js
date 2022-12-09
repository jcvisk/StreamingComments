(function () {
    var app = angular.module('CommentsProvider', []);

    app.factory('CommentsService', function ($http, $q) {
        var service = {};

        service.contextPath = '';

        service.getComments = function () {
            return $http.get(service.contextPath);
        }

        return service;
    });
})();