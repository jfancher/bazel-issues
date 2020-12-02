load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

JDK_BUILD = """
package(default_visibility = ["//visibility:public"])

java_runtime(
    name = "runtime",
    srcs = glob(["**"]),
)
"""

http_archive(
    name = "jdk15_macos",
    url = "https://download.java.net/java/GA/jdk15/779bf45e88a44cbd9ea6621d33e33db1/36/GPL/openjdk-15_osx-x64_bin.tar.gz",
    sha256 = "ab842c8c0953b816be308c098c1a021177a4776bef24da85b6bafbbd657c7e1a",
    strip_prefix = "jdk-15.jdk/Contents/Home",
    build_file_content = JDK_BUILD,
)

http_archive(
    name = "jdk15_linux",
    url = "https://download.java.net/java/GA/jdk15/779bf45e88a44cbd9ea6621d33e33db1/36/GPL/openjdk-15_linux-x64_bin.tar.gz",
    sha256 = "bb67cadee687d7b486583d03c9850342afea4593be4f436044d785fba9508fb7",
    strip_prefix = "jdk-15",
    build_file_content = JDK_BUILD,
)

http_archive(
    name = "jdk15_remote_java_tools_linux",
    sha256 = "01e6912f7638c2ada1149fcf52979102c06982732a82044d925fc454d31998d8",
    urls = [
        "https://mirror.bazel.build/bazel_java_tools/releases/javac11/v10.1/java_tools_javac11_linux-v10.1.zip",
        "https://github.com/bazelbuild/java_tools/releases/download/javac11_v10.1/java_tools_javac11_linux-v10.1.zip",
    ],
)

http_archive(
    name = "jdk15_remote_java_tools_darwin",
    sha256 = "6a258df035a756eb721855980d6dbdb11ef818d9d293740dd9327f9e2b018bcf",
    urls = [
        "https://mirror.bazel.build/bazel_java_tools/releases/javac11/v10.1/java_tools_javac11_darwin-v10.1.zip",
        "https://github.com/bazelbuild/java_tools/releases/download/javac11_v10.1/java_tools_javac11_darwin-v10.1.zip",
    ],
)
