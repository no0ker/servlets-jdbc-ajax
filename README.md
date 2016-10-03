# servlets-jdbc-ajax

1. change context.xml 

\<Resource 
		name="jdbc/postgres" 
		auth="Container" 
		type="javax.sql.DataSource"
    maxTotal="100" 
		maxIdle="30" 
		maxWaitMillis="10000"
    username="postgres" 
		password="12345" 
		driverClassName="org.postgresql.Driver"
		url="jdbc:postgresql://localhost:5432/postgres"/>
		
