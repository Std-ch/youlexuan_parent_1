app.controller('brandController' ,function($scope,$controller,brandService){
    $controller('baseController',{$scope:$scope});//继承了baseController
    //读取列表数据绑定到表单中
    $scope.findAll=function(){
        brandService.findAll.success(
            function(response){
                $scope.list=response;
            }
        );
    }

    //添加+修改（共用）
    $scope.save=function(){

        if($scope.entity.id !=null){
            brandService.update($scope.entity).success(
                function (resopnes) {
                    if(resopnes.success){
                        $scope.reloadList();
                    }else {
                        alert(resopnes.message);
                    }
                }
            )
        }else{
            brandService.add($scope.entity).success(
                function (resopnes) {
                    if(resopnes.success){
                        $scope.reloadList();
                    }else {
                        alert(resopnes.message);
                    }
                }
            )
        }

    }

    //查询id，根据id回显数据
    $scope.findOne=function(id){
        brandService.findOne(id).success(
            function (respones) {
                $scope.entity = respones;
            }
        )
    }
    //搜索
    $scope.searchEntity={};
    $scope.search = function(page,rows){
        brandService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems = response.total;
                $scope.list=response.rows;
            }
        )

    }






    //啥事儿也不干，只让要分页的方法调用控件的参数

    $scope.findPage=function(page,rows){
        brandService.findPage(page,rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        )
    }
    //删除操作

    $scope.des=function(){
        brandService.des($scope.selectIds).success(
            function (respones) {
                if(respones.success){
                    //重新加载列表
                    $scope.reloadList();
                }else{
                    alert(respones.message);
                }
            }
        )

    }


});