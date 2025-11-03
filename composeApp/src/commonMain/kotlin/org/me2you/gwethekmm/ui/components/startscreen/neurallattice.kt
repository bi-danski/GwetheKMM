//package org.me2you.gwethekmm.ui.components.startscreen
//
//import androidx.compose.animation.core.*
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.background
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.*
//import androidx.compose.ui.graphics.drawscope.DrawScope
//import androidx.compose.ui.graphics.drawscope.Fill
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.graphics.drawscope.withTransform
//import kotlin.math.*
//import kotlin.random.Random
//import org.me2you.gwethekmm.ui.theme.AccentB
//import org.me2you.gwethekmm.ui.theme.AccentG
//import org.me2you.gwethekmm.ui.theme.AccentK
//import org.me2you.gwethekmm.ui.theme.Purple900
//
//private fun Offset.distanceTo(other: Offset): Float =
//    sqrt((x - other.x).pow(2) + (y - other.y).pow(2))
//
//@Composable
//fun NeuralLattice(modifier: Modifier,
//                  maxNodes: Int = 100
//) {
//    val transition = rememberInfiniteTransition()
//    val pulse by transition.animateFloat(
//        0.85f, 1.15f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(5000, easing = FastOutSlowInEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
//    val corePulse by transition.animateFloat(
//        0.9f, 1.2f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(2500, easing = FastOutSlowInEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
//    val shimmer by transition.animateFloat(
//        0f, 1f,
//        animationSpec = infiniteRepeatable(animation = tween(8000, easing = LinearEasing))
//    )
//
//    val accent1 = AccentG.copy(alpha = 0.9f)
//    val accent2 = AccentB.copy(alpha = 0.9f)
//    val sparkColor = AccentK
//    val bg = Purple900
//
//    val leafCenter = remember { mutableStateOf(Offset.Zero) }
//    val activeNodes = remember { mutableStateListOf<Offset>() }
//
//    Canvas(modifier = modifier) {
//        val w = size.width
//        val h = size.height
//        val center = Offset(w / 2f, h / 2f)
//
//        if (leafCenter.value == Offset.Zero) {
//            leafCenter.value = Offset(center.x + w * 0.14f, center.y) // brain leaf position inside skull
//        }
//
//        val leafPos = leafCenter.value
//
//        // Add new nodes dynamically
//        if (activeNodes.size < maxNodes && Random.nextFloat() < 0.1f) {
//            val angle = Random.nextFloat() * 2f * PI.toFloat()
//            val dist = Random.nextFloat() * 0.35f * min(w, h)
//            val newNode = Offset(
//                leafPos.x + cos(angle) * dist,
//                leafPos.y + sin(angle) * dist
//            )
//            activeNodes.add(newNode)
//        }
//        if (activeNodes.size > maxNodes) activeNodes.removeAt(0)
//
//        drawRect(
//            brush = Brush.verticalGradient(
//                colors = listOf(bg.copy(alpha = 0.32f), bg.copy(alpha = 0.22f), bg.copy(alpha = 0.12f))
//            ),
//            size = size
//        )
//
//        // draw connections from nodes to the leaf
//        activeNodes.forEachIndexed { idx, node ->
//            val t = (Random.nextFloat() * 0.5f + 0.5f) // node impulse factor
//            val shimmerShift = abs(sin((idx + shimmer) * PI)).toFloat()
//            drawLine(
//                brush = Brush.linearGradient(
//                    colors = listOf(
//                        sparkColor.copy(alpha = 0.6f + 0.4f * shimmerShift),
//                        accent1.copy(alpha = 0.8f)
//                    ),
//                    start = node,
//                    end = leafPos
//                ),
//                start = node,
//                end = leafPos,
//                strokeWidth = 1f + 0.5f * pulse
//            )
//            val impulsePos = Offset(
//                node.x + (leafPos.x - node.x) * t,
//                node.y + (leafPos.y - node.y) * t
//            )
//            drawCircle(
//                color = sparkColor.copy(alpha = 0.8f),
//                center = impulsePos,
//                radius = 3f * pulse
//            )
//        }
//
//        // draw the skull outline (right-facing)
//        val skullNodes = generateRightFacingSkullNodes()
//        val skullPath = Path().apply {
//            if (skullNodes.isNotEmpty()) {
//                moveTo(center.x + skullNodes.first().x, center.y + skullNodes.first().y)
//                skullNodes.forEach { lineTo(center.x + it.x, center.y + it.y) }
//                close()
//            }
//        }
//        drawPath(
//            path = skullPath,
//            brush = Brush.radialGradient(
//                colors = listOf(accent1.copy(alpha = 0.05f), Color.Transparent),
//                center = leafPos,
//                radius = min(w, h) * 0.7f
//            ),
//            style = Stroke(width = 2f)
//        )
//
//        // draw the living brain leaf
//        val leafSize = min(w, h) * 0.08f * corePulse
//        drawKhatLeaf(leafPos, leafSize, this, accent1, sparkColor)
//    }
//}
//
//private fun generateRightFacingSkullNodes(): List<Offset> {
//    val nodes = mutableListOf<Offset>()
//    val rX = 120f
//    val rY = 160f
//    val points = 20
//    for (i in 0 until points) {
//        val angle = i.toFloat() / points.toFloat() * PI.toFloat()
//        val x = cos(angle) * rX
//        val y = sin(angle) * rY
//        nodes.add(Offset(x, y - rY / 2)) // shift up slightly
//    }
//    return nodes
//}
//
//private fun drawKhatLeaf(center: Offset, size: Float, drawScope: DrawScope, color1: Color, color2: Color) {
//    with(drawScope) {
//        withTransform({ translate(center.x, center.y) }) {
//            val path = Path().apply {
//                moveTo(0f, -size)
//                cubicTo(size, -size / 2, size, size / 2, 0f, size)
//                cubicTo(-size, size / 2, -size, -size / 2, 0f, -size)
//                close()
//            }
//            drawPath(
//                path = path,
//                brush = Brush.radialGradient(
//                    colors = listOf(
//                        Color.White.copy(alpha = 0.95f),
//                        color1.copy(alpha = 0.7f),
//                        color2.copy(alpha = 0.5f),
//                        Color.Transparent
//                    ),
//                    center = Offset(0f, 0f),
//                    radius = size * 2f
//                ),
//                style = Fill
//            )
//        }
//    }
//}
