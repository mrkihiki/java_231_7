plugins {
    id("java")
    id("io.freefair.lombok") version "8.10.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    implementation("io.freefair.gradle:lombok-plugin:8.4")
    implementation("com.google.code.gson:gson:2.11.0")
//    compileOnly ('org.projectlombok:lombok:1.18.34')
//    annotationProcessor ('org.projectlombok:lombok:1.18.34')
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}