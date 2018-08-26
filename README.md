# bazel-issues - java_library transitive dep issue

```console
$ bazel version
Build label: 0.16.1
Build target: bazel-out/darwin-opt/bin/src/main/java/com/google/devtools/build/lib/bazel/BazelServer_deploy.jar
Build time: Mon Aug 13 13:42:50 2018 (1534167770)
Build timestamp: 1534167770
Build timestamp as int: 1534167770

$ bazel build --javacopt="-Werror" //:repro
INFO: Analysed target //:repro (0 packages loaded).
INFO: Found 1 target...
ERROR: [...]/bazel-issues/BUILD:1:1: Building librepro.jar (1 source file) failed (Exit 1)
warning: unknown enum constant E.FIRST
  reason: class file for example.BugAnnotation$E not found
error: warnings found and -Werror specified
[...]
FAILED: Build did NOT complete successfully

$ bazel run @embedded_jdk//:bin/javac -- \
  -cp "bazel-bin/libdep1.jar:bazel-bin/libdep2.jar:bazel-bin/libannotation.jar" \
  -Werror \
  Bug.java
(ok)
```
