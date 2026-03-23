plugins {
	`java-library`
	`maven-publish`
	`checkstyle`
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.orbital3d"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
	withSourcesJar()
	withJavadocJar()
}

checkstyle {
	configFile = File("${project.rootDir}/checkstyle.xml")
}

repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation("org.springframework:spring-context:6.1.6")
	implementation("org.springframework.data:spring-data-jpa:3.2.5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher:5.10.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
