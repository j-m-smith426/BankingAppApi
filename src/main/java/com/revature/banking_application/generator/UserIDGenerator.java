package com.revature.banking_application.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		Connection connection = session.connection();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select max(user_id) as Id from Users");
			
			if(rs.next()) {
				int id = rs.getInt(1)+13;
				id = id%1000000;
				String result = "" + new Integer(id).toString();
				Long generatedId = Long.valueOf(result);
				System.out.println(generatedId);
				return generatedId;
							
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
