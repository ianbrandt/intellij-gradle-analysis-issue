pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        jcenter()
    }
}

rootProject.name = "intellij-gradle-analysis-issue"

include("spring-boot-module")
