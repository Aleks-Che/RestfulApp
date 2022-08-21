# Руководство

### Развертка бд
Ожидается что postgresql уже стоит и настроен
Приложение ожидает существование пользователя restapp с паролем restapp, его нужно создать. Либо изменить эти параметры в файле "application.properties".
В случае успешного подключения к бд происходит обновление в соотвествии с скриптами `/RestfulApp/src/main/resources/db/migration`

### Запуск приложения
Для запуска приложения нужен установленный maven. 
Скачать можно по ссылке https://maven.apache.org/download.cgi
Инструкция по установке https://maven.apache.org/install.html

Собираем приложение 
`mvn clean install`
`mvn clean package`

Запускаем приложение
`mvn spring-boot:run`