package com.example.bowlingkatagame

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GameTest {
    @Test
    fun `Test gutter game`(){
        val game = Game()

        for(index in 0 until 20){
            game.rollBall(0)
        }
    }

    @Test
    fun `getScore return the score`() {
        val game = Game()

        for(index in 0 until 20){
            game.rollBall(1)
        }

        Assert.assertEquals(20, game.getScore())
    }
}
