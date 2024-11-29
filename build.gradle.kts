plugins {
  alias(libs.plugins.kotlin)
  alias(libs.plugins.kotlinx.kover)
  alias(libs.plugins.dokka)
}

group = properties["nemo.group"]!!
version = properties["nemo.version"]!!

dependencies {
  implementation(libs.bundles.api)
  testImplementation(libs.bundles.test)
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(libs.versions.java.get())
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
}
