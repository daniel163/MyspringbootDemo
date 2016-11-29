/**
 * Created by nickzhang on 2016/11/29.
 */
/*定义控制器viewController,并注入$rootScope,$scope,$http*/
actionApp.controller('View1Controller',['$rootScope','$scope','$http',function ($rootScope,$scope,$http) {
    /*监听,在页面加载完成后做一些操作*/
    $scope.$on('$viewContentLoaded',function () {
        console.log('页面加载完成..');
    });

    $scope.search = function () {
        personName = $scope.personName;  /*定义personName接收页面输入的personName的值*/
        $http.get('search',{  /*发送get请求*/
            params:{personName:personName} /*使用params设置请求参数*/
        }).success(function (data) { /*请求成功之后的回调函数*/
            /*将返回数据赋值给$scope.person模型,
            * 在页面上就能使用{{person.name}}...等调用数据,并且模型值改变后页面会自动更新
            * */
            $scope.person = data;
        });
    };
}]);

actionApp.controller('View2Controller',['$rootScope','$scope',function ($rootScope,$scope) {
    $scope.$on('$viewContentLoaded',function () {
        console.log('页面加载完成..');
    });
}]);