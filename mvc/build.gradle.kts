plugins {
	war
	application
}

application {
	mainClass.set("link.hiroshisprojects.jackson.JacksonTester")
}

repositories {
	mavenCentral()
	jcenter()
}

val springmvc = "5.3.18"
dependencies {
	compileOnly("javax.servlet:javax.servlet-api:3.1.0")	
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
	implementation("org.apache.httpcomponents:httpclient:4.5.13")
	implementation("org.springframework:spring-webmvc:$springmvc")
	implementation("org.springframework:spring-web:$springmvc")
	implementation("com.fasterxml.jackson.core:jackson-core:2.13.3")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
	implementation("javax.servlet:jstl:1.2")
	implementation("org.hibernate.validator:hibernate-validator:6.2.0.Final")
}

tasks.named<Test>("test") {
	useJUnitPlatform()
}

tasks.war {
	archiveFileName.set("ROOT.war")
}
