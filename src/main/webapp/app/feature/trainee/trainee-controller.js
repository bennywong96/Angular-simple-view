(function() {

    var TraineeController =  function() {
        
    	var vm = this;

    	vm.alan = "Don't call me Alan";

		vm.sam2 = "Don't call me Sam2";

		vm.noname = "I am No Name :)";

		vm.noNameFunction = function () {
			console.log("Hello it's me again");

        }
    	
            
    };

    angular.module('accountApp').controller('traineeController', [TraineeController]);
}());