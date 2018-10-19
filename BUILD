config_setting(
    name = "foo",
    define_values = {
        "foo": "yes"
    },
)

config_setting(
    name = "not_foo",
    define_values = {
        "foo": "no"
    },
)

alias(
    name = "alias_foo",
    actual = select({
        ":foo": ":foo",
        "//conditions:default": ":not_foo",
    }),
)

genrule(
    name = "example",
    outs = ["example.txt"],
    cmd = select({
        ":alias_foo": "echo 'foo' > $@",
        "//conditions:default": "echo 'not foo' > $@",
    }),
)