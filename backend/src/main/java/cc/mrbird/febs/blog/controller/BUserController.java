package cc.mrbird.febs.blog.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.domain.FebsConstant;
import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.blog.entity.BUser;
import cc.mrbird.febs.blog.service.IBUserService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author MrBird
 * @date 2019-10-08 13:23:19
 */
@Slf4j
@Validated
@Controller
public class BUserController extends BaseController {

    @Autowired
    private IBUserService bUserService;

    @GetMapping("bUser")
    @ResponseBody
    //@RequiresPermissions("bUser:list")
    public FebsResponse getAllBUsers(BUser bUser) {
        return new FebsResponse().success().data(bUserService.findBUsers(bUser));
    }

    @GetMapping("bUser/list")
    @ResponseBody
    //@RequiresPermissions("bUser:list")
    public FebsResponse bUserList(QueryRequest request, BUser bUser) {
        Map<String, Object> dataTable = getDataTable(this.bUserService.findBUsers(request, bUser));
        return new FebsResponse().success().data(dataTable);
    }

    @Log("新增BUser")
    @PostMapping("bUser")
    @ResponseBody
    //@RequiresPermissions("bUser:add")
    public FebsResponse addBUser(@Valid BUser bUser) throws FebsException {
        try {
            this.bUserService.createBUser(bUser);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "新增BUser失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("删除BUser")
    @GetMapping("bUser/delete")
    @ResponseBody
    //@RequiresPermissions("bUser:delete")
    public FebsResponse deleteBUser(BUser bUser) throws FebsException {
        try {
            this.bUserService.deleteBUser(bUser);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "删除BUser失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("修改BUser")
    @PostMapping("bUser/update")
    @ResponseBody
    //@RequiresPermissions("bUser:update")
    public FebsResponse updateBUser(BUser bUser) throws FebsException {
        try {
            this.bUserService.updateBUser(bUser);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "修改BUser失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PostMapping("bUser/excel")
    @ResponseBody
    //@RequiresPermissions("bUser:export")
    public void export(QueryRequest queryRequest, BUser bUser, HttpServletResponse response) throws FebsException {
        try {
            List<BUser> bUsers = this.bUserService.findBUsers(queryRequest, bUser).getRecords();
            ExcelKit.$Export(BUser.class, response).downXlsx(bUsers, false);
        } catch (Exception e) {
            String message = "导出Excel失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}
