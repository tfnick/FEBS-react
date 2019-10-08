package cc.mrbird.febs.blog.service.impl;

import cc.mrbird.febs.blog.entity.BPost;
import cc.mrbird.febs.blog.dao.BPostMapper;
import cc.mrbird.febs.blog.service.IBPostService;
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
 * @date 2019-10-08 13:23:23
 */
@Data
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BPostServiceImpl extends ServiceImpl<BPostMapper, BPost> implements IBPostService {

    @Autowired
    private BPostMapper bPostMapper;

    @Override
    public IPage<BPost> findBPosts(QueryRequest request, BPost bPost) {
        LambdaQueryWrapper<BPost> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<BPost> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BPost> findBPosts(BPost bPost) {
	    LambdaQueryWrapper<BPost> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBPost(BPost bPost) {
        this.save(bPost);
    }

    @Override
    @Transactional
    public void updateBPost(BPost bPost) {
        this.saveOrUpdate(bPost);
    }

    @Override
    @Transactional
    public void deleteBPost(BPost bPost) {
        LambdaQueryWrapper<BPost> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
