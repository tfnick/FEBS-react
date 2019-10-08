package cc.mrbird.febs.blog.service;

import cc.mrbird.febs.blog.entity.BPost;

import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author MrBird
 * @date 2019-10-08 13:23:23
 */
public interface IBPostService extends IService<BPost> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param bPost bPost
     * @return IPage<BPost>
     */
    IPage<BPost> findBPosts(QueryRequest request, BPost bPost);

    /**
     * 查询（所有）
     *
     * @param bPost bPost
     * @return List<BPost>
     */
    List<BPost> findBPosts(BPost bPost);

    /**
     * 新增
     *
     * @param bPost bPost
     */
    void createBPost(BPost bPost);

    /**
     * 修改
     *
     * @param bPost bPost
     */
    void updateBPost(BPost bPost);

    /**
     * 删除
     *
     * @param bPost bPost
     */
    void deleteBPost(BPost bPost);
}
