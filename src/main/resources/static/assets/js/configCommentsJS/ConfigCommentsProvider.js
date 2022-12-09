(function () {
    var app = angular.module('ConfigCommentsProvider', []);

    app.factory('ConfigCommentsService', function ($http, $q) {
        var service = {};

        service.contextPath = '';

        service.getComments = function () {
            return $http.get(service.contextPath);
        }

        service.sendComment = function(comment){
            return $http.post('http://localhost:8080/streming-comments/comentarioCreate/', comment);
        }

        return service;
    });
})();