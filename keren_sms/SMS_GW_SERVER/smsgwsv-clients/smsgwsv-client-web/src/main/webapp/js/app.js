'use strict';

angular.module('spBlogger' , ['spBlogger.posts']);

angular.module('spBlogger').run(['$state' , function($state){
      $state.go('allPosts'); }]);


