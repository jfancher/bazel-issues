java_library(
    name = "repro",
    srcs = ["Bug.java"],
    deps = [":dep1"],
)

java_library(
    name = "dep1",
    srcs = ["BugDep1.java"],
    deps = [":dep2"],
)

java_library(
    name = "dep2",
    srcs = ["BugDep2.java"],
    deps = [":annotation"],
)

java_library(
    name = "annotation",
    srcs = ["BugAnnotation.java"],
)
