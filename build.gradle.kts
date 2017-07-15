import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

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
    withType<GradleBuild> {
        doLast {
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
    }
    withType<Kotlin2JsCompile> {
        kotlinOptions {
            outputFile = "$projectDir/web/output.js"
        }
    }
}