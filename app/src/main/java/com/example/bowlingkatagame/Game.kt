package com.example.bowlingkatagame

class Game {

    private val rollScore: IntArray = IntArray(21)
    private var currentRoll = 0

    private val bestScore = 10
    private val maxFrameSize = 10

    fun rollBall(pins: Int) : Int {
        rollScore[ currentRoll++ ] = pins
        return currentRoll
    }

    fun getScore() :Int {
        var score = 0
        var frameIndex = 0
        for(index in 0 until maxFrameSize){

            when {
                isSpare(frameIndex) -> {
                    score += spareBonus(frameIndex) + bestScore
                    frameIndex += 2
                }
                isStrike(frameIndex) -> {
                    score += getStrikeBonus(frameIndex) + bestScore
                    frameIndex += 1
                }
                else -> {
                    score += getFrameScore(frameIndex)
                    frameIndex += 2
                }
            }
        }
        return score
    }

    private fun isSpare(frameIndex : Int) :Boolean {
        return rollScore[frameIndex] + rollScore[frameIndex + 1] == bestScore
    }

    private fun spareBonus(frameIndex: Int): Int {
        return rollScore[frameIndex + 2]
    }

    private fun getFrameScore(frameIndex: Int) :Int {
        return rollScore[frameIndex] + rollScore[frameIndex+1]
    }

    private fun isStrike(frameIndex: Int) :Boolean {
        return rollScore[frameIndex] == bestScore
    }

    private fun getStrikeBonus(frameIndex: Int) : Int {
        return getFrameScore(frameIndex + 1)
    }

}