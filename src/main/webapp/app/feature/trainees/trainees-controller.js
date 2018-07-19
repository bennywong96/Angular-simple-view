(function() {

    var TraineesController =  function(dataService, $state) {
        
    	var vm = this;

        vm.traineeslist = [
            {'firstname':'Jenkins','lastname':'Massey','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Jarad','lastname':'Huggard','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Daryl','lastname':'Conway','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Sam','lastname':'Kirk','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Hussein','lastname':'Tejan','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Oliver','lastname':'Loades','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Naomi','lastname':'Stanley','languages':['Ruby','Java','JavaScript']},
            {'firstname':'George','lastname':'Timbrell','languages':['Ruby','Java','JavaScript','Bit of Everything Else']},
            {'firstname':'Benny','lastname':'Wong','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Daniel','lastname':'Osagie','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Syed','lastname':'Ahmed','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Adam','lastname':'Afzal','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Nawid','lastname':'Mujadidi','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Christopher','lastname':'Darrall','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Kate','lastname':'Genova','languages':['Ruby','Java','JavaScript']},
            {'firstname':'Shiyamalan','lastname':'Sunthar','languages':['Ruby','Java','JavaScript']}
        ];

        vm.isHidden = false;
        vm.hideTable = function()
        {
            vm.isHidden = !vm.isHidden
        };

        vm.print1 = function()
        {
            console.log("hi")
        };
        vm.selectedTrainee = function(name){
            this.firstname = name;
        }


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
        }


        vm.passTrainee = function (data) {
            console.log("passtrainee function");
            console.log(data);
            vm.selectedTrainee = data;
            dataService.setData(data);
            $state.go("traineedetails", { obj:  vm.selectedTrainee });
        }

        vm.selectedTrainee = dataService.getData();

        vm.goSomewhere = function () {
            $state.go('trainees');
        };
    };

    angular.module('accountApp').controller('traineesController', ['dataService', '$state', TraineesController]);
}());