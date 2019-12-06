package plotDemo.scripts

import jetbrains.letsPlot.GlobalSettings
import jetbrains.letsPlot.geom.geom_point
import jetbrains.letsPlot.ggplot
import jetbrains.letsPlot.ggtitle
import jetbrains.letsPlot.sampling.sampling_random
import jetbrains.letsPlot.scale.scale_size_area
import plotDemo.SwingJfxFrontendContext
import kotlin.math.PI
import kotlin.math.sin

object Sampling {
    @JvmStatic
    fun main(args: Array<String>) {
        GlobalSettings.frontendContext = SwingJfxFrontendContext()
        val dat = mapOf<String, Any>(
            "x" to (0..100).map { it * 2 * PI / 100 },
            "y" to (0..100).map { sin(it * 2 * PI / 100) }
        )

        val p = ggplot(dat) +
                geom_point(data=dat, sampling = sampling_random(40)) { x = "x"; y = "y"} +
                scale_size_area(max_size = 70, guide = "none")

        p.show()
    }
}