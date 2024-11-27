plugins {
  alias(libs.plugins.kotlin)
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

tasks {
  test {
    useJUnitPlatform()
  }
}
