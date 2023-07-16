package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Destination;

@Repository
public class DestinationDaoImpl implements DestinationDao {
	private final SqlSession sqlSession;

	@Autowired
	public DestinationDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Destination> getAllDestinations() {
		return sqlSession.selectList("getAllDestinations");
	}

	@Override
	public Destination getDestinationById(int id) {
		return sqlSession.selectOne("getDestinationById", id);
	}

	@Override
	public void createDestination(Destination destination) {
		sqlSession.insert("createDestination", destination);
	}

	@Override
	public void updateDestination(Destination destination) {
		sqlSession.update("updateDestination", destination);
	}

	@Override
	public void deleteDestination(int id) {
		sqlSession.delete("deleteDestination", id);
	}

	// 추가적인 메서드들
	// ...
}
