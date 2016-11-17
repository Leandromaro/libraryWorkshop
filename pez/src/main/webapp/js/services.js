/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('bookApp.services',[]).factory('Book',function($resource){
    return $resource('http://localhost:8181/books/:id',{id:'@idbooks'},{
        update: {
            method: 'PUT'
        }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});