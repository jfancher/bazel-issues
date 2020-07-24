def _list_sources_impl(ctx):
    lines = ["sources for %s" % ctx.attr.lib]
    info = ctx.attr.lib[JavaInfo]
    
    for jar in info.source_jars:
        lines.append("source_jars: %s" % jar)

    for jar in info.transitive_source_jars.to_list():
        lines.append("transitive_source_jars: %s" % jar)

    lines.append("")
    ctx.actions.write(ctx.outputs.out, "\n".join(lines))

list_sources = rule(
    implementation = _list_sources_impl,
    attrs = {
        "lib": attr.label(providers = [JavaInfo]),
    },
    outputs = {
        "out": "%{name}.sources.txt",
    },
)
