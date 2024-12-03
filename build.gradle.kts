plugins {
  idea

  alias(libs.plugins.kotlin)
  alias(libs.plugins.kotlin.jpa)
  alias(libs.plugins.kotlin.spring)
  alias(libs.plugins.kotlinx.kover)
  alias(libs.plugins.dokka)

  alias(libs.plugins.spring.boot)
  alias(libs.plugins.spring.dependencyManagement)

  alias(libs.plugins.hibernate)
}

group = properties["nemo.group"]!!
version = properties["nemo.version"]!!

configurations {
  // https://github.com/Kotlin/dokka/issues/3472#issuecomment-2244628081
  matching { it.name.startsWith("dokka") }.configureEach {
    resolutionStrategy.eachDependency {
      if (requested.group.startsWith("com.fasterxml.jackson")) {
        useVersion(libs.versions.dokka.jackson.get())
      }
    }
  }

  compileOnly {
    extendsFrom(annotationProcessor.get())
  }
}

dependencies {
  annotationProcessor(libs.bundles.annotation)
  implementation(libs.bundles.api)
  runtimeOnly(libs.bundles.runtime)
  developmentOnly(libs.bundles.dev)
  testImplementation(libs.bundles.test)
}

idea {
  module {
    isDownloadJavadoc = true
    isDownloadSources = true
  }
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

// kotlin-spring
allOpen {
  annotations(
    "jakarta.persistence.Entity",
    "jakarta.persistence.Embeddable",
    "jakarta.persistence.MappedSuperclass",
  )
}

kover {
  reports {
    verify {
      rule {
        minBound(80) // 최소 커버리지 범위
      }
    }

    filters {
      excludes {
        // 클래스 제외
        classes("nemo.**\$log\$*")

        // 상속된 클래스 제외
        inheritedFrom(
          "kotlin.Exception",
          "java.lang.Exception",
        )

        // 어노테이션 제외
        annotatedBy(
          "org.springframework.context.annotation.Configuration",
        )
      }
    }
  }
}

dokka {
  dokkaSourceSets.main {
    includes.from("docs/kdoc/modules.md", "docs/kdoc/packages.md")

    sourceLink {
      remoteUrl(properties["nemo.repository.source-url"] as String)
      remoteLineSuffix.set(properties["nemo.repository.line-suffix"] as String)
    }
  }

  pluginsConfiguration {
    html {
      customStyleSheets.from("docs/kdoc/custom-styles.css")
    }
  }
}

hibernate {
  enhancement {
    enableDirtyTracking = true
    enableLazyInitialization = true
    enableAssociationManagement = true
  }
}

tasks {
  test {
    val mockitoAgent = classpath.find { it.name.startsWith("mockito-core") }!!.absolutePath

    useJUnitPlatform()
    systemProperties(
      "spring.profiles.active" to "test"
    )
    jvmArgs(
      "-Xshare:off",
      "-javaagent:$mockitoAgent",
    )
  }
}
