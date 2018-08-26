java_library(
    name = "repro",
    srcs = ["Bug.java"],
    deps = [":dep_import"],
)

java_library(
    name = "non_repro",
    srcs = ["Bug.java"],
    deps = [":dep"],
)

java_library(
    name = "annotation",
    srcs = ["BugAnnotation.java"],
)

java_library(
    name = "dep",
    srcs = ["BugDep.java"],
    deps = [":annotation"],
)

java_import(
    name = "dep_import",
    jars = [":libdep.jar"],
    deps = [":annotation"],
)
