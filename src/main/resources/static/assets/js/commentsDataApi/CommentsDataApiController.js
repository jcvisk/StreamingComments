(function () {
    var app = angular.module('CommentsDataAPI', ['CommentsDataApiProvider']);

    app.controller('CommentsDataApiController', function ($scope, $http, $compile, CommentsDataApiService) {
        var ctrl = this;

        $scope.comentario={id:null,comment:'',urlImage:'',autor:'',plataforma:''};

        ctrl.commentTmp={};
        ctrl.comment={};

        ctrl.contextPathControllerYT = CommentsDataApiService.contextPathYT;
        ctrl.contextPathControllerFB = CommentsDataApiService.contextPathFB;
        ctrl.contextPathController = CommentsDataApiService.contextPath;
        ctrl.youtubeCommentList = [];
        ctrl.youtubeCommentListTemp = [];

        ctrl.facebookCommentList = [];
        ctrl.facebookCommentListTemp = [];

        ctrl.init = function (id_accessToken, id_liveVideoId, id_apikey, id_videoid) {
            console.log("INICIANDO...")

            if (localStorage.getItem("apikey") && localStorage.getItem("videoid")) {
                //llenando los inputs
                document.getElementById(id_apikey).value = localStorage.getItem("apikey");
                document.getElementById(id_videoid).value = localStorage.getItem("videoid");

                //haciendo focus a los inputs
                document.getElementById(id_apikey).parentNode.classList.add('focused','is-focused');
                document.getElementById(id_videoid).parentNode.classList.add('focused','is-focused');
            }

            if (localStorage.getItem("accessToken") && localStorage.getItem("liveVideoid")) {
                //llenando los inputs
                document.getElementById(id_accessToken).value = localStorage.getItem("accessToken");
                document.getElementById(id_liveVideoId).value = localStorage.getItem("liveVideoid");

                //haciendo focus a los inputs
                document.getElementById(id_accessToken).parentNode.classList.add('focused','is-focused');
                document.getElementById(id_liveVideoId).parentNode.classList.add('focused','is-focused');
            }


            CommentsDataApiService.contextPath = ctrl.getContextPath() + '/getComentario';
            ctrl.getComments();
            ctrl.autoRefresh();
        }

        ctrl.startYoutubeComments = function (id_apikey, id_videoid) {
            let apiKey = document.getElementById(id_apikey).value;
            let videoId = document.getElementById(id_videoid).value;

            if (apiKey === '' || videoId === ''){
                alert("Los campos no pueden estar vacíos")
            }else{
                // Si el item 'apikey' no esta definido en localStorage entonces se define
                // Si el item 'videoid' no esta definido en localStorage entonces se define
                localStorage.setItem("apikey", apiKey);
                localStorage.setItem("videoid", videoId);

                CommentsDataApiService.contextPathYT = ctrl.getContextPath() + '/youtube/api';
                CommentsDataApiService.credencialesYT = '/'+localStorage.getItem("videoid")+'/'+localStorage.getItem("apikey");

                ctrl.getCommentsYoutubeDataAPI(true);
                ctrl.autoRefreshYoutubeComments();
            }
        }

        ctrl.startFacebookComments = function (id_accessToken, id_liveVideoId) {
            let accessToken = document.getElementById(id_accessToken).value;
            let liveVideoId = document.getElementById(id_liveVideoId).value;

            if (accessToken === '' || liveVideoId === ''){
                alert("Los campos no pueden estar vacíos")
            }else{
                // Si el item 'accessToken' no esta definido en localStorage entonces se define
                // Si el item 'liveVideoId' no esta definido en localStorage entonces se define
                localStorage.setItem("accessToken", accessToken);
                localStorage.setItem("liveVideoid", liveVideoId);

                CommentsDataApiService.contextPathFB = ctrl.getContextPath() + '/facebook/api';
                CommentsDataApiService.credencialesFB = '/'+localStorage.getItem("liveVideoid")+'/'+localStorage.getItem("accessToken");

                ctrl.getCommentsFacebookAPI(true);
                ctrl.autoRefreshFacebookComments();
            }
        }

        ctrl.getCommentsYoutubeDataAPI = function (primeraVez){
            return CommentsDataApiService.getCommentsYoutubeDataAPI().then(function (res){
                if (primeraVez){
                    ctrl.youtubeCommentListTemp = res.data;
                    ctrl.youtubeCommentList = res.data;
                }else{
                    ctrl.youtubeCommentListTemp = res.data;
                    ctrl.youtubeListComparator();
                }
            })
        }

        ctrl.getCommentsFacebookAPI = function (primeraVez) {
            return CommentsDataApiService.getCommentsFacebookAPI().then(function (res) {
                if (primeraVez){
                    ctrl.facebookCommentListTemp = res.data;
                    ctrl.facebookCommentList = res.data;
                }else{
                    ctrl.facebookCommentListTemp = res.data;
                    ctrl.facebookListComparator();
                }
            })
        }

        ctrl.getComments = function (){
            return CommentsDataApiService.getComments().then(function (res){
                ctrl.comment = res.data;
            })
        }

        ctrl.autoRefresh = function () {
            setInterval(function () {
                ctrl.getComments();
            },1000);
        }

        ctrl.autoRefreshYoutubeComments = function (){
            setInterval(function (){
                ctrl.getCommentsYoutubeDataAPI(false);
            },10000);
        }

        ctrl.autoRefreshFacebookComments = function (){
            setInterval(function (){
                ctrl.getCommentsFacebookAPI(false);
            },10000);
        }

        ctrl.comparador = function () {
            if (ctrl.commentTmp > ctrl.comment){
                ctrl.comment = ctrl.commentTmp;
            }
        }

        ctrl.youtubeListComparator = function (){
            if (ctrl.youtubeCommentListTemp.length > ctrl.youtubeCommentList.length){
                ctrl.youtubeCommentList = ctrl.youtubeCommentListTemp;
            }
        }

        ctrl.facebookListComparator = function (){
            if (ctrl.facebookCommentListTemp.length > ctrl.facebookCommentList.length){
                ctrl.facebookCommentList = ctrl.facebookCommentListTemp;
            }
        }

        ctrl.getContextPath = function () {
            let origin = window.location.origin;
            let pathName = window.location.pathname.split("/");
            return origin +'/'+ pathName[1]
        }

        $scope.saveYTComment = function(i){
            $scope.comentario.id = 1;
            $scope.comentario.comment = $("#ytComment"+i).val();
            $scope.comentario.urlImage = $("#ytUrlImage"+i).val();
            $scope.comentario.autor = $("#ytAutor"+i).val();
            $scope.comentario.plataforma = 1;
            $scope.comentario.background = 1;

            CommentsDataApiService.sendComment($scope.comentario);
        };

        $scope.saveFBComment = function(i){
            $scope.comentario.id = 1;
            $scope.comentario.comment = $("#fbComment"+i).val();
            $scope.comentario.urlImage = ctrl.getContextPath() + "/assets/img/userDefault.png";
            $scope.comentario.autor = "Usuario de Facebook";
            $scope.comentario.plataforma = 2;
            $scope.comentario.background = 1;

            CommentsDataApiService.sendComment($scope.comentario);
        };

        ctrl.delteCommentario = function(){

            CommentsDataApiService.deleteComments(1)

            $(".alert-youtube").removeClass("alert-light");
            $(".alert-youtube").addClass("alert-dark");

            $(".alert-facebook").removeClass("alert-light");
            $(".alert-facebook").addClass("alert-dark");
        }
    })
})();