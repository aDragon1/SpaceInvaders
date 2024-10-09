package self.adragon.gameObjects

import self.adragon.enums.Directions
import self.adragon.SpaceInvaders

abstract class Movable(vx: Float, vy: Float, r: Float) {

    open val dx: Float = 4f
    open val dy: Float = 4f

    var x = vx
    var y = vy
    var size = r
    open fun update() {}

    fun show(root: SpaceInvaders) = root.ellipse(x, y, size, size)


    fun move(dir: Directions) =
        when (dir) {
            Directions.UP -> y -= dy
            Directions.DOWN -> y += dy
            Directions.LEFT -> x -= dx
            Directions.RIGHT -> x += dx
        }

}