package com.hz.community.dao;

import com.hz.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper { //首页查询功能

    //offset:每一页的起始行号  limit:每一页最多显示多少条数据
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);//分页查询数据

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId); //查询帖子的行数

}
