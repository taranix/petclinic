#What it is?
This is simple pet clinic application for managing pets, owners anc visits for a single click where few veterinars 
works.


## What is needed to be done:

* Implement option to create visit for specified veterinary 
* Vists should be to specifed full hour (fe 8:00-16:00)
* On home screen you should implement full view of upcomming visits for each veterinary for today in its own table.
You should show only veterinary names which has some appoitments for today.
Fe:

Veterinay name1:

| time | Owner name | Pet name |

Veterinay name5:

| time | Owner name | Pet name |





#Technical details

#### Running petclinic locally
```
	./mvnw jetty:run-war
```

You can then access petclinic here: [http://localhost:8080/](http://localhost:8080/)



#### Database configuration

In its default configuration, Petclinic uses an in-memory database (HSQLDB) which
gets populated at startup with data.
A similar setups is provided for MySql and PostgreSQL in case a persistent database configuration is needed.
To run petclinic locally using persistent database, it is needed to run with profile defined in main pom.xml file.


#####This is not needed but if you wish: 
For MySQL database, it is needed to run with 'MySQL' profile defined in main pom.xml file.

```
./mvnw jetty:run-war -P MySQL
```

Before do this, would be good to check properties defined in MySQL profile inside pom.xml file.

```
<properties>
    <jpa.database>MYSQL</jpa.database>
    <jdbc.driverClassName>com.mysql.cj.jdbc.Driver</jdbc.driverClassName>
    <jdbc.url>jdbc:mysql://localhost:3306/petclinic?useUnicode=true</jdbc.url>
    <jdbc.username>root</jdbc.username>
    <jdbc.password>petclinic</jdbc.password>
</properties>
```      

You could start MySql locally with whatever installer works for your OS, or with docker:

```
docker run --name mysql-petclinic -e MYSQL_ROOT_PASSWORD=petclinic -e MYSQL_DATABASE=petclinic -p 3306:3306 mysql:5.7.8
```

For PostgreSQL database, it is needed to run with 'PostgreSQL' profile defined in main pom.xml file.

```
./mvnw jetty:run-war -P PostgreSQL
```

Before do this, would be good to check properties defined in PostgreSQL profile inside pom.xml file.

```
<properties>
    <jpa.database>POSTGRESQL</jpa.database>
    <jdbc.driverClassName>org.postgresql.Driver</jdbc.driverClassName>
    <jdbc.url>jdbc:postgresql://localhost:5432/petclinic</jdbc.url>
    <jdbc.username>postgres</jdbc.username>
    <jdbc.password>petclinic</jdbc.password>
</properties>
```
You could alos start PostgreSQL locally with whatever installer works for your OS, or with docker:

```
docker run --name postgres-petclinic -e POSTGRES_PASSWORD=petclinic -e POSTGRES_DB=petclinic -p 5432:5432 -d postgres:9.6.0
```

