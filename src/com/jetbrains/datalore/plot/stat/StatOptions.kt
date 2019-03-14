package com.jetbrains.datalore.plot.stat

import com.jetbrains.datalore.plot.Options
import com.jetbrains.datalore.plot.StatKind

class StatOptions(
    val kind: StatKind,
    val mapping: Options = Options.empty(),
    val parameters: Options = Options.empty()
)