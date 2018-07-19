'use strict';
accountApp.service('dataService', function() {
    var service = this;
    service.data = '';
    service.getData = function(){
        return service.data;
    }
    service.setData = function(requestData){
        service.data = requestData;
    }

});