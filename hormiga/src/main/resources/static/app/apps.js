var biblioteca= angular.module('biblioteca',['ngRoute','home','addlibro','updatelibro'])

.config(function ($routeProvider){
    $routeProvider
    .when("/",{
        template:'<home></home>'
    })
    .when("/nuevoLibro",{
            template:'<addlibro></addlibro>'
        })
    .when("/actualizarLibro/:id",{
             template:'<updatelibro></updatelibro>'
        })
})