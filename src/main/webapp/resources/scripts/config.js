bonvioCRM.config(function ($stateProvider, $urlRouterProvider, $locationProvider) {
    //
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/dashboard");
    //
    // Now set up the states
    $stateProvider

        .state('login', {
            url: "/login",
            views: {
                //"topPanel": { template: "index.viewA" },
                "contentPanel": {templateUrl: "resources/templates/loginPage.html"}
            }
        })
        .state('dashboard', {
            url: "/dashboard",
            views: {
                "topPanel": {templateUrl: "resources/templates/topNav.html"},
                "contentPanel": {templateUrl: "resources/templates/dashboard.html"}
            }
        })

        .state('deals', {
            url: "/deals",
            views: {
                "topPanel": {templateUrl: "resources/templates/topNav.html"},
                "contentPanel": {templateUrl: "resources/templates/dealPage.html"}
            }
        })
        .state('tasks', {
            url: "/tasks",
            views: {
                "topPanel": {templateUrl: "resources/templates/topNav.html"},
                "contentPanel": {templateUrl: "resources/templates/taskPage.html"}
            }
        })
        .state('contacts', {
            url: "/contacts",
            views: {
                "topPanel": {templateUrl: "resources/templates/navigationTop.html"},
                "contentPanel": {templateUrl: "resources/templates/contactPage.html"}
            }
        });

    $locationProvider.html5Mode(true).hashPrefix('!');

});