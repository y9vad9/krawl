import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    id("multiplatform-convention")
    id("com.vanniktech.maven.publish")
}

kotlin {
    explicitApi = ExplicitApiMode.Strict

    jvm()
    js {
        browser()
        nodejs()
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    pom {
        url.set("https://github.com/y9vad9/brawlstars-api")
        inceptionYear.set("2024")

        licenses {
            license {
                name.set("The MIT License")
                url.set("https://opensource.org/licenses/MIT")
                distribution.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer {
                id.set("y9vad9")
                name.set("Vadym Yaroshchuk")
                url.set("https://github.com/y9vad9/")
            }
        }

        scm {
            url.set("https://github.com/y9vad9/brawlstars-api")
            connection.set("scm:git:git://github.com/y9vad9/brawlstars-api.git")
            developerConnection.set("scm:git:ssh://git@github.com/y9vad9/brawlstars-api.git")
        }

        issueManagement {
            system.set("GitHub Issues")
            url.set("https://github.com/y9vad9/brawlstars-api/issues")
        }
    }

    signAllPublications()
}
