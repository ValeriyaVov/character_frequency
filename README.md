# Character Frequency Calculator

### Описание проекта

Character Frequency Calculator - это RESTful веб-сервис, предназначенный для вычисления частоты встречи символов в заданной строке. API позволяет пользователям отправлять строку в запросе и получать в ответе JSON-объект с отсортированным списком символов и количеством их вхождений в заданную строку.
### Инструкция по запуску

Для сборки и запуска приложения на вашей рабочей станции должна стоять JDK версии не ниже 17, а путь к директории JDK должен быть прописан в переменной среды JAVA_HOME.

1. Выполните из директории проекта character_frequency команду `./mvnw clean package`. В директории character_frequency/target должны появиться файлы character_frequency-1.0.0.jar и character_frequency-1.0.0-spring-boot.jar.
2. Выполните команду `java -jar target/character_frequency-1.0.0-spring-boot.jar`.
3. Зайдите в браузер и перейдите по адресу http://localhost:8080/swagger-ui/index.html, чтобы открыть интерфейс Swagger с описанием взаимодействия с API, либо выполните запрос по адресу http://localhost:8080/v3/api-docs, чтобы получить описание API в формате JSON.
4. Если порт 8080 уже занят другим приложением, просто поменяйте значение настройки `server.port` в директории character_frequency/src/main/resources/application.properties на значение свободного порта.
