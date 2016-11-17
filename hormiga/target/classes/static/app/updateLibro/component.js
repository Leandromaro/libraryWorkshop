var updatelibro = angular.module('updatelibro',['ngRoute'])

.component('updatelibro',{
    templateUrl: "app/updateLibro/view.html",
    controller:['$http','$location','$route',function($http,$location,$route) {
                       var self = this;
                       self.refresh = function() {
                                                      $http({
                                                      method: 'GET',
                                                      url: '/books/'+$route.current.params.id
                                                  }).then(
                                                      function Success(response) {

                                                           console.log(response.data);
                                                           self.libro = response.data;

                                                      });
                                                  }
                                                  self.refresh();

                       self.updateBook = function(book,lb) {
                       book.idbooks=lb.idbooks;
                       if(typeof(book.isbn) === "undefined"){
                        book.isbn=lb.isbn;
                       }
                           $http.put('books', book).then(function(result) {
                           console.log(book);
                               self.result = result.data.message;
                               console.log(result);
                               if(result.data==""){
                                    alert("No se actualizo el libro\nPor favor verifique los campos y vuelva a intentarlo.")
                               }else{
                                    alert("Se ha actualizado el libro.")
                                    $location.path("/");
                               }
                           });
                       }
                   }],
    controllerAs:'ul'
})