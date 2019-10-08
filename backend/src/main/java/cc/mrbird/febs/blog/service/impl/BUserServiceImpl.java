package cc.mrbird.febs.blog.service.impl;

import cc.mrbird.febs.blog.entity.BUser;
import cc.mrbird.febs.blog.dao.BUserMapper;
import cc.mrbird.febs.blog.service.IBUserService;
import cc.mrbird.febs.common.domain.QueryRequest;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 *  Service实现
 *
 * @author MrBird
 * @date 2019-10-08 13:23:19
 */
@Data
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BUserServiceImpl extends ServiceImpl<BUserMapper, BUser> implements IBUserService {

    @Autowired
    private BUserMapper bUserMapper;

    @Override
    public IPage<BUser> findBUsers(QueryRequest request, BUser bUser) {
        LambdaQueryWrapper<BUser> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<BUser> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BUser> findBUsers(BUser bUser) {
	    LambdaQueryWrapper<BUser> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBUser(BUser bUser) {
        this.save(bUser);
    }

    @Override
    @Transactional
    public void updateBUser(BUser bUser) {
        this.saveOrUpdate(bUser);
    }

    @Override
    @Transactional
    public void deleteBUser(BUser bUser) {
        LambdaQueryWrapper<BUser> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
