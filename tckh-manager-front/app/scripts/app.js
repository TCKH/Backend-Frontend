(function () {
    var app = angular.module('appManager', ['ngRoute','ngResource','textAngular','ngCookies', 'angular-media-preview',
        'ngFileUpload','ngSanitize']);
    // Constants
    app.constant('config', {
        backEndUrl: 'http://localhost:8080/TCKH/',
        Title: {

        },
        Messages: {},
        Confirm: {},
        Errors: {

        }
    })
    // Route Config
    app.config(['$routeProvider',
        function ($routeProvider) {
            var viewBase = 'pages/';
            $routeProvider
                .when('/', {
                    controller: 'HomeController',
                    templateUrl: viewBase + 'home.html',
                    controllerAs: 'vm'
                })
                .when('/issues',{
                    controller: 'IssuesController',
                    templateUrl: viewBase + 'issues/issues.html',
                    controllerAs: 'vm'
                })
                .when('/scope',{
                    controller: 'ScopeController',
                    templateUrl: viewBase + 'journal/scope.html',
                    controllerAs: 'vm'
                })
                .when('/editors',{
                    controller: 'EditorBoardController',
                    templateUrl: viewBase + 'journal/editorBoard.html',
                    controllerAs: 'vm'
                })
                .when('/reviewers',{
                    controller: 'ExecutiveController',
                    templateUrl: viewBase + 'journal/executivePeer.html',
                    controllerAs: 'vm'
                })
                .when('/abstract',{
                    controller: 'AbstractController',
                    templateUrl: viewBase + 'journal/abstract.html',
                    controllerAs: 'vm'
                })
                .when('/subscription',{
                    controller: 'SubscriptionController',
                    templateUrl: viewBase + 'journal/subscription.html',
                    controllerAs: 'vm'
                })
                .when('/alert',{
                    controller: 'AlertController',
                    templateUrl: viewBase + 'journal/alertService.html',
                    controllerAs: 'vm'
                })
                .when('/guideline',{
                    controller: 'GuidelineController',
                    templateUrl: viewBase + 'author/guideline.html',
                    controllerAs: 'vm'
                })
                .when('/login',{
                    controller: 'LoginController',
                    templateUrl: viewBase + 'author/login.html',
                    controllerAs: 'vm'
                })
                .when('/register',{
                    controller: 'RegisterController',
                    templateUrl: viewBase + 'author/register.html',
                    controllerAs: 'vm'
                })
                .when('/request-password',{
                    controller: 'RequestPasswordController',
                    templateUrl: viewBase + 'author/requestPassword.html',
                    controllerAs: 'vm'
                })
                .when('/status',{
                    controller: 'StatusController',
                    templateUrl: viewBase + 'author/trackYourPaper.html',
                    controllerAs: 'vm'
                })
                .when('/articles',{
                    controller: 'ArticlesController',
                    templateUrl: viewBase + 'issues/articles.html',
                    controllerAs: 'vm'
                })
                .when('/past',{
                    controller: 'PastIssuesController',
                    templateUrl: viewBase + 'issues/pastIssues.html',
                    controllerAs: 'vm'
                })
                .when('/special',{
                    controller: 'SpecialIssuesController',
                    templateUrl: viewBase + 'specialIssues/index.html',
                    controllerAs: 'vm'
                })
                .when('/new',{
                    controller: 'NewController',
                    templateUrl: viewBase + 'announcement/index.html',
                    controllerAs: 'vm'
                })
                .when('/top-article',{
                    controller: 'TopArticlesController',
                    templateUrl: viewBase + 'topArticles/index.html',
                    controllerAs: 'vm'
                })
                .when('/post-article',{
                    controller: 'PostController',
                    templateUrl: viewBase + 'articles/post_articles.html',
                    controllerAs: 'vm'
                })
                .when('/view',{
                    controller: 'ViewController',
                    templateUrl: viewBase + 'issues/view.html',
                    controllerAs: 'vm'
                })
                .otherwise({redirectTo: '/'});

        }]);
    app.run(['$window', '$rootScope', '$location', '$http',  'config', 'RegisterService','$cookieStore',
        function ($window, $rootScope, $location, $http, config, RegisterService,$cookieStore) {
            $rootScope.author = {
                username: "",
                password: ""
            };
            $rootScope.Article = [];
            $rootScope.viewArticle = [];
            $rootScope.globals = $cookieStore.get('globals');
            $rootScope.logout = function () {
                RegisterService.ClearCredentials();
                $location.path('/login');
            }
        }]);
}())