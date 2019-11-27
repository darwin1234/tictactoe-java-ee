angular.module('loginApp', [])
    .controller('LoginController', ['$scope', '$http', function($scope,$http) {
      $scope.list = [];
      $scope.username = '';
      $scope.password = '';
      $scope.login = function() {
    	  var Indata = {'username': $scope.username, 'password': $scope.password};
    	  $http({
    	      url: "./LoginAccount",
    	      method: "POST",
    	      params: Indata,
    	  }).then(function(response){
    		  $scope.cc = response.data;
    		  $scope.arr = $scope.cc.split("-");
    		  console.log($scope.arr[0]);
    		  if($scope.arr[0] == "successfull")
    		  {
    			  window.location.href = "/tictactoe/room.html";
    		  }else{
    			  $scope.error = "Failed to login!";
    		  }
    		  //console.log(response.data)
    	  
    		  
    	  });
      };
}]);