plugins {
    id(conventions.multiplatform.library)
}

dependencies {
    commonMainApi(projects.brawlstarsCore)
    commonMainApi(projects.brawlifyCore)
}
