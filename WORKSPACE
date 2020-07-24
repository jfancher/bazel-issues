load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "rules_jvm_external",
    sha256 = "d85951a92c0908c80bd8551002d66cb23c3434409c814179c0ff026b53544dab",
    strip_prefix = "rules_jvm_external-3.3",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/3.3.zip",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    name = "maven",
    artifacts = [
        "com.google.guava:guava:29.0-jre",
    ],
    repositories = [
        "https://jcenter.bintray.com/",
    ],
)
