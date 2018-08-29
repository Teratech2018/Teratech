/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module("keren.loader",["ngResource","ngSanitize","pascalprecht.translate"]);
//        .config(function($locationProvider){
//            $locationProvider.html5Mode(true);
//        });    
angular.module("keren.loader")
        .controller("LoaderCtrl" ,function($scope,$rootScope,$http,$location,$interval){
              $scope.application = "core";
              //Login de l'utilisateur
              $scope.username = null ; 
              
                $scope.init = function(){
//                    $scope.level = "login";
                    var path = $location.path();
                    var paths = path.split('/');
                    if(paths.length>1 && paths[1]==='website'){
                        $scope.application = "webcore";
                        angular.bootstrap(document.getElementById('web_container'),['keren.core.website']);
                    }else{
                        $scope.application = "core";
                        angular.bootstrap(document.getElementById('core_container'),['keren.core']);
                    }//end if(paths.length>1 && paths[1]==='website'){
    //                    console.log("kerencontroller.init ================== "+angular.toJson(paths));
                };
                $scope.init();
        });

