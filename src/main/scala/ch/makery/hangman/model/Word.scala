package ch.makery.hangman.model 

import scala.util.Random

class Word(file: String){

    var filename = file
    var word:String = ""

    def selectWord(wordList: List[String]): String = {
        word = wordList(scala.util.Random.nextInt(wordList.length))
        return word
    }

    def wordList(): List[String] = {
        val source = io.Source.fromFile(filename)
        val words : List[String] = source.getLines.toList
        source.close()
        return words
    }

    def wordSplit(word: String): List[Char] = {
        return word.toList
    }

    def generatePlaceholder(wordSize: Int): List[Char] = {
        return wordSplit("_" * wordSize)
    }

    def checkWord(input: Char): Boolean = {
        if (word.contains(input)) {
            return true
        }
        else {
            return false
        }
    }
}