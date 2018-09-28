angular.module('keren.core.website',['keren.core.commons'])
.controller('portailwebCtrl' ,['$rootScope','$scope','commonsTools'
  ,function($rootScope,$scope,commonsTools){
	$scope.currentuser = null;
	$scope.website = null;
    $scope.title ="TERATECH";
	
	$scope.goto = function(templateid,position){
		commonsTools.goto($scope,$scope.website,templateid,position);
	};
    $scope.bonjour = function(){
		var key = $('#website_cache').attr('value');
		$scope.currentuser = angular.fromJson(sessionStorage.getItem(key));
        alert("Hello ce fichier est execute : "+key+" ====== "+angular.toJson($scope.currentuser));
    };
    $scope.freecall = function(){
		return $scope.currentuser==null || $scope.currentuser.username==='website@website';
	};
	$scope.backtocore = function(){
		commonsTools.backtocore($scope);
	};
	$scope.refresh = function(){
		commonsTools.startWebsiteWorker($scope);
	};
     $scope.refresh();
}]);