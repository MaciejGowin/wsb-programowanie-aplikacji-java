#### Compile
`javac LineCounter.java`

#### Create jar
`jar --create --file line-counter.jar LineCounter.class FileUtils.class`

`jar cf line-counter.jar LineCounter.class FileUtils.class`

#### Run with jar-based classpath
`java -cp line-counter.jar LineCounter`

#### Run as jar
`java -jar line-counter.jar`

> no main manifest attribute, in test.jar

#### Create jar with main class definition
`jar --create --file line-counter.jar --manifest MANIFEST.MF LineCounter.class FileUtils.class`

`jar --create --file line-counter.jar --main-class LineCounter LineCounter.class FileUtils.class`

#### Run as jar
`java -jar line-counter.jar`
