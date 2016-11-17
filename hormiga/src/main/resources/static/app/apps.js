var biblioteca= angular.module('biblioteca',['ngRoute','home','addlibro'])

.config(function ($routeProvider){
    $routeProvider
    .when("/",{
        template:'<home></home>'
    })
    .when("/nuevoLibro",{
            template:'<addlibro></addlibro>'
        })
})