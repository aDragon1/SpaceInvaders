package self.adragon

import processing.core.PApplet
import processing.event.KeyEvent
import self.adragon.enums.Directions
import self.adragon.gameObjects.Ship

fun main() {
    SpaceInvaders.run()
}

class SpaceInvaders : PApplet() {
    companion object {
        fun run() {
            val sketch = SpaceInvaders()
            sketch.setSize(600, 600)
            sketch.runSketch()
        }
    }

    private val frameShootThreshold = 25

    lateinit var ship: Ship
    var lastBulletFrame = -1
    override fun setup() {
        ship = Ship(width / 2f, height - 30f, 30f)
    }

    override fun draw() {
        background(0)
        strokeWeight(10f)
        stroke(255f, 255f, 255f)

        ship.update()
        ship.show(this)
        ship.showBullets(this)
    }


    override fun handleKeyEvent(event: KeyEvent?) {
        if (event == null || event.action != KeyEvent.PRESS) return

        when (event.keyCode) {
            65 -> ship.move(Directions.LEFT) // code for 'a'
            68 -> ship.move(Directions.RIGHT) // code for 'd'
            32 -> if (frameCount - lastBulletFrame > frameShootThreshold) { // code for 'space bar'
                lastBulletFrame = frameCount
                ship.fire()
            }
        }
    }
}