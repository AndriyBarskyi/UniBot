# UniBot
In order to use the project you should:

1. Create an empty database accordingly to the application.properties file or you can change DB configurations to match your existing empty DB
2. Run the project, it will create tables in the database schema
3. Change "spring.jpa.hibernate.ddl-auto=create" to 'spring.jpa.hibernate.ddl-auto=update" in application.properties
4. Change "spring.sql.init.mode=never" to "spring.sql.init.mode=always" in order to fill the database with initial data
5. Run the project again, the DB will be filled with data and change back "spring.sql.init.mode=always" to "spring.sql.init.mode=never", so it will not try to insert data the next time 
6. After all, you will be able to use the project
