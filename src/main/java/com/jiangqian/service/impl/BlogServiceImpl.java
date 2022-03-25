package com.jiangqian.service.impl;

import com.jiangqian.entity.Blog;
import com.jiangqian.mapper.BlogMapper;
import com.jiangqian.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JQQ
 * @since 2022-03-25
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
