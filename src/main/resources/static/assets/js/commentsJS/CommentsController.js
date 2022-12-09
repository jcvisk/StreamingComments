(function () {
    var app = angular.module('Comments', ['CommentsProvider']);
    app.controller('CommentsContoller', function ($scope, $http, $compile, CommentsService) {
        var ctrl = this;
        ctrl.contextPathController = CommentsService.contextPath;
        ctrl.commentTmp={};
        ctrl.comment={};

        ctrl.init = function () {
            CommentsService.contextPath = ctrl.getContextPath() + '/getComentario';
            ctrl.getComments();
            ctrl.autoRefresh();
        }

        ctrl.getComments = function (){
            return CommentsService.getComments().then(function (res){
                ctrl.comment = res.data;
            })
        }

        ctrl.autoRefresh = function () {
            setInterval(function () {
                ctrl.getComments();
            },1000);
        }

        ctrl.comparador = function () {
            if (ctrl.commentTmp > ctrl.comment){
                ctrl.comment = ctrl.commentTmp;
            }
        }

        ctrl.getContextPath = function () {
            let origin = window.location.origin;
            let pathName = window.location.pathname.split("/");
            return origin +'/'+ pathName[1]
        }

        ctrl.isObjectEmpty = function(obj) {
            return !!Object.keys(obj).length;
        }
    });
})();