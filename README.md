# servlets-jdbc-ajax

1. change context.xml in Tomcat's conf directory.

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
		
2. deploy  servlets-jdbc-ajax.war 
3. open /servlets-jdbc-ajax/api/init for create necessary tables
4. open /servlets-jdbc-ajax and try to find users
