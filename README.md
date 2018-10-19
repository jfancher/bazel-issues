# bazel-issues - aliasing config_setting

Documentation claims config_setting may not be aliased, but it can.

```console
$ bazel version
Build label: 0.18.0
Build target: bazel-out/darwin-opt/bin/src/main/java/com/google/devtools/build/lib/bazel/BazelServer_deploy.jar
Build time: Mon Oct 15 08:33:10 2018 (1539592390)
Build timestamp: 1539592390
Build timestamp as int: 1539592390

$ bazel build --define=foo=yes //:example && cat bazel-genfiles/example.txt
[...]
foo

$ bazel build //:example && cat bazel-genfiles/example.txt
[...]
not foo
```
