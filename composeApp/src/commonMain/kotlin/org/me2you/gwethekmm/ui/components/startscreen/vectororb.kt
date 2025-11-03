package org.me2you.gwethekmm.ui.components.startscreen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import org.me2you.gwethekmm.ui.theme.AccentA
import org.me2you.gwethekmm.ui.theme.AccentB
import org.me2you.gwethekmm.ui.theme.SoftLav
import kotlin.math.*

@Composable
fun VectorOrb(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition()

    // ✳️ Animate orbital phase (slow motion)
    val orbitPhase by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(16000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    // ✳️ Animate pulsation of smaller body
    val pulse by transition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height

        // Centers and radii
        val basePrimary = Offset(w * 0.48f, h * 0.53f)
        val baseSecondary = Offset(w * 0.62f, h * 0.46f)
        val mainRadius = min(w, h) * 0.33f
        val secondaryRadius = mainRadius * 0.55f * pulse

        // ✳️ Orbital drift offset
        val orbitRadius = mainRadius * 0.12f
        val angleRad = PI / 180 * orbitPhase

        val orbitOffset = Offset(
            (cos(angleRad) * orbitRadius).toFloat(),
            (sin(angleRad) * orbitRadius * 0.7f).toFloat()
        )

        val primaryCenter = basePrimary + orbitOffset
        val secondaryCenter = baseSecondary - orbitOffset

        // --- 1) Background gradient light ---
        drawRect(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    AccentB.copy(alpha = 0.0f),
                    AccentB.copy(alpha = 0.08f),
                    AccentA.copy(alpha = 0.12f),
                    Color.Transparent
                ),
                startX = 0f,
                endX = w
            ),
            topLeft = Offset(0f, h * 0.3f),
            size = Size(w, h * 0.4f)
        )

        // --- 2) Cosmic halo ---
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(SoftLav.copy(alpha = 0.25f), Color.Transparent),
                center = primaryCenter,
                radius = mainRadius * 2.5f
            ),
            radius = mainRadius * 2.4f,
            center = primaryCenter
        )

        // --- 3) Main planet ---
        drawOval(
            brush = Brush.radialGradient(
                colors = listOf(Color(0xFF0B0710), Color(0xFF19052A)),
                center = primaryCenter,
                radius = mainRadius
            ),
            topLeft = Offset(primaryCenter.x - mainRadius, primaryCenter.y - mainRadius),
            size = Size(mainRadius * 2f, mainRadius * 2f)
        )

        // --- 4) Secondary glowing body ---
        drawOval(
            brush = Brush.radialGradient(
                colors = listOf(Color(0xFFE6F7FF).copy(alpha = 0.75f), Color.Transparent),
                center = secondaryCenter,
                radius = secondaryRadius * 1.4f
            ),
            topLeft = Offset(secondaryCenter.x - secondaryRadius, secondaryCenter.y - secondaryRadius),
            size = Size(secondaryRadius * 2f, secondaryRadius * 2f)
        )

        drawOval(
            brush = Brush.radialGradient(
                colors = listOf(Color(0xFFEEF7FF), Color(0xFFBDB1EA).copy(alpha = 0.4f)),
                center = secondaryCenter,
                radius = secondaryRadius
            ),
            topLeft = Offset(secondaryCenter.x - secondaryRadius, secondaryCenter.y - secondaryRadius),
            size = Size(secondaryRadius * 2f, secondaryRadius * 2f)
        )

        // --- 5) Contact bridge (now reactive) ---
        val distance = primaryCenter.minus(secondaryCenter).getDistance()
        val proximity = 1f - (distance / (mainRadius * 2.5f)).coerceIn(0f, 1f)
        val bridgeGlow = 0.25f + (0.35f * proximity)

        val bridgeCenter = Offset(
            (primaryCenter.x + secondaryCenter.x) / 2,
            (primaryCenter.y + secondaryCenter.y) / 2
        )

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color(0xFFDBD3FF).copy(alpha = bridgeGlow + 0.15f),
                    Color.Transparent
                ),
                center = bridgeCenter,
                radius = secondaryRadius * (1.5f + 0.5f * proximity)
            ),
            radius = secondaryRadius * (1.4f + 0.5f * proximity),
            center = bridgeCenter
        )

        // --- 6) Back ring ---
        val backRing = Rect(
            left = primaryCenter.x - mainRadius * 1.7f,
            top = primaryCenter.y - mainRadius * 0.8f,
            right = primaryCenter.x + mainRadius * 1.7f,
            bottom = primaryCenter.y + mainRadius * 0.8f
        )
        drawArc(
            color = AccentA.copy(alpha = 0.18f),
            startAngle = 200f,
            sweepAngle = 130f,
            useCenter = false,
            topLeft = Offset(backRing.left, backRing.top),
            size = Size(backRing.width, backRing.height),
            style = Stroke(width = mainRadius * 0.13f, cap = StrokeCap.Round)
        )

        // --- 7) Front luminous ring ---
        val frontRing = Rect(
            left = primaryCenter.x - mainRadius * 1.7f,
            top = primaryCenter.y - mainRadius * 0.6f,
            right = primaryCenter.x + mainRadius * 1.7f,
            bottom = primaryCenter.y + mainRadius * 0.6f
        )
        drawArc(
            brush = Brush.horizontalGradient(listOf(AccentB, AccentA)),
            startAngle = 40f,
            sweepAngle = 120f,
            useCenter = false,
            topLeft = Offset(frontRing.left, frontRing.top),
            size = Size(frontRing.width, frontRing.height),
            style = Stroke(width = mainRadius * 0.11f, cap = StrokeCap.Round)
        )

        // --- 8) Contact star ---
        val contactPoint = Offset(
            bridgeCenter.x + secondaryRadius * 0.15f,
            bridgeCenter.y - secondaryRadius * 0.2f
        )
        val crossLen = max(4f, mainRadius * 0.05f)
        drawLine(
            color = Color(0xFFF6FAFF).copy(alpha = 0.9f),
            start = Offset(contactPoint.x - crossLen, contactPoint.y),
            end = Offset(contactPoint.x + crossLen, contactPoint.y),
            strokeWidth = 2.5f,
            cap = StrokeCap.Round
        )
        drawLine(
            color = Color(0xFFF6FAFF).copy(alpha = 0.9f),
            start = Offset(contactPoint.x, contactPoint.y - crossLen),
            end = Offset(contactPoint.x, contactPoint.y + crossLen),
            strokeWidth = 2.5f,
            cap = StrokeCap.Round
        )

        // --- 9) Depth glow ---
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(AccentB.copy(alpha = 0.18f), Color.Transparent),
                center = primaryCenter.copy(
                    x = primaryCenter.x + mainRadius * 0.65f,
                    y = primaryCenter.y + mainRadius * 0.6f
                ),
                radius = mainRadius
            ),
            radius = mainRadius,
            center = primaryCenter.copy(
                x = primaryCenter.x + mainRadius * 0.65f,
                y = primaryCenter.y + mainRadius * 0.6f
            )
        )
    }
}
