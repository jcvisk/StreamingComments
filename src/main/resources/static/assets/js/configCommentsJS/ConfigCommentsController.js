(function () {
    var app = angular.module('ConfigComments', ['ConfigCommentsProvider']);
    app.controller('ConfigCommentsContoller', function ($scope, $http, $compile, ConfigCommentsService) {

        var ctrl = this;
        $scope.comment={};

        ctrl.contextPathController = ConfigCommentsService.contextPath;

        ctrl.init = function () {
            ConfigCommentsService.contextPath = ctrl.getContextPath() + '/getComentario';
            ctrl.getComments();
        }

        ctrl.getComments = function (){
            return ConfigCommentsService.getComments().then(function (res){
                $scope.comment = res.data;
            })
        }

        ctrl.getContextPath = function () {
            let origin = window.location.origin;
            let pathName = window.location.pathname.split("/");
            return origin +'/'+ pathName[1]
        }

        $scope.cambiarBackground = function(i){
            if (Object.keys($scope.comment).length !== 0){
                $scope.comment.id = 1;
                $scope.comment.background = i;
                ConfigCommentsService.sendComment($scope.comment);
            }else{
                window.alert("Antes debes mostrar un comentario")
            }
        };
    });
})();