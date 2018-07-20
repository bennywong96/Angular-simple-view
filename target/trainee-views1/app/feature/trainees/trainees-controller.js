"use strict";

(function() {
    console.log("TRAINEESCONTROLLER :D");
    var TraineesController =  function(traineeService, $log, dataService, $state) {
        
    	var vm = this;

        vm.isHidden = false;
        vm.hideTable = function()
        {
            vm.isHidden = !vm.isHidden
        };


        vm.selectedTrainee = function(name){
            this.firstname = name;
        };

        (function() {
            traineeService.getTrainees().then(function (results) {
                vm.trainees = results;
                console.log(results);
                $log.log("In the trainee controller the value of the result promise is ");
                $log.log(JSON.stringify(vm.trainees));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        })();



        vm.newFunction = function(n) {
            var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
            table = document.getElementById("myTable2");
            switching = true;
            dir = "asc";
            while (switching) {
                switching = false;
                rows = table.getElementsByTagName("TR");
                for (i = 1; i < (rows.length - 1); i++) {

                    shouldSwitch = false;

                    x = rows[i].getElementsByTagName("TD")[n];
                    y = rows[i + 1].getElementsByTagName("TD")[n];

                    if (dir == "asc") {
                        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {

                            shouldSwitch = true;
                            break;
                        }
                    } else if (dir == "desc") {
                        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {

                            shouldSwitch = true;
                            break;
                        }
                    }
                }
                if (shouldSwitch) {
                    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                    switching = true;
                    switchcount ++;
                } else {
                    if (switchcount == 0 && dir == "asc") {
                        dir = "desc";
                        switching = true;
                    }
                }
            }
        };


        vm.passTrainee = function (data) {
            vm.selectedTrainee = data;
            dataService.setData(data);
            $state.go("traineedetails", { obj:  vm.selectedTrainee });
        };

        vm.selectedTrainee = dataService.getData();
        console.log(vm.selectedTrainee);

        vm.goSomewhere = function () {
            $state.go('trainees');
        };



    };

    angular.module('traineeApp').controller('traineesController', ['traineeService','$log', 'dataService', '$state', TraineesController]);
}());
