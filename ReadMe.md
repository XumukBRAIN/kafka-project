Гайд по запуску Kafka на Windows (официальный сайт: `https://kafka.apache.org/downloads`)

* Открыть папку с Kafka, далее config -> server.properties -> ищем строку `log.dirs=tmp/kafka-logs` и меняем её на `log.dirs=C:/Kafka/tmp/kafka-logs` `1?`;
* По аналогии также сделать в файле `zookeeper.properties` в строке `dataDir`. Пример: `dataDir=c:/Kafka/zookeeper-data`;
* Открыть CMD от имени администратора;
* Перейти в папку `2?` с Kafka и ввести команду `.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties`;
* Открыть еще раз CMD от имени администратора, также перейти в папку с Kafka и ввести команду `.\bin\windows\kafka-server-start.bat .\config\server.properties`;
* Kafka запущена!

`1?` - C:/Kafka - это МОЙ путь, где лежит Kafka;

`2?` - Чтобы в CMD перейти в какую-то папку надо использовать команду `cd C:\Ваша директория`.