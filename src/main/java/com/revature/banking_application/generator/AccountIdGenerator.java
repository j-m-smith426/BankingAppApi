package com.revature.banking_application.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class AccountIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		Connection connection = session.connection();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select max(accountID) as Id from Bank_Account");
			
			if(rs.next()) {
				int id = rs.getInt(1)+100;
				if(id < 1000000000)
					id += 1000000000;
				
				Long generatedId = (long) id;
				return generatedId;
							
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
