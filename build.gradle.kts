plugins {
    alias(libs.plugins.loomVersion)
}

fun gradleProperty(key: String) = providers.gradleProperty(key).get()

repositories {
    mavenCentral()

    exclusiveContent {
        forRepository {
            maven {
                name = "ModrinthMaven"
                url = uri("https://api.modrinth.com/maven")
            }
        }
        filter {
            includeGroup("maven.modrinth")
        }
    }
}

dependencies {
    minecraft("com.mojang:minecraft:${libs.versions.minecraft.get()}")
    implementation(libs.bundles.fabricModding)
    implementation(libs.bundles.macaws)
    implementation(libs.bundles.miscCore)
    implementation(libs.bundles.miscDeps)
    implementation(libs.bundles.nonCore)
    implementation(libs.bundles.serverOpt)
}

tasks.processResources {
    val version = version
    inputs.property("version", version)

    filesMatching("fabric.mod.json") {
        expand("version" to version)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 25
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks.jar {
    val projectName = project.name
    inputs.property("projectName", projectName)

    from("LICENSE") {
        rename { "${it}_$projectName" }
    }
}
