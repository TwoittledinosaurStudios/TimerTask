package com.ChangeBUG.Controller;

import com.ChangeBUG.Service.FileTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "FileTableController-[/]-文件操作_接口")
@Controller
public class FileTableController {

    @Autowired
    FileTableService fileTableService;

    @ResponseBody
    @ApiOperation(value = "[/getAllPermission]-测试")
    @RequestMapping(value = "/getAllPermission", method = RequestMethod.GET)
    public String getAllPermission() {
        return "123";
    }

}
