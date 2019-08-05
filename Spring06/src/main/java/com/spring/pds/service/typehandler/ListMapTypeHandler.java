package com.spring.pds.service.typehandler;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.jdbc.support.nativejdbc.CommonsDbcpNativeJdbcExtractor;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

public class ListMapTypeHandler implements TypeHandler<Object> {

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		
		/*if(list == null) {
			ps.setNull(i, java.sql.Types.INTEGER);
			return;
		}*/
		
		List<String> list = (List<String>) parameter;
		
		
		//db 연결 : myBatis가 db연결에 사용하는 클래스
		CommonsDbcpNativeJdbcExtractor extractor = new CommonsDbcpNativeJdbcExtractor();
		Connection conn = extractor.getNativeConnection(ps.getConnection());
		
		//myBatis 배열조작
		ArrayDescriptor desc = ArrayDescriptor.createDescriptor("FILE_ARRAY", conn);
		
		//파라미터 값이 없을때 : file이 선택되지 않으면 list == null
		if(list == null || list.size() == 0 ) {
			ps.setArray(i, new ARRAY(desc, conn, new String[] { null } ));
			System.out.println("null인건데");
			return;
		}
		
		System.out.println(i + "" + parameter);
		
		String [] strings = new String[list.size()];
		for (int j = 0; j < strings.length; j++) {
			strings[j] = list.get(j);
		}
		
		parameter = new ARRAY(desc, conn, strings);
		
		ps.setArray(i, (oracle.sql.ARRAY) parameter);
		
		
	}

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		if(cs.wasNull()) {
			return null;
		} else {
			return cs.getString(columnIndex);
		}
	}

}
            