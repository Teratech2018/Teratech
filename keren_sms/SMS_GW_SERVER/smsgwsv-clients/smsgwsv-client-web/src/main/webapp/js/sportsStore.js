angular.module("sportsStore")
.constant("dataUrl" , "http://localhost:8080/smsgw-portail/product")
.constant("orderUrl" , "http://localhost:8080/smsgw-portail/order")
.controller("sportsStoreCtrl" , function($scope , $http ,$location, dataUrl,orderUrl,cart){
    
    $scope.data ={};

    $http.get(dataUrl).then( function(response){
        $scope.data.products = response.data;
    } , function(error){
          $scope.data.error = error;
     }
    );
    
    $scope.sendOrder = function(shippingDetails){
        var order = angular.copy(shippingDetails);
        order.products = cart.getProducts();
        $http.post(orderUrl,order).then(
             function(response){
                 $scope.data.orderId = response.data.id;
                 cart.getProducts().length = 0 ;
             },
             function(error){
                 $scope.data.orderError = error;
             }
         ).then(function(){
                 $location.path("/complete");
         });
    }
         
});