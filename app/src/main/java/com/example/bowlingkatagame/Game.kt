package com.example.bowlingkatagame

class Game {

    private val rollScore: IntArray = IntArray(21)
    private var currentRoll = 0

    private val _BEST_SCORE = 10
    private val _FRAME_SIZE = 10

    fun rollBall(pins: Int) {
        rollScore[ currentRoll++ ] = pins
    }

    fun getScore() :Int {
        var score = 0
        var frameIndex = 0
        for(index in 0 until _FRAME_SIZE){

            if(isSpare(frameIndex)){ //spare
                score += spareBonus(frameIndex) + _BEST_SCORE
                frameIndex += 2
            } else if(isStrike(frameIndex)) {
                score += getStrikeBonus(frameIndex) + _BEST_SCORE
                frameIndex += 1
            }else {
                score += getFrameScore(frameIndex)
                frameIndex += 2
            }
        }
        return score
    }

    private fun isSpare(frameIndex : Int) :Boolean {
        return rollScore[frameIndex] + rollScore[frameIndex + 1] == _BEST_SCORE
    }

    private fun spareBonus(frameIndex: Int): Int {
        return rollScore[frameIndex + 2]
    }

    private fun getFrameScore(frameIndex: Int) :Int {
        return rollScore[frameIndex] + rollScore[frameIndex+1]
    }

    private fun isStrike(frameIndex: Int) :Boolean {
        return rollScore[frameIndex] == _BEST_SCORE
    }

    private fun getStrikeBonus(frameIndex: Int) : Int {
        return getFrameScore(frameIndex + 1)
    }

}