val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.20"
    //kaptを使用する
    kotlin("kapt") version "1.6.20"
    id("org.flywaydb.flyway") version "8.5.0"
    id("co.uzzu.dotenv.gradle") version "2.0.0"
}

buildscript {
    dependencies {
        classpath("org.flywaydb:flyway-mysql:8.4.4")
    }
}

flyway {
    url = env.fetchOrNull("DB_URL")
    user = env.fetchOrNull("DB_USER")
    password = env.fetchOrNull("DB_PASS")
    schemas = arrayOf(env.fetchOrNull("DB_NAME"))
    createSchemas = true
    locations = arrayOf("filesystem:db/migration")
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation("mysql:mysql-connector-java:8.0.25")
    testImplementation("org.flywaydb:flyway-core:8.4.4")
    testImplementation("org.flywaydb:flyway-mysql:8.4.4")
    implementation("io.github.cdimascio:dotenv-kotlin:6.2.2")
    implementation("io.ktor:ktor-server-thymeleaf:$ktor_version")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    implementation("org.jetbrains.exposed:exposed-core:0.37.3")
    implementation("org.jetbrains.exposed:exposed-dao:0.37.3")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.37.3")
    //追加したプラグ
    //implementation("androidx.room:room-runtime:2.4.2")
    //implementation("androidx.room:room-ktx:2.4.2")
    //kapt("androidx.room:room-compiler:2.4.2")
}