angular.module('keren.core.website',['keren.core.commons'])
.controller('portailwebCtrl' ,['$rootScope','$scope','$http','$location','commonsTools'
  ,function($rootScope,$scope,$http,$location,commonsTools){
	$scope.currentuser = null;
	$scope.website = null;
	$scope.pos = null ;
	$scope.articles = new Array();
	$scope.title ="TERATECH";
	$scope.subtotal = 0 ;
	$scope.totaltaxes = 0 ;
	$scope.total = 0 ;
	$scope.createEmptyCommande = function(){
		var cmde = new Object();
		cmde.id = -1; cmde.compareid=-1;cmde.createonfield=true;
		cmde.desablecreate=true;cmde.desabledelete=true;
		cmde.desableupdate=true;cmde.activefilelien= false;
		cmde.activatefollower = false;cmde.code = null;
		cmde.datecmde = new Date();cmde.session = null;
		cmde.client=null;
		cmde.lignes = new Array();
		return cmde;
	};
	$scope.commande = $scope.createEmptyCommande();	
	$scope.productSelect = function(item){
		console.log("posweb.productSelect ===== "+angular.toJson(item));
		for(var i=0;i<$scope.commande.lignes.length;i++){
			var ligne = $scope.commande.lignes[i];
			if(ligne.article.id===item.id){
				return;
			}//end if(ligne.article.id===item.article.id){
		}//end for(var i=0;i<$scope.commande.lignes.length;i++){
		var ligne = new Object();
		var date = new Date();
		ligne.id=-1;ligne.compareid=date.getTime();
		ligne.quantite=1;ligne.pu=item.puvente;
		ligne.article=item;ligne.taxes = new Array();
		for(var i=0 ;i<item.taxesventes.length;i++){
			ligne.taxes.push(item.taxesventes[i]);
		}//end for(var i=0 ;i<item.taxesventes.length;i++){		
		$scope.commande.lignes.push(ligne);
		$scope.totalFn();
	};
	$scope.removeProduct = function(item){
		for(var i=0;i<$scope.commande.lignes.length;i++){
			var ligne = $scope.commande.lignes[i];
			if(ligne.article.id===item.article.id){
				$scope.commande.lignes.splice(i,1);
			}//end if(ligne.article.id===item.article.id){
		}//end for(var i=0;i<$scope.commande.lignes.length;i++){
		$scope.totalFn();
	};
	$scope.totalFn = function(){
		$scope.totaltaxes = 0 ;
		$scope.subtotal = 0;
		for(var i=0;i<$scope.commande.lignes.length;i++){
			var ligne = $scope.commande.lignes[i];
			var montant = ligne.quantite*ligne.pu;
			$scope.subtotal = $scope.subtotal + montant;
			var taxes = ligne.taxes;
			for(var j=0;j<taxes.length;j++){
				var taxe = taxes[j];
				if(taxe.porte=='0'){
					$scope.totaltaxes =$scope.totaltaxes+taxe.montant;
				}else{
					$scope.totaltaxes =$scope.totaltaxes+(montant*taxe.montant)/100;
				}//end if(taxe.porte=='0'){				
			}//end for(var i=0;i<taxes.length;i++){
		}//end for(var i=0;i<$scope.commande.lignes.length;i++){
        $scope.total = $scope.totaltaxes+$scope.subtotal;
	};
	$scope.getArticles = function(session){
		var url0="http://"+$location.host()+":"+$location.port()+"/posweb/commande/meta";
		var url="http://"+$location.host()+":"+$location.port()+"/posweb/article";
		commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
		$http.get(url)
		       .then(function(response){
					$scope.articles = response.data;
					commonsTools.hideDialogLoading();
				  },function(error){
					commonsTools.hideDialogLoading();
				});
		
	};
	$scope.ready = function(session){
		$scope.pos = session.data;
		$scope.website = session.website;
		$http.defaults.headers.common['Authorization']='Basic '+session.currentuser.authdata; 
		$scope.getArticles(session);		
	};
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