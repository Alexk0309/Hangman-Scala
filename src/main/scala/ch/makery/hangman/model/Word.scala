package ch.makery.hangman.model 

// Import random library 
import scala.util.Random

class Word(file: String){

    var filename = file
    var word:String = ""

    // Function to select a word from the list, return as string 
    def selectWord(wordList: List[String]): String = {
        word = wordList(scala.util.Random.nextInt(wordList.length))
        return word
    }

    // Place every word in the txt file to a list, return as list of strings
    def wordList(): List[String] = {
        val source = io.Source.fromFile(filename)
        val words : List[String] = source.getLines.toList
        source.close()
        return words
    }

    // Split the word into a list of characters, return as list of characters
    def wordSplit(word: String): List[Char] = {
        return word.toList
    }

    // Generate the blanks based on the number of letters in a word, return as list of characters
    def generatePlaceholder(wordSize: Int): List[Char] = {
        return wordSplit("_" * wordSize)
    }

    // Function to check if the letter is guessed correctly, return as boolean 
    def checkWord(input: Char): Boolean = {
        if (word.contains(input)) {
            return true
        }
        else {
            return false
        }
    }
}