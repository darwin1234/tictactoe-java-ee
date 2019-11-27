angular.module('submitExample', [])
    .controller('ExampleController', ['$scope', '$http', function($scope,$http) {
      $scope.list = [];
      $scope.username = 'darwin1234';
      $scope.password = 'test123test123';
      $scope.firstname = 'Darwin';
      $scope.lastname =  'Sese';
      $scope.submit = function() {
    	  var Indata = {'username': $scope.username, 'password': $scope.password, 'firstname': $scope.firstname, 'lastname': $scope.lastname};
    	  $http({
    	      url: "./registerplayer",
    	      method: "POST",
    	      params: Indata,
    	  }).then(function(response){
    		  console.log(response)
    	  });
      };
}]);