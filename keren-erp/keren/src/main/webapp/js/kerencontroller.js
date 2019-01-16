/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module("keren.core",["ngResource","ngSanitize","pascalprecht.translate",'keren.core.login','mainApp','keren.core.website','keren.core.commons']);
//Regle de traduction 
angular.module("keren.core")
        .config(['$translateProvider',
    function($translateProvider){
        $translateProvider.useUrlLoader("auth/resource/translate");
        $translateProvider.preferredLanguage("fr");        
    }]);
angular.module("keren.core")
        .controller("kerenCtrl" ,function($scope,$rootScope,$http,$location,$interval,$translate,commonsTools,authenticationService){
              $scope.hostname = $location.host();    
              $scope.portvalue = $location.port();
              $scope.protocol = $location.protocol(); 
              $scope.level = "login";
              $scope.activemodule = "login";
              //Login de l'utilisateur
              $scope.username = null ;
              
                /**
                * Evenement de login
                */
               $scope.$on("authenticate" , function(event ,args){
                   //Recuperation du login$
                   $scope.username = args.username ;
                   $scope.activemodule = "kerencore";
//                    console.log('$scope.$on("authenticate" , function(event ,args) :::::::::::::::: '+$scope.username);
                    $scope.level = "authenticate";
                    //Chargement des données de l'utilisateur authentifié   
//                    commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                    var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/utilisateur/bystringproperty/courriel/"+$scope.username;
                    $http.get(url)
                            .then(function(response){
//                                console.log("Kerencontroller :::::::  "+angular.toJson(response.data));
                                if(response.data && response.data.length>0){
                                    $rootScope.globals.userinfo = response.data[0];
                                }//end if(response.data && response.data.length>0)
//                                commonsTools.hideDialogLoading();
                            },function(error){
                                commonsTools.hideDialogLoading();
//                                commonsTools.showMessageDialog(error);
                            });
               });

                /**
                * Echec de login de login
                */
               $scope.$on("login" , function(event ,args){
//                   console.log('$scope.$on("dataLoad" , function(event ,args) :::::::::::::::: '+angular.toJson(args));
                   //$location.path("/failed");
                   $scope.level = "login";
                   $scope.activemodule = "login";
                   $scope.stopdiscussionworker();
                   
               });
               
               $scope.$on("website" , function(event ,args){
                   var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/keren/#/website/"+args.website;
//                   console.log('$scope.$on("website" , function(event ,args) :::::::::::::::: '+angular.toJson(args.item));
                     //$location.path("/failed");                     
                     $http.defaults.headers.common['Authorization']='Basic '+args.currentuser.authdata;      
                     var key= "kerensession";
                     var webSiteContext = new Object();
                     webSiteContext.currentuser = $rootScope.globals.currentUser;
                     webSiteContext.website = $rootScope.website;
                     webSiteContext.data = args.item;//                     
                     sessionStorage.setItem(key,angular.toJson(webSiteContext));
                     window.location.replace(url);
                     location.reload();
               });
               /**
                * 
                * @param {type} module
                * @returns {undefined}
                */
               $scope.active = function(module){
                   if($scope.level==="website" && module==="website"){
                       return true;
                   }//end if($scope.level==="website" && module==="website"){
                   if($scope.level==="login" && module==="login"){
                       return true;
                   }//end if($scope.level==="website" && module==="website"){
                   if(module=="kerencore" && $scope.level==="authenticate"){
                       return true;
                   }
                   return false;
               };
               $scope.stopdiscussionworker = function(){
                   if(angular.isDefined($rootScope.globals.discussionworker)){
                       $interval.cancel($rootScope.globals.discussionworker);
                       $rootScope.globals.discussionworker = undefined;
                   }//end if(angular.isDefined($rootScope.globals.discussionworker))  
                };
                
                $scope.init = function(){
//                    $scope.level = "login";
                    var path = $location.path();
                    var paths = path.split('/');
                    if(paths.length>1 && paths[1]==='website'){
                        $scope.level = paths[1];
                        $rootScope.website = paths[2];
                        $scope.activemodule = "website";
                    }else{
                        var key= "kerensession";
                        var sessionitem = sessionStorage.getItem(key);
                        if(sessionitem==null){
                            $scope.level = "login";
                            $scope.activemodule = "login";
                        }else{
                            var session = angular.fromJson(sessionitem);
                            $rootScope.globals = new Object();
                            $rootScope.globals.currentUser = session.currentuser;
                            $http.defaults.headers.common['Authorization']='Basic '+$rootScope.globals.currentUser.authdata;      
                            sessionStorage.removeItem(key);
                            $rootScope.$broadcast("authenticate" , {username:$rootScope.globals.currentUser.username 
                                                      ,authdata:$rootScope.globals.currentUser.authdata});
                        }//end if(sessionitem==null){
                    }//end if(paths.length>1 && paths[1]==='website'){                    
//                    console.log("kerencontroller.init ================== "+angular.toJson(paths));
                };
                $scope.init();
        });

