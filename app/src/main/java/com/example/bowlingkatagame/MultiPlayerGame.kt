package com.example.bowlingkatagame



class MultiPlayerGame(private val playerList: List<Game>) {

    var currentPlayer = 0;
    private val MAX_FRAME = 10
    private var currentFrame = 0

    private fun switchPlayer() {
        currentPlayer = (currentPlayer + 1) % playerList.size
    }

    fun setFrameScore(firstRoll: Int, secondRoll: Int = 0) {
        if(currentFrame < MAX_FRAME) {
            rollBalls(firstRoll, secondRoll)
            switchPlayer()
            updateFrames()
        }
    }

    private fun updateFrames() {
        if (currentPlayer == playerList.size - 1) {
            currentFrame++
        }
    }

    private fun rollBalls(firstRoll: Int, secondRoll: Int) {
        playerList[currentPlayer].rollBall(firstRoll)
        if (firstRoll != 10) {
            playerList[currentPlayer].rollBall(secondRoll)
        }
    }

    fun getWinner(): Int {
        var winningPlayer = 0
        var maxScore = -1
        for(index in playerList.indices){
            val currentPlayerScore = playerList[index].getScore()
            if(currentPlayerScore > maxScore){
                winningPlayer = index
                maxScore = currentPlayerScore
            }
        }
        return winningPlayer
    }
}