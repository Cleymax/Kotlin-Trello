plugins {
    kotlin("jvm") version "1.3.71"
    id("com.github.johnrengelman.shadow") version "5.2.0"
    maven
    `maven-publish`
    signing
}

group = "fr.cleymax"
version = "1.0.1"

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit:junit:4.13")
    testImplementation("org.mockito:mockito-core:2.+")
    api("com.google.code.gson:gson:2.8.6")
    api("org.apache.httpcomponents:httpclient:4.5.12")
    api("org.apache.httpcomponents:httpmime:4.5.12")
}

java {
    withJavadocJar()
    withSourcesJar()
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
    withType(JavaCompile::class.java) {
        options.encoding = "UTF-8"
    }
    build {
        dependsOn(shadowJar)
    }
    javadoc {
        title = ""
        if (JavaVersion.current().isJava9Compatible) {
            (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
        }
    }
}

publishing {
    repositories {
        maven {
            val releasesRepoUrl = when {
                project.hasProperty("local") -> "$buildDir/repos/releases"
                project.hasProperty("m2") -> "${System.getProperty("user.home")}/.m2/"
                project.hasProperty("repo") -> property("repo") as String
                else -> "https://repo.cleymax.fr/repository/maven-releases/"
            }
            val snapshotsRepoUrl = when {
                project.hasProperty("local") -> "$buildDir/repos/snapshots"
                project.hasProperty("m2") -> "${System.getProperty("user.home")}/.m2/"
                project.hasProperty("repo") -> property("repo") as String
                else -> "https://repo.cleymax.fr/repository/maven-snapshots/"
            }
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)

            if (url.toString().startsWith("http")) {
                if (hasProperty("repo_username") && hasProperty("repo_password")) {
                    credentials {
                        username = property("repo_username") as String
                        password = property("repo_password") as String
                    }
                }
            }
        }
    }

    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "trelloapi-kotlin"
            from(components["java"])
            pom {
                packaging = "jar"
                name.set("TrelloAPI-Kotlin")
                description.set("Kotlin Wrapper for Trello")
                url.set("https://github.com/Cleymax/TrelloAPI-Kotlin/")

                developers {
                    developer {
                        id.set("cleymax")
                        name.set("Clément P. (Cleymax)")
                        email.set("contact@cleymax.fr")
                        timezone.set("+2")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/Cleymax/TrelloAPI-Kotlin.git")
                    developerConnection.set("scm:git:ssh://github.com/Cleymax/TrelloAPI-Kotlin.git")
                    url.set("https://github.com/Cleymax/TrelloAPI-Kotlin/")
                }
            }
        }
    }

    if (!project.hasProperty("local") && !project.hasProperty("m2")) {
        signing {
            sign(publishing.publications["mavenJava"])
        }
    }
}
