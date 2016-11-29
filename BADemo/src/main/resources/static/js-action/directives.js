/**
 * Created by nickzhang on 2016/11/29.
 */
actionApp.directive('datePicker',function () {
    return {
        restrict:'AC',/*限制为属性指令和样式指令*/
        link:function (scope,elem,attrs) {
            elem.datepicker();
        }
    };
});