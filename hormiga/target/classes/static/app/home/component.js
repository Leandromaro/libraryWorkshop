var home = angular.module('home',['ngRoute'])

.component('home',{
	templateUrl:"app/home/view.html",
	controller:['$http','$location', function Controller($http,$location) {
                           var self = this;
                           self.refresh = function() {
                               $http({
                               method: 'GET',
                               url: '/books'
                           }).then(
                               function Success(response) {

                                    console.log(response.data);
                                    self.books = response.data;

                               })
                           }
                           self.refresh();
                           self.deleteBook=function(id){
                                $http({
                                method: 'DELETE',
                                url: '/books/'+id
                           }).then(function(result) {
                                    self.result = result.data.message;
                                    console.log(result);
                                });
                           }

                       }],
	controllerAs:'home'
})