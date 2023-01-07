plugins {
	java
	war
}

repositories {
	mavenCentral()
	jcenter()
}

dependencies {

	providedCompile("javax.servlet:java.servlet-api:3.1.0")

	testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")

}

tasks.named<Test>("test") {
	useJUnitPlatform()
}
