/****
 * 模块和路由定义
 */
var actionApp = angular.module('actionApp',['ngRoute']); /*定义模块actionApp并依赖于路由模块ngRoute*/

actionApp.config(['routeProvider',function ($routeProvider) {  /*配置路由并注入$routeProvider*/''
    $routeProvider.when('/oper',{  /*/oper路由名称*/
        controller: 'View1Controller', /*controller , 定义路由器的控制名称*/
        templateUrl:'views/view1.html', /*定义视图的真正地址*/
    }).when('/directive',{
        controller: 'View2Controller', /*controller , 定义路由器的控制名称*/
        templateUrl:'views/view2.html', /*定义视图的真正地址*/
    });
}]);