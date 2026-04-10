plugins {
	`java-library`
	`maven-publish`
	`checkstyle`
	`jacoco`
	id("com.diffplug.spotless") version "8.4.0"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.owasp.dependencycheck") version "12.2.0"
}

group = "org.codebreaker"
version = "1.0-RELEASE"

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

// Ensure code is formatted before build
tasks.named("build") {
	dependsOn("spotlessApply")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}

// Configure OWASP Dependency Check tasks with different CVSS thresholds for different build types
tasks.register("dependencyCheckRelease", org.owasp.dependencycheck.gradle.tasks.Analyze::class.java) {
    dependencyCheck {
        failBuildOnCVSS.set(9.0f)
    }
}

tasks.register("dependencyCheckCI", org.owasp.dependencycheck.gradle.tasks.Analyze::class.java) {
    dependencyCheck {
        failBuildOnCVSS.set(3.0f)
    }
}
