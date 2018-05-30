package com.hry.swagger.ctl;

import com.hry.swagger.ctl.domain.Student;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by huangrongyou@yixin.im on 2018/5/15.
 */
@RestController
@EnableSwagger2 // 启动swagger注解
// api-value：定义名称，如果没有定义，则默认显示类名
@Api(value = "Swagger Test", description = "Rest API for test operations", tags = "test API")
public class SwaggerTestCtl {

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/queryById", method = {RequestMethod.POST, RequestMethod.GET})
    // 方法的说明
    @ApiOperation(value = "根据id获取记录", response = Student.class)
    // 定义请求参数
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "id", value = "主键", required = true) })
    public Student queryById(String id){
        System.out.println("queryById id = " + id);
        return new Student();
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    // 方法说明
    @ApiOperation(value = "添加学生记录", response = Integer.class)
    public int add(@ApiParam(value="添加的学生") Student student){
        System.out.println("add student = " + student);
        return 1;
    }


    @RequestMapping(value = "/del", method = {RequestMethod.POST, RequestMethod.GET})
    // 方法说明
    @ApiOperation(value = "删除学生记录学生记录")
    // 定义返回值意义
    @ApiResponses({
            @ApiResponse(code = 400, message = "服务器内部异常"),
            @ApiResponse(code = 500, message = "权限不足") })
    public int del(int id){
        System.out.println("del id = " + id);
        return 1;
    }
}