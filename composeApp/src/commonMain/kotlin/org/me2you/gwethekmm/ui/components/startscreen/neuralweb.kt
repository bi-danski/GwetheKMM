package org.me2you.gwethekmm.ui.components.startscreen

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import org.me2you.gwethekmm.ui.theme.AccentA
import org.me2you.gwethekmm.ui.theme.AccentB
import kotlin.math.*

@Composable
fun NeuralWeb(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "neuralWeb")

    val pulse by transition.animateFloat(
        initialValue = 0.85f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(20000, easing = LinearEasing)
        ),
        label = "rotation"
    )

    val shimmerShift by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "shimmerShift"
    )

    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val center = Offset(w / 2, h / 2)
        val radius = min(w, h) * 0.45f

        val nodeCount = 16
        val nodes = mutableListOf<Offset>()

        // --- Generate circular node positions ---
        for (i in 0 until nodeCount) {
            val angle = (i * (360f / nodeCount) + rotation) % 360f
            val r = radius * (0.8f + sin(angle * (PI / 180)).toFloat() * 0.1f)
            val x = center.x + cos(angle * (PI / 180)).toFloat() * r
            val y = center.y + sin(angle * (PI / 180)).toFloat() * r
            nodes.add(Offset(x, y))
        }

        // --- Background glow field ---
        drawRect(
            brush = Brush.verticalGradient(
                listOf(
                    Color(0xFF0B0620),
                    Color(0xFF160628),
                    Color(0xFF240733)
                ),
                startY = 0f,
                endY = h
            ),
            size = size
        )

        // --- Connecting lines (synapses) ---
        val accent1 = AccentA.copy(alpha = 0.9f)
        val accent2 = AccentB.copy(alpha = 0.9f)

        for (i in nodes.indices) {
            for (j in i + 1 until nodes.size) {
                val dist = sqrt(
                    (nodes[i].x - nodes[j].x).pow(2) + (nodes[i].y - nodes[j].y).pow(2)
                )

                if (dist < radius * 0.7f) {
                    val alpha = ((1f - dist / (radius * 0.7f)) * 0.35f * pulse).coerceIn(0f, 1f)
                    drawLine(
                        brush = Brush.linearGradient(
                            listOf(
                                accent1.copy(alpha = alpha),
                                accent2.copy(alpha = alpha * 0.8f)
                            ),
                            start = nodes[i],
                            end = nodes[j]
                        ),
                        start = nodes[i],
                        end = nodes[j],
                        strokeWidth = 1.2f
                    )
                }
            }
        }

        // --- Shimmering neuron nodes ---
        for (n in nodes) {
            val shimmerAlpha = 0.6f + (0.3f * abs(sin(shimmerShift * PI * 2))).toFloat()
            val shimmerScale = 1f + 0.1f * sin(shimmerShift * PI * 2).toFloat()

            drawCircle(
                brush = Brush.radialGradient(
                    listOf(
                        accent1.copy(alpha = shimmerAlpha),
                        Color.Transparent
                    ),
                    center = n,
                    radius = 10f * pulse * shimmerScale
                ),
                radius = 4f * pulse * shimmerScale,
                center = n
            )
        }

        // --- Central thinking core ---
        val coreR = radius * 0.12f * (1f + 0.15f * sin((rotation * 2) * (PI / 180)).toFloat())
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.9f),
                    accent1.copy(alpha = 0.6f),
                    Color.Transparent
                ),
                center = center,
                radius = (coreR * 3.5f)
            ),
            radius = (coreR * 3.5f),
            center = center
        )

        // --- Gentle outer halo ---
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    accent2.copy(alpha = 0.15f),
                    Color.Transparent
                ),
                center = center,
                radius = radius * 1.5f * pulse
            ),
            radius = radius * 1.5f * pulse,
            center = center
        )
    }
}
