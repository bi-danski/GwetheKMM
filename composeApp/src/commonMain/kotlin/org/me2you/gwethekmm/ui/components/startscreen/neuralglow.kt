//package org.me2you.gwethekmm.ui.components.startscreen
//
//import androidx.compose.animation.core.*
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.gestures.detectTapGestures
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.*
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.input.pointer.pointerInput
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import org.me2you.gwethekmm.ui.theme.AccentA
//import org.me2you.gwethekmm.ui.theme.AccentB
//import kotlin.math.*
//
//private fun Float.toRadians(): Double = (this * PI / 180.0)
//
//@Composable
//fun NeuralGlow(modifier: Modifier = Modifier) {
//    val transition = rememberInfiniteTransition(label = "neuralFlow")
//
//    val pulseAlpha by transition.animateFloat(
//        initialValue = 0.6f,
//        targetValue = 1f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(2400, easing = FastOutSlowInEasing),
//            repeatMode = RepeatMode.Reverse
//        ),
//        label = "pulseAlpha"
//    )
//
//    val corePulse by transition.animateFloat(
//        initialValue = 0.9f,
//        targetValue = 1.2f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(3000, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse
//        ),
//        label = "corePulse"
//    )
//
//    val rotationAngle by transition.animateFloat(
//        initialValue = 0f,
//        targetValue = 360f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(22000, easing = LinearEasing),
//            repeatMode = RepeatMode.Restart
//        ),
//        label = "rotationAngle"
//    )
//
//    val parallax by transition.animateFloat(
//        initialValue = 0.85f,
//        targetValue = 1.15f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(6000, easing = FastOutSlowInEasing),
//            repeatMode = RepeatMode.Reverse
//        ),
//        label = "parallax"
//    )
//
//    val particleDrift by transition.animateFloat(
//        initialValue = 0f,
//        targetValue = 360f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(8000, easing = LinearEasing),
//            repeatMode = RepeatMode.Restart
//        ),
//        label = "particleDrift"
//    )
//
//    var flareIntensity by remember { mutableFloatStateOf(0f) }
//    var rippleRadius by remember { mutableFloatStateOf(0f) }
//    var touchPoint by remember { mutableStateOf(Offset.Unspecified) }
//    val coroutine = rememberCoroutineScope()
//
//    val accent1 = AccentA.copy(alpha = 0.9f)
//    val accent2 = AccentB.copy(alpha = 0.9f)
//    val adaptiveGlow = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
//
//    val interactiveModifier = modifier.pointerInput(Unit) {
//        detectTapGestures { offset ->
//            touchPoint = offset
//            flareIntensity = 1f
//            rippleRadius = 0f
//            coroutine.launch {
//                for (i in 0..80) {
//                    rippleRadius = i * 12f
//                    flareIntensity = (1f - i / 90f).coerceAtLeast(0f)
//                    delay(8)
//                }
//                flareIntensity = 0f
//            }
//        }
//    }
//
//    Canvas(modifier = interactiveModifier) {
//        val w = size.width
//        val h = size.height
//        val center = Offset(w * 0.5f, h * 0.5f)
//        val maxR = min(w, h) * 0.45f
//
//        val neuronCount = 18
//        for (i in 0 until neuronCount) {
//            val baseAngle = (i.toFloat() / neuronCount) * 360f + rotationAngle
//            val startRadius = maxR * (0.7f + (i % 5) * 0.05f)
//            val controlRadius = maxR * 0.45f
//
//            val start = Offset(
//                center.x + cos(baseAngle.toRadians()).toFloat() * startRadius,
//                center.y + sin(baseAngle.toRadians()).toFloat() * startRadius
//            )
//            val control = Offset(
//                center.x + cos((baseAngle + 40).toRadians()).toFloat() * controlRadius,
//                center.y + sin((baseAngle - 30).toRadians()).toFloat() * controlRadius
//            )
//
//            val path = Path().apply {
//                moveTo(start.x, start.y)
//                quadraticTo(control.x, control.y, center.x, center.y)
//            }
//
//            drawPath(
//                path = path,
//                brush = Brush.horizontalGradient(
//                    listOf(
//                        accent2.copy(alpha = 0.15f * (pulseAlpha + flareIntensity)),
//                        accent1.copy(alpha = 0.6f * (pulseAlpha + flareIntensity))
//                    )
//                ),
//                style = Stroke(width = 1.8f)
//            )
//        }
//
//        val auraRadius = maxR * 1.4f * parallax
//        drawCircle(
//            brush = Brush.radialGradient(
//                colors = listOf(
//                    accent2.copy(alpha = 0.12f * pulseAlpha),
//                    accent1.copy(alpha = 0.08f * pulseAlpha),
//                    Color.Transparent
//                ),
//                center = center,
//                radius = auraRadius
//            )
//        )
//
//        val outerRadius = maxR * 0.12f * corePulse * (1f + flareIntensity * 0.4f)
//        drawCircle(
//            brush = Brush.radialGradient(
//                colors = listOf(
//                    accent1.copy(alpha = 0.55f * (pulseAlpha + flareIntensity)),
//                    accent2.copy(alpha = 0.25f * pulseAlpha),
//                    Color.Transparent
//                ),
//                center = center,
//                radius = outerRadius * 4f
//            )
//        )
//
//        val particleCount = 12
//        val driftR = maxR * 0.8f
//        for (i in 0 until particleCount) {
//            val angle = (i * (360f / particleCount)) + particleDrift
//            val orbitRadius = driftR * (0.6f + (i % 3) * 0.1f)
//            val x = center.x + cos(angle.toRadians()).toFloat() * orbitRadius
//            val y = center.y + sin((angle + i * 10).toRadians()).toFloat() * orbitRadius
//            val sizeFactor = 2.5f + (i % 3)
//            drawCircle(
//                color = Color.White.copy(alpha = 0.5f + 0.3f * pulseAlpha),
//                radius = sizeFactor,
//                center = Offset(x, y)
//            )
//        }
//
//        if (touchPoint != Offset.Unspecified && rippleRadius > 0f) {
//            val dist = hypot(touchPoint.x - center.x, touchPoint.y - center.y)
//            val t = (dist / (maxR * 1.5f)).coerceIn(0f, 1f)
//            val rippleColor = Color.hsv(
//                hue = 240f - (t * 140f),
//                saturation = 0.8f,
//                value = 1f
//            )
//
//            drawCircle(
//                brush = Brush.radialGradient(
//                    listOf(
//                        rippleColor.copy(alpha = 0.25f * flareIntensity),
//                        Color.Transparent
//                    ),
//                    center = touchPoint,
//                    radius = rippleRadius
//                ),
//                radius = rippleRadius,
//                center = touchPoint
//            )
//        }
//
//        drawCircle(
//            brush = Brush.radialGradient(
//                colors = listOf(
//                    Color.White.copy(alpha = 0.95f * (pulseAlpha + flareIntensity)),
//                    adaptiveGlow,
//                    Color.Transparent
//                ),
//                center = center,
//                radius = outerRadius * 2f
//            )
//        )
//    }
//}
package org.me2you.gwethekmm.ui.components.startscreen

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.me2you.gwethekmm.ui.theme.AccentA
import org.me2you.gwethekmm.ui.theme.AccentB
import kotlin.math.*

