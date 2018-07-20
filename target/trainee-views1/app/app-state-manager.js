"use strict";

(function () {

    angular.module('traineeApp').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/dashboard");

        $stateProvider.state("dashboard", {
            url: "/dashboard",
            templateUrl: "app/feature/dashboard/dashboard.html"
        }).state("traineedetails", {
            url: "/traineedetails",
            params: {
                obj: null
            },
            templateUrl: "app/feature/traineedetails/traineedetails.html"
        }).state("trainees", {
            url: "/trainees",
            templateUrl: "app/feature/trainees/trainees.html"
        })

    });
}());