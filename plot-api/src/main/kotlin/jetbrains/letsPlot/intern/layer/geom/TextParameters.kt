/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.letsPlot.intern.layer.geom

import jetbrains.datalore.plot.config.Option
import jetbrains.letsPlot.intern.Options
import jetbrains.letsPlot.intern.layer.OptionsCapsule

interface TextParameters : OptionsCapsule {
    val labelFormat: String?

    override fun seal() = Options.of(
        Option.Geom.Text.LABEL_FORMAT to labelFormat
    )
}
