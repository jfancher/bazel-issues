java_library(
    name = "ExampleConsumer",
    srcs = ["ExampleConsumer.java"],
)

java_plugin(
    name = "ExampleCheck",
    srcs = ["ExampleCheck.java"],
    deps = [
        ":auto_service",
        "@error_prone//jar",
        "@guava//jar",
    ],
)

java_library(
    name = "auto_service",
    exported_plugins = [":auto_service_plugin"],
    visibility = ["//visibility:public"],
    exports = ["@auto_service//jar"],
    runtime_deps = ["@guava//jar"],
)

java_plugin(
    name = "auto_service_plugin",
    processor_class = "com.google.auto.service.processor.AutoServiceProcessor",
    deps = [
        "@auto_common//jar",
        "@auto_service//jar",
        "@guava//jar",
    ],
)
