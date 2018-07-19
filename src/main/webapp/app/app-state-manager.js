"use strict";

(function () {

    angular.module('accountApp').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/dashboard");

        $stateProvider.state("dashboard", {
            url: "/dashboard",
            templateUrl: "app/feature/dashboard/dashboard.html"
        }).state("account", {
                url: "/account",
                templateUrl: "app/feature/account/account.html"
        }).state("traineedetails", {
            url: "/traineedetails",
            params: {
                obj: null // as per other suggestion, added a param here
            },
            templateUrl: "app/feature/traineedetails/traineedetails.html"
        }).state("trainees", {
            url: "/trainees",
            templateUrl: "app/feature/trainees/trainees.html"
        }).state("book", {
            url: "/book",
            templateUrl: "app/feature/book/book.html"
        })

    });
}());