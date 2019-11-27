var app = angular.module('tictactioApp', []);
	

app.controller('TicTacCtrl', function($scope, $http) {

  $scope.userPlayer = "";
  $scope.init = function(){
	
	 $scope.gamestatus  = "";
	 $scope.player = "";
	 $scope.roomid ="";
	 $scope.creator ="";
	 $scope.oponent = "";
	 $scope.gamers = "";
	 setInterval(function(){
		 $http.post("./InsertData" ).then(function(response){
				$scope.cc = response.data;
				$scope.arr = $scope.cc.split("@");
				console.log(response.data);
				$scope.board = [
					    [ { value: $scope.arr[0] }, { value: $scope.arr[1] }, { value: $scope.arr[2] } ],
					    [ { value: $scope.arr[3] }, { value: $scope.arr[4] }, { value: $scope.arr[5] } ],
					    [ { value: $scope.arr[6] }, { value: $scope.arr[7] }, { value: $scope.arr[8] } ]	
				]; 
				 $scope.gamestatus =  $scope.arr[9];
				 $scope.player = $scope.arr[10];
				 $scope.userPlayer = $scope.arr[11];
				 $scope.roomid = $scope.arr[12];
				 $scope.creator = $scope.arr[13];
				 $scope.oponent  = $scope.arr[14];
				 $scope.currentPlayer = $scope.arr[15];
				 $scope.winner = $scope.arr[17];
				 $scope.gamers = $scope.arr[13] + " VS " + $scope.arr[14];
				 
				
				 
		});	 
			 
		 
	 },5000)
	
	 
	// console.log(sessionStorage.getItem('room_id'));
  }
  
  $scope.init();	
  
  $scope.ticked = function(cell) {
	    return cell.value !== '-';
   };
	  
  
  $scope.playerchoice = function(cell,row,position){
	  
	  
	  $scope.currentPlayer = $scope.currentPlayer === 'X' ? 'O' : 'X';
	 
	  cell.value = $scope.currentPlayer;
	 
	  
	  console.log("Cell: " + $scope.currentPlayer + " row: " + row + " position: " + position);
	  var Indata = {'cell_selected': $scope.currentPlayer, 'row': row, 'position': position};
	  
	  $http({
	      url: "./InsertData",
	      method: "POST",
	      params: Indata,
	  }).then(function(response){
		  $scope.cc = response.data;
		  $scope.arr = $scope.cc.split("@");
		 ///console.log(response.data);
	      $scope.board = [
		    [ { value: $scope.arr[0] }, { value: $scope.arr[1] }, { value: $scope.arr[2] } ],
		    [ { value: $scope.arr[3] }, { value: $scope.arr[4] }, { value: $scope.arr[5] } ],
		    [ { value: $scope.arr[6] }, { value: $scope.arr[7] }, { value: $scope.arr[8] } ]	
		  ]; 
	     
	     $scope.gamestatus =  $scope.arr[9];
	     $scope.player = $scope.arr[10];
	      
	  });
  }
  
  $scope.joingame = function(){
	  var Indata = {"playername": $scope.userPlayer, "roomid" :  $scope.roomid};
	  //alert($scope.userPlayer);
	  $http({
		  url: "./JoinGame",
		  method: "POST",
		  params: Indata
	  }).then(function(response){
		  $scope.init();
		  
	  });
	  
  }
  
});