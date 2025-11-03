package org.me2you.gwethekmm.ui.components.startscreen

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import org.me2you.gwethekmm.ui.theme.AccentA
import org.me2you.gwethekmm.ui.theme.AccentB
import kotlin.math.*

@Composable
fun VectorMind(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height

        val center = Offset(w * 0.5f, h * 0.65f)
        val coreRadius = min(w, h) * 0.12f

        // --- Background vertical gradient glow ---
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(Color(0xFF0B0620), Color(0xFF160628), Color(0xFF240733)),
                startY = 0f,
                endY = h
            ),
            size = size
        )

        // --- Upward energy beams ---
        for (i in -2..2) {
            val xOffset = i * (coreRadius * 0.6f)
            val beamAlpha = 0.15f + (0.15f * (1f - abs(i.toFloat()) / 2f))
            drawLine(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        AccentB.copy(alpha = 0f),
                        AccentA.copy(alpha = beamAlpha),
                        AccentB.copy(alpha = 0f)
                    )
                ),
                start = Offset(center.x + xOffset, center.y),
                end = Offset(center.x + xOffset, center.y - h * 0.45f),
                strokeWidth = coreRadius * 0.25f,
                cap = StrokeCap.Round
            )
        }

        // --- Expanding concentric rings ---
        val ringCount = 5
        for (i in 1..ringCount) {
            val radius = coreRadius * (1.3f + i * 0.6f)
            val alpha = 0.18f - (i * 0.025f)
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        AccentA.copy(alpha = alpha),
                        Color.Transparent
                    ),
                    center = center,
                    radius = radius
                ),
                radius = radius,
                center = center,
                style = Stroke(width = 2f)
            )
        }

        // --- Central glowing core ---
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(AccentA, AccentB, Color(0xFF2C0F3F)),
                center = center,
                radius = coreRadius * 1.6f
            ),
            radius = coreRadius * 1.6f,
            center = center
        )

        // --- Core highlight (thought ignition) ---
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color.White.copy(alpha = 0.9f), Color.Transparent),
                center = center.copy(y = center.y - coreRadius * 0.3f),
                radius = coreRadius * 1.2f
            ),
            radius = coreRadius * 1.2f,
            center = center.copy(y = center.y - coreRadius * 0.3f)
        )

        // --- Upward energy flare (launch) ---
        val flareHeight = h * 0.45f
        val flareWidth = coreRadius * 2.2f
        val flarePath = Path().apply {
            moveTo(center.x - flareWidth / 2, center.y)
            cubicTo(
                center.x - flareWidth / 3, center.y - flareHeight * 0.35f,
                center.x + flareWidth / 3, center.y - flareHeight * 0.35f,
                center.x + flareWidth / 2, center.y
            )
        }
        drawPath(
            path = flarePath,
            brush = Brush.verticalGradient(
                colors = listOf(AccentA.copy(alpha = 0.4f), Color.Transparent),
                startY = center.y,
                endY = center.y - flareHeight
            ),
            style = Stroke(width = 3f, cap = StrokeCap.Round)
        )

        // --- Top sparkle (enlightenment point) ---
        val sparkleY = center.y - flareHeight * 1.05f
        val sparkleCenter = Offset(center.x, sparkleY)
        val sparkleR = coreRadius * 0.2f

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color.White.copy(alpha = 0.95f), Color.Transparent),
                center = sparkleCenter,
                radius = sparkleR * 3f
            ),
            radius = sparkleR * 3f,
            center = sparkleCenter
        )

        // --- Cross-star at the top ---
        drawLine(
            color = Color.White,
            start = Offset(sparkleCenter.x - sparkleR, sparkleCenter.y),
            end = Offset(sparkleCenter.x + sparkleR, sparkleCenter.y),
            strokeWidth = 2f,
            cap = StrokeCap.Round
        )
        drawLine(
            color = Color.White,
            start = Offset(sparkleCenter.x, sparkleCenter.y - sparkleR),
            end = Offset(sparkleCenter.x, sparkleCenter.y + sparkleR),
            strokeWidth = 2f,
            cap = StrokeCap.Round
        )
    }
}




