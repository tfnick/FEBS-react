package cc.mrbird.febs.blog.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.blog.entity.BPost;
import cc.mrbird.febs.blog.service.IBPostService;
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
 * @date 2019-10-08 13:23:23
 */
@Slf4j
@Validated
@Controller
public class BPostController extends BaseController {

    @Autowired
    private IBPostService bPostService;

    @GetMapping("bPost")
    @ResponseBody
    //@RequiresPermissions("bPost:list")
    public FebsResponse getAllBPosts(BPost bPost) {
        return new FebsResponse().success().data(bPostService.findBPosts(bPost));
    }

    @GetMapping("bPost/list")
    @ResponseBody
    //@RequiresPermissions("bPost:list")
    public FebsResponse bPostList(QueryRequest request, BPost bPost) {
        Map<String, Object> dataTable = getDataTable(this.bPostService.findBPosts(request, bPost));
        return new FebsResponse().success().data(dataTable);
    }

    @Log("新增BPost")
    @PostMapping("bPost")
    @ResponseBody
    //@RequiresPermissions("bPost:add")
    public FebsResponse addBPost(@Valid BPost bPost) throws FebsException {
        try {
            this.bPostService.createBPost(bPost);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "新增BPost失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("删除BPost")
    @GetMapping("bPost/delete")
    @ResponseBody
    //@RequiresPermissions("bPost:delete")
    public FebsResponse deleteBPost(BPost bPost) throws FebsException {
        try {
            this.bPostService.deleteBPost(bPost);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "删除BPost失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("修改BPost")
    @PostMapping("bPost/update")
    @ResponseBody
    //@RequiresPermissions("bPost:update")
    public FebsResponse updateBPost(BPost bPost) throws FebsException {
        try {
            this.bPostService.updateBPost(bPost);
            return new FebsResponse().success();
        } catch (Exception e) {
            String message = "修改BPost失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PostMapping("bPost/excel")
    @ResponseBody
    //@RequiresPermissions("bPost:export")
    public void export(QueryRequest queryRequest, BPost bPost, HttpServletResponse response) throws FebsException {
        try {
            List<BPost> bPosts = this.bPostService.findBPosts(queryRequest, bPost).getRecords();
            ExcelKit.$Export(BPost.class, response).downXlsx(bPosts, false);
        } catch (Exception e) {
            String message = "导出Excel失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}
