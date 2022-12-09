(function () {
    var app = angular.module('CommentsDataApiProvider', []);

    app.factory('CommentsDataApiService', function ($http, $q){
        var service = {};

        service.contextPathYT = '';
        service.contextPathFB = '';

        service.credencialesYT = '';
        service.credencialesFB = '';

        service.getCommentsYoutubeDataAPI = function () {
            return $http.get(service.contextPathYT + '/getCommentsLiveChat' + service.credencialesYT);
        }

        service.getCommentsFacebookAPI = function () {
            return $http.get(service.contextPathFB + '/getComments' + service.credencialesFB);
        }

        service.sendComment = function(comment){
            return $http.post('http://localhost:8080/streming-comments/comentarioCreate/', comment);
        }

        service.getComments = function () {
            return $http.get(service.contextPath);
        }

        service.deleteComments = function (idComment) {
            return $http.post('http://localhost:8080/streming-comments/comentarioDelete/', idComment);
        }

        return service;
    })
})();