/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('bookApp',['ui.router','ngResource','bookApp.controllers','bookApp.services']);

angular.module('bookApp').config(function($stateProvider,$httpProvider){
    $stateProvider.state('books',{
        url:'/books',
        templateUrl:'bookApp/partials/books.html',
        controller:'BookListController'
    }).state('viewBook',{
       url:'/books/:id/view',
       templateUrl:'bookApp/partials/book-view.html',
       controller:'BookViewController'
    }).state('newBook',{
        url:'/books/new',
        templateUrl:'bookApp/partials/book-add.html',
        controller:'BookCreateController'
    }).state('editBook',{
        url:'/books/:id/edit',
        templateUrl:'bookApp/partials/book-edit.html',
        controller:'BookEditController'
    });

    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}).run(function($state){
   $state.go('books');
});