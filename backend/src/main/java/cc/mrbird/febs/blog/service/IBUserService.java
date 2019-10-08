package cc.mrbird.febs.blog.service;

import cc.mrbird.febs.blog.entity.BUser;

import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author MrBird
 * @date 2019-10-08 13:23:19
 */
public interface IBUserService extends IService<BUser> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param bUser bUser
     * @return IPage<BUser>
     */
    IPage<BUser> findBUsers(QueryRequest request, BUser bUser);

    /**
     * 查询（所有）
     *
     * @param bUser bUser
     * @return List<BUser>
     */
    List<BUser> findBUsers(BUser bUser);

    /**
     * 新增
     *
     * @param bUser bUser
     */
    void createBUser(BUser bUser);

    /**
     * 修改
     *
     * @param bUser bUser
     */
    void updateBUser(BUser bUser);

    /**
     * 删除
     *
     * @param bUser bUser
     */
    void deleteBUser(BUser bUser);
}