private fun Float.toRadians(): Double = (this * PI / 180.0)

@Composable
fun NeuralGlow(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "neuralFlow")

    val pulseAlpha by transition.animateFloat(
        initialValue = 0.6f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2400, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseAlpha"
    )

    val corePulse by transition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "corePulse"
    )

    val rotationAngle by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(22000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotationAngle"
    )

    val parallax by transition.animateFloat(
        initialValue = 0.85f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(6000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "parallax"
    )

    val particleDrift by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "particleDrift"
    )

    var flareIntensity by remember { mutableFloatStateOf(0f) }
    var rippleRadius by remember { mutableFloatStateOf(0f) }
    var touchPoint by remember { mutableStateOf(Offset.Unspecified) }
    val coroutine = rememberCoroutineScope()

    val accent1 = AccentA.copy(alpha = 0.9f)
    val accent2 = AccentB.copy(alpha = 0.9f)
    val adaptiveGlow = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)

    val interactiveModifier = modifier.pointerInput(Unit) {
        detectTapGestures { offset ->
            touchPoint = offset
            flareIntensity = 1f
            rippleRadius = 0f
            coroutine.launch {
                for (i in 0..80) {
                    rippleRadius = i * 12f
                    flareIntensity = (1f - i / 90f).coerceAtLeast(0f)
                    delay(8)
                }
                flareIntensity = 0f
            }
        }
    }

    Canvas(modifier = interactiveModifier) {
        val w = size.width
        val h = size.height
        val center = Offset(w * 0.5f, h * 0.5f)
        val maxR = min(w, h) * 0.45f

        // Neural connections
        val neuronCount = 18
        for (i in 0 until neuronCount) {
            val baseAngle = (i.toFloat() / neuronCount) * 360f + rotationAngle
            val startRadius = maxR * (0.7f + (i % 5) * 0.05f)
            val controlRadius = maxR * 0.45f

            val start = Offset(
                center.x + cos(baseAngle.toRadians()).toFloat() * startRadius,
                center.y + sin(baseAngle.toRadians()).toFloat() * startRadius
            )
            val control = Offset(
                center.x + cos((baseAngle + 40).toRadians()).toFloat() * controlRadius,
                center.y + sin((baseAngle - 30).toRadians()).toFloat() * controlRadius
            )

            val path = Path().apply {
                moveTo(start.x, start.y)
                quadraticTo(control.x, control.y, center.x, center.y)
            }

            drawPath(
                path = path,
                brush = Brush.horizontalGradient(
                    listOf(
                        accent2.copy(alpha = 0.15f * (pulseAlpha + flareIntensity)),
                        accent1.copy(alpha = 0.6f * (pulseAlpha + flareIntensity))
                    )
                ),
                style = Stroke(width = 1.8f)
            )
        }

        // Parallax aura
        val auraRadius = maxR * 1.4f * parallax
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    accent2.copy(alpha = 0.12f * pulseAlpha),
                    accent1.copy(alpha = 0.08f * pulseAlpha),
                    Color.Transparent
                ),
                center = center,
                radius = auraRadius
            )
        )

        // Outer glow
        val outerRadius = maxR * 0.12f * corePulse * (1f + flareIntensity * 0.4f)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    accent1.copy(alpha = 0.55f * (pulseAlpha + flareIntensity)),
                    accent2.copy(alpha = 0.25f * pulseAlpha),
                    Color.Transparent
                ),
                center = center,
                radius = outerRadius * 4f
            )
        )

        // Floating khat leaves
        val particleCount = 12
        val driftR = maxR * 0.8f
        for (i in 0 until particleCount) {
            val angle = (i * (360f / particleCount)) + particleDrift
            val orbitRadius = driftR * (0.6f + (i % 3) * 0.1f)
            val x = center.x + cos(angle.toRadians()).toFloat() * orbitRadius
            val y = center.y + sin((angle + i * 10).toRadians()).toFloat() * orbitRadius
            val leafSize = maxR * 0.03f * (0.7f + (i % 3) * 0.1f)

            drawKhatLeaf(
                center = Offset(x, y),
                size = leafSize,
                color1 = accent1,
                color2 = accent2
            )
        }

        // Interactive ripple
        if (touchPoint != Offset.Unspecified && rippleRadius > 0f) {
            val dist = hypot(touchPoint.x - center.x, touchPoint.y - center.y)
            val t = (dist / (maxR * 1.5f)).coerceIn(0f, 1f)
            val rippleColor = Color.hsv(
                hue = 240f - (t * 140f),
                saturation = 0.8f,
                value = 1f
            )

            drawCircle(
                brush = Brush.radialGradient(
                    listOf(
                        rippleColor.copy(alpha = 0.25f * flareIntensity),
                        Color.Transparent
                    ),
                    center = touchPoint,
                    radius = rippleRadius
                ),
                radius = rippleRadius,
                center = touchPoint
            )
        }

        // Neural core
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.95f * (pulseAlpha + flareIntensity)),
                    adaptiveGlow,
                    Color.Transparent
                ),
                center = center,
                radius = outerRadius * 2f
            )
        )
    }
}

// Draw a khat leaf shape
fun DrawScope.drawKhatLeaf(center: Offset, size: Float, color1: Color, color2: Color) {
    withTransform({
        translate(center.x, center.y)
    }) {
        val path = Path().apply {
            moveTo(0f, -size)
            cubicTo(size, -size / 2, size, size / 2, 0f, size)
            cubicTo(-size, size / 2, -size, -size / 2, 0f, -size)
            close()
        }
        drawPath(
            path = path,
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.95f),
                    color1.copy(alpha = 0.7f),
                    color2.copy(alpha = 0.5f),
                    Color.Transparent
                ),
                center = Offset(0f, 0f),
                radius = size * 1.2f
            )
        )
    }
}
