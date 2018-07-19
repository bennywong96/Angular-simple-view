(function() {

    var BookController =  function() {
        
    	var vm = this;


    	vm.books = [
			{"author":"Author 1", "genre":"Mystery"},
            {"author":"Author 2", "genre":"Action"}
		]

    	
            
    };

    angular.module('accountApp').controller('bookController', [BookController]);
}());