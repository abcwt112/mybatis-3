package test.mapper;

import org.apache.ibatis.annotations.*;
import test.model.User;

import java.util.List;

public interface UserMapper {
    @Delete({
            "delete from user",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into user (user_id, user_name, ",
            "real_name, email, ",
            "creator_uid, modifier_uid, ",
            "created_at, updated_at, ",
            "del)",
            "values (#{userId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
            "#{realName,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
            "#{creatorUid,jdbcType=INTEGER}, #{modifierUid,jdbcType=INTEGER}, ",
            "#{createdAt,jdbcType=TIMESTAMP}, #{updatedAt,jdbcType=TIMESTAMP}, ",
            "#{del,jdbcType=BIT})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(User record);

    int insertSelective(User record);

    @Select({
            "select",
            "id, user_id, user_name, real_name, email, creator_uid, modifier_uid, created_at, ",
            "updated_at, del",
            "from user",
            "where id = #{id,jdbcType=INTEGER} and del = 0"
    })
    @ResultMap("test.mapper.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    @Update({
            "update user",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "user_name = #{userName,jdbcType=VARCHAR},",
            "real_name = #{realName,jdbcType=VARCHAR},",
            "email = #{email,jdbcType=VARCHAR},",
            "creator_uid = #{creatorUid,jdbcType=INTEGER},",
            "modifier_uid = #{modifierUid,jdbcType=INTEGER},",
            "created_at = #{createdAt,jdbcType=TIMESTAMP},",
            "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
            "del = #{del,jdbcType=BIT}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    @Select({
            "select",
            "id, user_id, user_name, real_name, email, creator_uid, modifier_uid, created_at, ",
            "updated_at, del",
            "from user",
            "where user_id = #{userId,jdbcType=INTEGER} and del=0"
    })
    @ResultMap("test.mapper.UserMapper.BaseResultMap")
    User findByUserId(int userId);

    @Select({
            "select",
            "id, user_id, user_name, real_name, email, creator_uid, modifier_uid, created_at, ",
            "updated_at, del",
            "from user",
            "where del=0"
    })
    @ResultMap("test.mapper.UserMapper.BaseResultMap")
    List<User> selectAll();

}