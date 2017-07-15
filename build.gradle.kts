import org.jetbrains.kotlin.gradle.dsl.KotlinJsOptions

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin"))
    }
}

apply {
    plugin("kotlin2js")
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-js"))
}

tasks {
    "doLast"(GradleBuild::class) {
        configurations.compile.forEach {
            copy {
                includeEmptyDirs = false
                from(zipTree(it.absolutePath))
                into("$projectDir/web")
                include {
                    val path = it.path
                            path.endsWith(".js") && (path.startsWith("META-INF/resources/") || !path.startsWith("META-INF/"))
                }
            }
        }
    }
    "compileKotlin2Js" {
        val kotlinOptions = property("kotlinOptions") as KotlinJsOptions
        kotlinOptions.outputFile = "$projectDir/web/output.js"
    }
}


