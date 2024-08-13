plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.10.2")
    // https://mvnrepository.com/artifact/io.rest-assured/rest-assured
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")

}

tasks.test {
    useJUnitPlatform()
    useTestNG()
}