/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package frontendContextDemo.scripts

import frontendContextDemo.ScriptInBatikContext
import jetbrains.datalore.base.values.Color
import jetbrains.letsPlot.geom.geom_point
import jetbrains.letsPlot.ggsize
import jetbrains.letsPlot.label.ggtitle
import jetbrains.letsPlot.lets_plot
import jetbrains.letsPlot.scale.scale_color_discrete
import jetbrains.letsPlot.scale.scale_x_discrete
import jetbrains.letsPlot.scale.xlim
import jetbrains.letsPlot.theme

object ScaleLimitsDiscrete {
    @JvmStatic
    fun main(args: Array<String>) {
        ScriptInBatikContext.eval("Scale limits (discrete)") {

            val dat = mapOf(
                "x" to ('a'..'h')
            )

            val settings = theme()
                .axisLine_blank()
                .axisTitleY_blank().axisTextY_blank().axisTicksY_blank()
                .legendPosition_bottom() +
                    ggsize(500, 150)

            val p = lets_plot(dat) +
                    geom_point(size = 10.0) { x = "x"; color = "x" } +
                    settings
            p.show()

            val limits = ('a'..'d').toList()
            (p + scale_color_discrete(limits = limits, naValue = Color.WHITE) +
                    ggtitle("scale_color_discrete(limits = limits)")).show()

            (p + scale_x_discrete(limits = limits) +
                    ggtitle("scale_x_discrete(limits = limits)")).show()

            // `xlim` is the other way to do the same
            (p + xlim(limits) +
                    ggtitle("xlim(limits)")).show()
        }
    }
}