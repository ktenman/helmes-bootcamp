## Configuration
* import bootcamp.sql into **MySQL**
```xml
<beans:bean class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close" id="dataSource">
    <beans:property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <beans:property name="url" value="jdbc:mysql://localhost:3306/bootcamp" />
    <beans:property name="username" value="root" />
    <beans:property name="password" value="bootcamp" />
</beans:bean>
```
---
## Quick start
Build Maven project and run embedded tomcat server
* Under 'Maven Projects' choose:
```
Plugins > tomcat7 > tomxat7:run > execute 'Run Maven Build'
```
---
## Step-by-step YouTube video
[![Step-by-step YouTube video](http://img.youtube.com/vi/OHhyifO_2EU/0.jpg)](http://www.youtube.com/watch?v=OHhyifO_2EU)