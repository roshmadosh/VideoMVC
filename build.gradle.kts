plugins {
	java
	war
}

repositories {
	mavenCentral()
	jcenter()
}

dependencies {

	compileOnly("javax.servlet:servlet-api:2.5")	
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
	implementation("org.apache.httpcomponents:httpclient:4.5.13")

}

tasks.named<Test>("test") {
	useJUnitPlatform()
}

tasks.war {
	archiveFileName.set("ROOT.war")
}
