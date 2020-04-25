package com.galaxy.dao;

import com.galaxy.entity.Meeting;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * (Meeting)表数据库访问层
 *
 * @author ThrStones
 * @since 2020-04-24 08:12:45
 */
public interface MeetingDao extends BaseDao<Meeting> {

    @Select("<script>" +
            "select * from meeting " +
            "where 1=1 " +
            "<if test=\"title!=null and title!=''\">" +
            "<bind name=\"mTitle\" value=\"'%'+title+'%'\"/>" +
            " and title like #{mTitle}" +
            "</if>  order by id desc" +
            "</script>")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "startTime", property = "startTime"),
            @Result(column = "endTime", property = "endTime"),
            @Result(column = "title", property = "title"),
            @Result(column = "content", property = "content"),
            @Result(column = "address", property = "address"),
            @Result(column = "accountId", property = "account",
                    one=@One(select = "com.galaxy.dao.AccountDao.queryById",
                            fetchType = FetchType.EAGER))}
    )
    public List<Meeting> queryAllByPage(Meeting meeting);

    @Select("<script>" +
            "select count(*) from meeting " +
            "where 1=1 " +
            "<if test=\"title!=null and title!=''\">" +
            "<bind name=\"mTitle\" value=\"'%'+title+'%'\"/>" +
            " and title like #{mTitle}" +
            "</if>  order by id desc" +
            "</script>")
    public int queryTotalCount(Meeting meeting);

    @Insert("insert into meeting values (0, #{accountId}, #{startTime}, #{endTime}, #{title}, #{content}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Meeting meeting);

    @Select("select * from meeting where id=#{id}")
    public Meeting queryById(int id);

    /*
        private Account account;

    private Date startTime;

    private Date endTime;

    private String title;

    private String content;

    private String address;
     */
    @Update("update meeting set startTime=#{startTime},endTime=#{endTime},title=#{title},content=#{content},address=#{address} where id=#{id}")
    public int update(Meeting meeting);


}