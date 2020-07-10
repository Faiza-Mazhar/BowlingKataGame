package com.example.bowlingkatagame

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GameTest {

    private lateinit var game: Game

    @Before
    fun setUp(){
        game = Game()
    }

    @Test
    fun `Test gutter game`(){
        rollMultiplesBall(20, 0)
        Assert.assertEquals(0, game.getScore())
    }

    @Test
    fun `getScore return the score`() {
        rollMultiplesBall(20, 1)
        Assert.assertEquals(20, game.getScore())
    }

    @Test
    fun `test that spare is counted`() {
        rollSpare()

        game.rollBall(4)

        rollMultiplesBall(17, 0)

        Assert.assertEquals(18, game.getScore())
    }

    @Test
    fun `test that strike is counted`() {

        rollStrike()
        game.rollBall(6)
        game.rollBall(2)

        rollMultiplesBall(17, 0)
        Assert.assertEquals(26, game.getScore())
    }

    @Test
    fun `test perfect game`() {
        rollMultiplesBall(20, 10)
        Assert.assertEquals(300, game.getScore())
    }

    @Test
    fun `test strike in last frame`() {
        rollMultiplesBall(18, 1)
        rollStrike()
        game.rollBall(6)
        Assert.assertEquals(34, game.getScore())
    }

    @Test
    fun `test spare in last frame`() {
        rollMultiplesBall(18, 1)
        rollSpare()
        game.rollBall(6)
        Assert.assertEquals(34, game.getScore())
    }

    private fun rollMultiplesBall(times: Int, pins: Int ) {
        for( index in 0 until times) {
            game.rollBall(pins)
        }
    }

    private fun rollSpare() {
        game.rollBall(7)
        game.rollBall(3)
    }

    private fun rollStrike() {
        game.rollBall(10)
    }
}
