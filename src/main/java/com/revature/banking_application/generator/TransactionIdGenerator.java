package com.revature.banking_application.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TransactionIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		Connection connection = session.connection();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select max(transactionID) as Id from AccountTransaction");
			
			if(rs.next()) {
				int id = rs.getInt(1)+105;
				Integer randInteger = (int) (Math.random() * 1000);
				String result = "" + new Integer(id).toString() + randInteger.toString();
				Long generatedId = Long.valueOf(result);
				return generatedId;
							
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
