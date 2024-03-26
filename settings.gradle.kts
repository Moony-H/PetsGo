pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = java.net.URI("https://devrepo.kakao.com/nexus/content/groups/public/") }

    }
}

rootProject.name = "PetsGo"
include(":app")
include(":feature:feed")
include(":core")
include(":core:common")
include(":core:kakao_login")
include(":feature:test_home")
