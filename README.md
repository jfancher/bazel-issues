# bazel-issues - java_proto_library provider inconsistency

The `JavaInfo` provider for a `java_proto_library` is missing `transitive_source_jars` (even for
its direct sources, which _are_ included in `source_jars`).

```console
$ bazel version
Build label: 3.4.1
Build target: bazel-out/k8-opt/bin/src/main/java/com/google/devtools/build/lib/bazel/BazelServer_deploy.jar
Build time: Tue Jul 14 06:27:53 2020 (1594708073)
Build timestamp: 1594708073
Build timestamp as int: 1594708073

$ bazel build :example_java_proto_sources && cat bazel-bin/example_java_proto_sources.sources.txt
[...]
sources for <target //:example_java_proto>
source_jars: <generated file example_proto-speed-src.jar>

$ bazel build :example_java_sources && cat bazel-bin/example_java_sources.sources.txt
[...]
sources for <target //:example_java>
source_jars: <generated file libexample_java-src.jar>
transitive_source_jars: <generated file libexample_java-src.jar>
```
