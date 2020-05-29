package com.example.bowlingkatagame

class Game {

    private var score = 0

    fun rollBall(pins: Int) {
        score += pins
    }

    fun getScore() :Int {
        return score
    }

}