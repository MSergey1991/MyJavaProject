Для сборки проекта использовал Maven (все зависимости указаны в pom.xml);

При выполнении проекта использовал:
 jdk 1.8.0_231,
 MySQL 8.0.16,
 Apache Tomcat 9.0.27(необходимо указать war artifact).
 
 
 Для тестирования проекта необходимо в классе SpringConfiguration.java изменить url, login, password и (при необходимости подключения другой базы connector) для базы данных.
 
 
 
 Таблицу в БД необходимо создать заранее:
 
 CREATE TABLE tasks
(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    assignee varchar(45),
    summary varchar(300),
    startDate DATE,
    endDate DATE
);
CREATE UNIQUE INDEX task_id_uindex ON task (id);
 
