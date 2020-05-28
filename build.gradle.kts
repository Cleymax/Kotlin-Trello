plugins {
    kotlin("jvm") version "1.3.71"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "fr.cleymax"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit:junit:4.13")
    api("com.google.code.gson:gson:2.8.6")
    api("org.apache.httpcomponents:httpclient:4.5.12")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    shadowJar {
        archiveClassifier.set("dist")
        minimize()
        mergeServiceFiles()
    }
    build {
        dependsOn(shadowJar)
    }
}

