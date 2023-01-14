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
	/* servlet api */
	implementation("javax.servlet:javax.servlet-api:4.0.1")	
	implementation("javax.servlet:jstl:1.2")
	
	/* junit */
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.1")
	testImplementation("org.springframework:spring-test:5.3.15")
	testImplementation("org.mockito:mockito-core:3.11.2")

	/* httpclient for testing */
	implementation("org.apache.httpcomponents:httpclient:4.5.13")

	/* spring mvc */
	implementation("org.springframework:spring-webmvc:$springmvc")
	implementation("org.springframework:spring-web:$springmvc")

	/* jackson */
	implementation("com.fasterxml.jackson.core:jackson-core:2.13.3")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
	
	 /* validation */
	implementation("org.hibernate.validator:hibernate-validator:6.2.0.Final")

	/* aop */
	implementation("org.aspectj:aspectjweaver:1.9.7")

	/* logging */
	implementation("org.slf4j:slf4j-api:2.0.6")
	implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.19.0")
	implementation("org.apache.logging.log4j:log4j-core:2.19.0")
}

tasks.named<Test>("test") {
	useJUnitPlatform()
}

tasks.war {
	archiveFileName.set("ROOT.war")
}
