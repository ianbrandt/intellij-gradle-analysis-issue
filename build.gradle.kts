import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL

group = "com.ianbrandt"
version = "0.0.1-SNAPSHOT"

tasks {
    named<Wrapper>("wrapper") {
        gradleVersion = "6.8.1"
        distributionType = ALL
    }
}
