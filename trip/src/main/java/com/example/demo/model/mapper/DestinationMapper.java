package com.example.demo.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.demo.model.Destination;

@Mapper
public interface DestinationMapper {
	@Select("SELECT * FROM destination")
	List<Destination> getAllDestinations();

	// 다른 메서드들도 @Select 등을 사용하여 SQL 문을 매핑할 수 있습니다.
	// ...
}
