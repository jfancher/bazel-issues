# bazel-issues - plugin+distinct_host_configuration

`--plugin` and `--distinct_host_configuration=false` do not work well together.

```console
$ bazel version
Build label: 0.16.1
Build target: bazel-out/darwin-opt/bin/src/main/java/com/google/devtools/build/lib/bazel/BazelServer_deploy.jar
Build time: Mon Aug 13 13:42:50 2018 (1534167770)
Build timestamp: 1534167770
Build timestamp as int: 1534167770

$ bazel build --plugin=//:ExampleCheck //:ExampleConsumer
INFO: Analysed target //:ExampleConsumer (0 packages loaded).
INFO: Found 1 target...
ERROR: [...]/bazel-issues/BUILD:1:1: Building libExampleConsumer.jar (1 source file) failed (Exit 1)
ExampleConsumer.java:5: error: [ExampleCheck] Don't call this
        "test".getBytes();
[...]
FAILED: Build did NOT complete successfully

$ bazel build --distinct_host_configuration=false --plugin=//:ExampleCheck //:ExampleConsumer
[...]/bazel-issues/BUILD:6:1: in java_plugin rule //:ExampleCheck: cycle in dependency graph:
    //:ExampleConsumer
.-> //:ExampleCheck [self-edge]
`--
```
