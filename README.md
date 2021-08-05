# spring-boot-sample

## spring initializr
```
# download from web
wget 'https://start.spring.io/starter.zip?type=gradle-project&language=java&bootVersion=2.5.3&baseDir=sample&groupId=com.example&artifactId=sample&name=sample&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.sample&packaging=jar&javaVersion=11&dependencies=web,lombok,mybatis,validation,quartz,actuator' -O sample-project.zip

unzip sample-project.zip

# use vscode extension
```

## run
```
cd sample
./gradlew bootRun

# hot reload
./gradlew build --continuous
./gradlew bootRun
```

## vscode extension
+ Language Support for Java(TM) by Red Hat
