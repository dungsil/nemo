plugins {
  alias(libs.plugins.kotlin)
  alias(libs.plugins.kotlin.spring)
  alias(libs.plugins.kotlinx.kover)
  alias(libs.plugins.dokka)

  alias(libs.plugins.spring.boot)
  alias(libs.plugins.spring.dependencyManagement)
}

group = properties["nemo.group"]!!
version = properties["nemo.version"]!!

sourceSets {
  create("testIntegration") {
    val baseDir = "src/test-integration"

    kotlin.srcDirs("$baseDir/kotlin")
    resources.srcDirs("$baseDir/resources")

    compileClasspath += main.get().output + test.get().output
    runtimeClasspath += main.get().output + test.get().output
  }
}

configurations {
  named("testIntegrationImplementation") {
    extendsFrom(implementation.get())
    extendsFrom(testImplementation.get())
  }
  named("testIntegrationRuntimeOnly") {
    extendsFrom(testRuntimeOnly.get())
  }
}

dependencies {
  implementation(libs.bundles.api)
  developmentOnly(libs.bundles.dev)
  testImplementation(libs.bundles.test)
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(libs.versions.java.get())
  }
}

kotlin {
  compilerOptions {
    freeCompilerArgs = properties["kotlin.compiler.free-args"].toString().split(" ")
  }
}

kover {
  reports {
    verify {
      rule {
        minBound(80) // 최소 커버리지 범위
      }
    }
  }
}

dokka {
  dokkaSourceSets.main {
    includes.from("src/main/kdoc/modules.md", "src/main/kdoc/packages.md")

    sourceLink {
      remoteUrl(properties["nemo.repository.source-url"] as String)
      remoteLineSuffix.set(properties["nemo.repository.line-suffix"] as String)
    }
  }

  pluginsConfiguration {
    html {
      customStyleSheets.from("src/main/kdoc/custom-styles.css")
    }
  }
}

tasks {
  test {
    useJUnitPlatform()
  }

  val testIntegration = create<Test>("testIntegration") {
    group = test.get().group
    useJUnitPlatform()

    sourceSets.named("testIntegration").get().let {
      classpath = it.runtimeClasspath
      testClassesDirs = it.output.classesDirs
    }
  }

  check {
    dependsOn(testIntegration)
  }
}
