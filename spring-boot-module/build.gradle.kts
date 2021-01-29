plugins {
	`kotlin-library-convention`
	`spring-log4j2-logging`
	id("org.springframework.boot") version "2.4.2"
}

springBoot {
	mainClass.set("com.ianbrandt.issues.IntellijGradleAnalysisIssueApplicationKt")
}

dependencies {
	implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-log4j2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
