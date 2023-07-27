apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(mapOf("path" to ":core")))
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.onboardingDomain))

}