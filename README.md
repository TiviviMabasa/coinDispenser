# READ ME... #

### Getting you started ###

This is a Coin Dispenser project.

#Build Project
>I used Java 11 to build this project
> Simple extract the tar/zip project into your specified directory 
> Update **application-dev.yml with the correct DB details. As follows<br />
> Create MySQL database as follows as I was running it on my local Database
> schema named: coin_dispenser_oltp
> username: root
> password: root
> <br/>
> _**$mvn clean install**_
Run
>/home/tivivi/IdeaProjects/coinDispenser/target/demo-0.0.1-SNAPSHOT.jar
 [INFO] 
> java -jar -Dspring.profiles.active=dev target/demo-0.0.1-SNAPSHOT.jar

# Application Properties
spring.profiles.active=local
spring.server.port=8080
spring.app.name=Coin Dispenser
spring.datasource.jdbcUrl=jdbc:mysql://localhost:3306/coin_dispenser_oltp?useSSL=false&sslmode=none&allowPublicKeyRetrieval=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

# Sql Commands to create the schema,table and add data
#Create Schema
CREATE DATABASE `coin_dispenser_oltp`;

#Create Table
CREATE TABLE `item` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2089 DEFAULT CHARSET=latin1;

#Insert Data
INSERT INTO `coin_dispenser_oltp`.`item` (`id`, `price`, `name`) VALUES ('1', '20', 'Coke');
INSERT INTO `coin_dispenser_oltp`.`item` (`id`, `price`, `name`) VALUES ('2', '10', 'Sprite');
INSERT INTO `coin_dispenser_oltp`.`item` (`id`, `price`, `name`) VALUES ('3', '15', 'Fanta');
INSERT INTO `coin_dispenser_oltp`.`item` (`id`, `price`, `name`) VALUES ('4', '35', 'Grape');

#End points to test
>GetAllItems
>http://localhost:8080/coinDispenser/displayProducts/
> This API will return all the items that are sold with their price and name
# selectProduct and get change
>http://localhost:8080/coinDispenser/selectProduct-change/?selectedProduct=3&numberOfCoins=0&numberOfCoins=0&numberOfCoins=0&numberOfCoins=3
>This API will calculate the number of coins needed to make change of an amount 
>The return type is the CoinBundle containing the number of coins needed to make change, and the total which is the change
>You can use PostMan to test the above APIs when you want to see the implementation
>
>HAPPY CODING AND ENJOY TESTING MY PROJECT
>Thank You