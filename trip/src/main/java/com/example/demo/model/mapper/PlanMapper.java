package com.example.demo.model.mapper;

import com.example.demo.model.Plan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlanMapper {

	@Select("SELECT * FROM plans")
	List<Plan> getAllPlans();

	@Select("SELECT * FROM plans WHERE id = #{id}")
	Plan getPlanById(@Param("id") int id);

	@Insert("INSERT INTO plans (name, description, user_id, created_at) VALUES (#{name}, #{description}, #{userId}, #{createdAt})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void createPlan(Plan plan);

	@Update("UPDATE plans SET name = #{name}, description = #{description} WHERE id = #{id}")
	void updatePlan(Plan plan);

	@Delete("DELETE FROM plans WHERE id = #{id}")
	void deletePlan(@Param("id") int id);

	// 추가적인 메서드들
	// ...
}
