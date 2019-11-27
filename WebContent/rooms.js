var app = angular.module('roomApp', []);
	

app.controller('roomcontroller', function($scope, $http) {
	
	$scope.rooms = function(){
		$scope.list = [];
		$http({
			  url: "./Rooms",
		      method: "POST",
		}).then(function(response){
			   $scope.list.push(response.data);
			    $scope.cc 		= response.data;
				$scope.arr 		= $scope.cc.split("\r\n");
				console.log($scope.arr);
				
		});
	}
	
	$scope.players = function(){
		
		$http({
			url: "./Player",
			method: "POST",
		}).then(function(response){
			 $scope.list.push(response.data);
			 $scope.ss 		= response.data;
		     $scope.jjj 		= $scope.ss.split("\r\n");
		});
		
	}
	
	$scope.createRoom =  function(){
		$http({
			url:"./CreateRoom",
			method: "POST",
		}).then(function(response){
			console.log(response);
		});
	}
	
	$scope.gotoroom = function(room){
		var Indata = {"roomid":room};
		//alert(room);
		$http({
			url: "./gotoroom",
			method: "POST",
			params: Indata,
		}).then(function(response){
			window.location.href = "/tictactoe/playgame.html";
		})
	}
	
	$scope.userSession = function(){
		$http({
			url: "./UserSession",
			method: "POST"
		}).then(function(response){
			$scope.welcomeUser = response.data;
		})
	}
	
	$scope.userSession();
	$scope.rooms();
	$scope.players();
	
	
	
	
});
