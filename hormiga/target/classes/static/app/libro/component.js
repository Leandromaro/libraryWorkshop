var addlibro = angular.module('addlibro',['ngRoute'])

.component('addlibro',{
    templateUrl: "app/libro/view.html",
    controller:function($http,$location) {
                       var self = this;
                       self.saveBook = function(book) {
                           $http.post('books', book).then(function(result) {
                           console.log(book);
                               self.result = result.data.message;
                               console.log(result);
                               if(result.data==""){
                                    alert("No se guardo el libro\nPor favor verifique los campos y vuelva a intentarlo.")
                               }else{
                                    alert("Se ha agregado un nuevo libro.")
                                    $location.path("/");
                               }
                           });
                       }
                   },
    controllerAs:'addlibro'
})