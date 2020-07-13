package com.example.bowlingkatagame

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class MultiPlayerGameTest {

    private lateinit var multiPlayerGame: MultiPlayerGame
    private var playerList = listOf(Game(), Game(), Game(), Game(), Game())
    @Before
    fun setUp() {
        multiPlayerGame = MultiPlayerGame(playerList)
    }

    @Test
    fun `if currentPlayer rolls two balls, we switch the player` () {
        multiPlayerGame.setFrameScore(4, 5)

        val expectedPlayer = 1
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

    @Test
    fun `if currentPlayer rolls a strike, we switch the player` () {
        multiPlayerGame.setFrameScore(10)

        val expectedPlayer = 1
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

    @Test
    fun `players are switched properly after one another`() {
        multiPlayerGame.setFrameScore(4, 5)
        multiPlayerGame.setFrameScore(4, 5)
        val expectedPlayer = 2
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

    @Test
    fun `for a list of 5 player, after three player, current player is fourth player` () {
        playerList =  listOf(Game(), Game(), Game(),  Game(),  Game() )
        multiPlayerGame = MultiPlayerGame(playerList)
        multiPlayerGame.setFrameScore(4, 5)
        multiPlayerGame.setFrameScore(4, 5)
        multiPlayerGame.setFrameScore(10)
        val expectedPlayer = 3
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

    @Test
    fun `for a list of 5 player, after five player, current player is first player` () {
        playerList = listOf(Game(), Game(), Game(), Game(), Game())
        multiPlayerGame = MultiPlayerGame(playerList)
        multiPlayerGame.setFrameScore(4, 5)
        multiPlayerGame.setFrameScore(4, 5)
        multiPlayerGame.setFrameScore(10)
        multiPlayerGame.setFrameScore(4, 5)
        multiPlayerGame.setFrameScore(10)
        val expectedPlayer = 0
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

    @Test
    fun `after 10 frame, game is finished and no more balls can be rolled` () {
        rollFullGame()
        setFrameScoresForCurrentPlayer(3, 3)

        val expectedPlayer = playerList.size - 1
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

    @Test
    fun `getWinner returns the index of player with max score`() {
        setFrameScoresForCurrentPlayer(4, 5)
        setFrameScoresForCurrentPlayer(1, 6)

        val expectedWinner = 0
        Assert.assertEquals(expectedWinner, multiPlayerGame.getWinner())
    }

    private fun rollFullGame () {
        for(index in playerList.indices){
            for(frameIndex in 0 .. 9 ){
                setFrameScoresForCurrentPlayer(1, 1)
            }
        }
    }
    private fun setFrameScoresForCurrentPlayer(firstRoll: Int, secondRoll: Int) {
        multiPlayerGame.setFrameScore(firstRoll, secondRoll)
    }
}