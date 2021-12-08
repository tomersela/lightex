plugins {
    java
    `java-library`
    `maven-publish`
    id("com.intershop.gradle.javacc") version "4.0.0"
}

group = "com.tomersela"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit", "junit", "4.12")
}

javacc {
    // configuration container for all javacc configurations
    configs {
        register("lightexGrammar") {
            inputFile = file("src/main/jj/lightexGrammar.jj")
            packageName = "com.tomersela.lightex.parser"
            javaCCVersion = "7.0.10"
            outputDir = file("src/main/java/")
            staticParam = "false"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("lightex") {
            from(components["java"])
        }
    }
}
