configurations.all {
	@Suppress("UnstableApiUsage")
	resolutionStrategy.capabilitiesResolution
			.withCapability("org.springframework.boot:spring-boot-starter-logging") {
				val toBeSelected = candidates.firstOrNull {
					it.id.let { id ->
						id is ModuleComponentIdentifier && id.module == "spring-boot-starter-log4j2"
					}
				}
				if (toBeSelected != null) {
					select(toBeSelected)
				}
				because("use spring-boot-starter-log4j2 in place of spring-boot-starter-logging")
			}
}

dependencies {
	components.all(SpringLoggingCapability::class.java)
}

class SpringLoggingCapability : ComponentMetadataRule {

	override fun execute(context: ComponentMetadataContext) = context.details.run {
		if (id.group == "org.springframework.boot" && id.name == "spring-boot-starter-log4j2") {
			allVariants {
				withCapabilities {
					// Declare that spring-boot-starter-log4j2 provides
					// spring-boot-starter-logging capability
					addCapability("org.springframework.boot", "spring-boot-starter-logging", id.version)
				}
			}
		}
	}
}
