package self.adragon.gameObjects

import self.adragon.SpaceInvaders
import self.adragon.enums.Directions

class Ship(x: Float, y: Float, size: Float) : Movable(x, y, size) {

    val bullets = mutableListOf<Bullet>()

    override fun update() {
        super.update()
        bullets.forEach { it.move(Directions.UP) }
    }

    fun fire() {
        bullets.add(Bullet(x, y, size / 5))
    }

    fun showBullets(root: SpaceInvaders) = bullets.forEach { it.show(root) }

}