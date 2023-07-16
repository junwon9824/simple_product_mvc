package com.example.demo.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Plan;

@Repository
public class PlanDaoImpl implements PlanDao {
	private final SqlSession sqlSession;

	public PlanDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Plan getPlanById(int id) {
		return sqlSession.selectOne("PlanMapper.getPlanById", id);
	}

	public List<Plan> getAllPlans() {
		return sqlSession.selectList("PlanMapper.getAllPlans");
	}

	public void createPlan(Plan plan) {
		sqlSession.insert("PlanMapper.createPlan", plan);
	}

	public void updatePlan(Plan plan) {
		sqlSession.update("PlanMapper.updatePlan", plan);
	}

	public void deletePlan(int id) {
		sqlSession.delete("PlanMapper.deletePlan", id);
	}

	// 추가적인 메서드들
	// ...
}
