plugins {
	`java-library`
	`maven-publish`
	`checkstyle`
	id("com.diffplug.spotless") version "6.20.0"
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

spotless {
	java {
		// Use the Eclipse formatter profile included at repository root
		// point to workspace-level formatter file (one level up from domain)
		googleJavaFormat()
		target("src/main/java/**/*.java", "src/test/java/**/*.java")
		trimTrailingWhitespace()
		endWithNewline()
	}
}

repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation("org.springframework:spring-context:6.1.6")
	implementation("org.springframework.data:spring-data-jpa:3.2.5")
	testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
	testImplementation("org.mockito:mockito-core:5.5.0")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// Ensure formatting is checked as part of 'check'
tasks.named("check") {
    dependsOn("spotlessCheck")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
