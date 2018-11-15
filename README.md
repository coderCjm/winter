# winter

## eureka

- 服务治理和发现的中间件

- 集群启动步骤   
   
   1. mvn package
   2. 将打包生成的 eureka-server.jar 复制到两个文件夹  
   3. 在第一个文件夹 执行 java -jar eureka-server.jar --spring.profiles.active=peer1
   4. 在第二个文件夹 执行 java -jar eureka-server.jar --spring.profiles.active=peer2
   5. 浏览器打开 http://localhost:9080 或者 http://localhost:9070 查看

## zipkin

- 服务链路追踪器

- 启动步骤

   1. java -jar zipkin.jar
   2. 浏览器打开 http://localhost:9411

## autumn

- 服务生产者

- 启动步骤

   1. mvn clean install
   2. 进入 autumncore 执行 mvn package
   3. 将打包生成的 autumn.jar 复制到两个文件夹 
   3. 在第一个文件夹 执行 java -jar autumn.jar --spring.profiles.active=peer1
   4. 在第二个文件夹 执行 java -jar autumn.jar --spring.profiles.active=peer2

## summer

- 服务消费者

- 启动步骤

   1. 编译器直接执行 main 方法
   2. 浏览器 http://localhost:9082/user/get?id=3 查看各个项目打印的日志

## moon

- 供消费者使用的中间jar包