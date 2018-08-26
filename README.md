# bazel-issues - java_import transitive dep issue

`java_import` deps are not included on compilation classpath, causing classfile
warnings.

```console
$ bazel version
Build label: 0.16.1
Build target: bazel-out/darwin-opt/bin/src/main/java/com/google/devtools/build/lib/bazel/BazelServer_deploy.jar
Build time: Mon Aug 13 13:42:50 2018 (1534167770)
Build timestamp: 1534167770
Build timestamp as int: 1534167770

# java_library -> java_import -> java_library triggers issue
$ bazel build --javacopt="-Werror" //:repro
INFO: Analysed target //:repro (0 packages loaded).
INFO: Found 1 target...
ERROR: [...]/bazel-issues/BUILD:1:1: Building librepro.jar (1 source file) failed (Exit 1)
warning: unknown enum constant BugAnnotation$E.FIRST
  reason: class file for example.BugAnnotation$E not found
[...]
FAILED: Build did NOT complete successfully

# java-library -> java_library -> java_library does not
$ bazel build --javacopy="-Werror" //:non_repro
INFO: Analysed target //:non_repro (0 packages loaded).
INFO: Found 1 target...
Target //:non_repro up-to-date:
  bazel-bin/libnon_repro.jar
[...]
INFO: Build completed successfully, 5 total actions

# direct javac invocation is fine
$ javac -cp "bazel-bin/libdep.jar:bazel-bin/libannotation.jar" -Werror Bug.java
```
