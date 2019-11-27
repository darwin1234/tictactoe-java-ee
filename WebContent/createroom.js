angular.module('createroom', [])
    .controller('createroomController', ['$scope', '$http', function($scope,$http) {
      $scope.list = [];
      $scope.roomname = '';
      $scope.submit = function() {
    	  var Indata = {'roomname': $scope.roomname};
    	  $http({
    	      url: "./CreateRoom",
    	      method: "POST",
    	      params: Indata,
    	  }).then(function(response){
    		  console.log(response)
    		  alert("ROOM CREATED!");
    	  });
      };
}]);