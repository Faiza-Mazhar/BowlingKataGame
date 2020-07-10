package com.example.bowlingkatagame



class MultiPlayerGame(private val playerList: List<Game>) {

    var currentPlayer = 0;

    private fun switchPlayer() {
        currentPlayer = (currentPlayer + 1) % playerList.size
    }

    fun frameScore(firstRoll: Int, secondRoll: Int = 0) {
        playerList[currentPlayer].rollBall(firstRoll)
        if( firstRoll != 10) {
            playerList[currentPlayer].rollBall(secondRoll)
        }
        switchPlayer()
    }
}