angular.module("exampleApp" , ["ngResource" , "increment"])
.constant("baseUrl" , "http://localhost:8080/smsgw-portail/product/")
.controller("defaultCtrl" ,  function($scope , $http ,$resource,baseUrl){

	    $scope.displayMode = "list";
	    $scope.currentProduct = null;
            $scope.productsResource = $resource(baseUrl+"?:id",{id:"@id"},
                    {create:{method:"POST"},save:{method:"PUT"},supprimer:{method:"DELETE"}});

        $scope.listProducts = function(){
//	        $http.get(baseUrl).then(function(response){
//                 $scope.products = response.data;
//	        },function(error){
//
//	        });
                $scope.products = $scope.productsResource.query();
        }

       $scope.deleteProduct = function(product){
//           $http({
//               method:"DELETE",
//               params:{"id":product.id},
//               url: baseUrl
//           }).then(function(response){
//               $scope.products.splice($scope.products.indexof(product),1);
//           },function(error){
//               
//           });
       	    new $scope.productsResource(product).$supprimer().then(function(deleteProduct){
                $scope.products.splice($scope.products.indexOf(product),1);
            });
            $scope.displayMode = "list";
       }

       $scope.createProduct = function(product){
//           $http.post(baseUrl , product).then(function(response){
//               $scope.products.push(response.data);
//       	       $scope.displayMode = "list";
//           },function(error){
//               
//           });
       	    new $scope.productsResource(product).$create().then(function(newProduct){
                $scope.products.push(newProduct);
       	       $scope.displayMode = "list";
            });
       }

       $scope.updateProduct = function(product){
//           $http({
//               url: baseUrl,
//               method:"PUT",
//               params:{"id":product.id},
//               data : product
//           }).then(function(response){
//                for(var i=0 ; i<$scope.products.length;i++){
//       	   	   if($scope.products[i].id == product.id){
//       	   	   	   $scope.products[i] = product;
//       	   	   	   break;
//       	   	   }
//                }
//                $scope.displayMode = "list";
//           });
       	   product.$save();
           $scope.displayMode = "list";
       }

       $scope.editOrCreateProduct = function(product){
       	   $scope.currentProduct = product ? product : {};
       	   $scope.displayMode = "edit";
       }

       $scope.saveEdit = function(product){

       	    if(angular.isDefined(product.id)){
       	    	$scope.updateProduct(product);
       	    }else{
       	    	$scope.createProduct(product);
       	    }
       }

       $scope.cancelEdit = function(){
           if($scope.currentProduct && $scope.currentProduct.$get){
               $scope.currentProduct.$get();
           }
       	    $scope.currentProduct = {};
       	    $scope.displayMode = "list";
       }

       $scope.listProducts();
});
