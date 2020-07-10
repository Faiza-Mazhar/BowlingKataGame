package com.example.bowlingkatagame

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class MultiPlayerGameTest {

    private lateinit var multiPlayerGame: MultiPlayerGame
    private var playerList: List<Game> =  listOf(Game(), Game())
    @Before
    fun setUp() {
        multiPlayerGame = MultiPlayerGame(playerList)
    }

    @Test
    fun `if currentPlayer rolls two balls, we switch the player` () {
        multiPlayerGame.frameScore(4, 5)

        val expectedPlayer = 1
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

    @Test
    fun `if currentPlayer rolls a strike, we switch the player` () {
        multiPlayerGame.frameScore(10)

        val expectedPlayer = 1
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

    @Test
    fun `players are switched properly after one another`() {
        multiPlayerGame.frameScore(4, 5)
        multiPlayerGame.frameScore(4, 5)
        val expectedPlayer = 0
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

    @Test
    fun `for a list of 5 player, after three player, current player is fourth player` () {
        playerList =  listOf(Game(), Game(), Game(),  Game(),  Game() )
        multiPlayerGame = MultiPlayerGame(playerList)
        multiPlayerGame.frameScore(4, 5)
        multiPlayerGame.frameScore(4, 5)
        multiPlayerGame.frameScore(10)
        val expectedPlayer = 3
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

    @Test
    fun `for a list of 5 player, after five player, current player is first player` () {
        playerList = listOf(Game(), Game(), Game(), Game(), Game())
        multiPlayerGame = MultiPlayerGame(playerList)
        multiPlayerGame.frameScore(4, 5)
        multiPlayerGame.frameScore(4, 5)
        multiPlayerGame.frameScore(10)
        multiPlayerGame.frameScore(4, 5)
        multiPlayerGame.frameScore(10)
        val expectedPlayer = 0
        Assert.assertEquals(expectedPlayer, multiPlayerGame.currentPlayer)
    }

}