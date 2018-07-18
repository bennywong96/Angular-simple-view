(function() {

    var MovieController =  function() {
        
    	var vm = this;
    	
        
        vm.isHidden = false;
      
        
        
        vm.movies = [
        	{'name': 'Movie 1', 'genre': 'Thriller','rating': '15'},
        	{'name': 'Movie 2', 'genre': 'Casual','rating': '12'},
        	{'name': 'Movie 3', 'genre': 'Comedy','rating': '15'},
        	{'name': 'Movie 4', 'genre': 'Casual','rating': '12'},
        	{'name': 'Movie 5', 'genre': 'Action','rating': '15'},
        	{'name': 'Movie 6', 'genre': 'Casual','rating': '12'},
            {'name': 'The Room', 'genre': 'Weird','rating': '18'}
        	
        	];
        
        vm.hideTable = function()
        {
        	vm.isHidden = !vm.isHidden
        };
        
  
            
    };

    angular.module('accountApp').controller('movieController', [MovieController]);
}());