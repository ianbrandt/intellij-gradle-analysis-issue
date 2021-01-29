import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm")
	kotlin("plugin.spring")
}

configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
}

tasks {
	withType<JavaCompile> {
		options.encoding = "iso-8859-1"
	}

	withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	withType<Test> {
		useJUnitPlatform()
		testLogging.showStandardStreams = true
	}
}
