/*
 * Copyright 2023 Kotools S.A.S.U.
 * Use of this source code is governed by the MIT license.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    id("kotools.types.base")
    id("kotools.types.multiplatform")
}

repositories.mavenCentral()

dependencies {
    commonMainImplementation(platform(libs.kotlin.bom))
    commonTestImplementation(libs.kotlin.test)
}

tasks.withType<KotlinCompile>().configureEach {
    javaPackagePrefix = "kotools.types.internal"
}