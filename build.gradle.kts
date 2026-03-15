/*
 * Copyright 2026 James Yox
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

@file:OptIn(ExperimentalWasmDsl::class)

import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.benmanes.versions)
    alias(libs.plugins.dokka)
    alias(libs.plugins.mavenpublish)
}

group = "dev.jamesyox"
version = "0.1.0-alpha.1"

repositories {
    mavenCentral()
}

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    autoCorrect = true
    config.from(files("$projectDir/detekt/config.yml"))

    dependencies {
        // detektPlugins(libs.detekt.library)
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xallow-contracts-on-more-functions")
        freeCompilerArgs.add("-opt-in=kotlin.contracts.ExperimentalContracts")
        freeCompilerArgs.add("-Xreturn-value-checker=full")
    }
    explicitApi()
    jvm {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }
    js {
        useEsModules()
        compilerOptions {
            target.set("es2015")
        }
        browser {
            testTask {
                useKarma {
                    useChromium()
                    useFirefox()
                }
            }
        }
        nodejs()
    }
    wasmJs {
        useEsModules()
        compilerOptions {
            target.set("es2015")
        }
        browser {
            testTask {
                useKarma {
                    useChromium()
                    useFirefox()
                }
            }
        }
        nodejs()
    }
    wasmWasi {
        nodejs()
    }

    // Native: https://kotlinlang.org/docs/native-target-support.html
    // Tier 1
    linuxX64()
    macosX64()
    macosArm64()
    iosSimulatorArm64()
    iosX64()
    // Tier 2
    linuxArm64()
    watchosSimulatorArm64()
    watchosX64()
    watchosArm32()
    watchosArm64()
    tvosSimulatorArm64()
    tvosX64()
    tvosArm64()
    iosArm64()
    // Tier 3
    mingwX64()

    sourceSets {
        all {
            languageSettings.enableLanguageFeature("ContextParameters")
        }
        commonMain
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        jsMain
        wasmJsMain
        jvmMain
        jvmTest {
            dependencies {
                implementation(libs.kotlinx.html)
            }
        }
        webMain {
            dependencies {
                implementation(libs.kotlinx.browser)
            }
        }
    }
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()
    coordinates(groupId = project.group.toString(), artifactId = project.name)
    pom {
        name = project.name
        description = "SVG Implementation in Kotlin as a DSL"
        url = "https://github.com/jamesyox/svg4k"

        licenses {
            license {
                name = "Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }

        developers {
            developer {
                name = "James Yox"
                id = "yoxjames"
                url = "https://www.jamesyox.dev"
            }
        }

        scm {
            connection = "scm:git:github.com/yoxjames/svg4k.git"
            developerConnection = "scm:git:ssh://github.com/yoxjames/svg4k.git"
            url = "https://github.com/yoxjames/svg4k"
        }
    }
}

ktlint {
    version.set("1.8.0")
}

tasks.register("allDetekt") {
    allprojects {
        this@register.dependsOn(tasks.withType<Detekt>())
    }
}
fun String.isNonStable(): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(this)
    return isStable.not()
}

tasks.dependencyUpdates {
    rejectVersionIf {
        candidate.version.isNonStable()
    }
}
