package ch.makery.hangman.view

import ch.makery.hangman.MainApp
import ch.makery.hangman.model.Word
import scalafxml.core.macros.sfxml
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.Alert.AlertType
import scala.util.{Failure, Success}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.control.{Button}
import scalafx.scene.text.Text

@sfxml
// Controller for HangmanGame.fxml
class HangmanGameController(
    hangmanImage: ImageView,
    qKey: Button,
    wKey: Button,
    eKey: Button,
    rKey: Button,
    tKey: Button,
    yKey: Button,
    uKey: Button,
    iKey: Button,
    oKey: Button,
    pKey: Button,
    aKey: Button,
    sKey: Button,
    dKey: Button,
    fKey: Button,
    gKey: Button,
    hKey: Button,
    jKey: Button,
    kKey: Button,
    lKey: Button,
    zKey: Button,
    xKey: Button,
    cKey: Button,
    vKey: Button,
    bKey: Button,
    nKey: Button,
    mKey: Button,
    hangmanText: Text
    ) {

    // Assign variables and instance that will be used for the game  
    var hangmanWord = new Word("src/main/randomWords.txt")
    var wordList: List[String] = null
    var word: String = null
    var charList: List[Char] = null
    var wordSize: Int = 0
    var placeholder: List[Char] = null
    var text: String = null
    var counter: Int = 0
    var remain: Int = 0

    // A function to generate random words from the text file 
    def generateWord(): Unit = {
        wordList = hangmanWord.wordList()
        word = hangmanWord.selectWord(wordList)
        charList = hangmanWord.wordSplit(word)
        wordSize = word.length()
        placeholder = hangmanWord.generatePlaceholder(wordSize)
    }

    // A function to check the input for correct answer of the letter
   def checkAns(input: Char): Boolean = {
    // If returns true, loop through the word to see if letter exists in the word 
    // Will update the blank spaces with the correct letter 
    if (hangmanWord.checkWord(input)) {
        for (i <- 0 to wordSize-1) {
            if (charList(i) == input) {
                remain -= 1
                placeholder = placeholder.updated(i, input)
            }
        }
        text = placeholder.mkString(" ")
        hangmanText.setText(text)
        // If the word is guessed correctly, will display a dialog to congrulate the player 
        if (remain == 0) { 
            MainApp.showWonGame()
        }
        return true
    }
    // If the letter is guessed incorrectly, a body piece of hangman will appear on the screen
    else {
        if (counter == 0) {
            hangmanImage.setVisible(true)
        }
        else {
            hangmanImage.image = new Image(imageList(counter))
            hangmanImage.setVisible(true)
        }
        // Update the counter
        counter += 1
        // If hangman is fully shown, game will terminate and display a game over dialog 
        if (counter == 5) {
            MainApp.showGameOver(word)
        }
        return false
    }
   }

   // Calling function to generate random word 
   generateWord()

   // Setting blanks according to the number of letters in the word 
   text = placeholder.mkString(" ")
   hangmanText.setText(text)

   // Counter to count the number of incorrect guesses 
   counter = 0
   // remain; a variable to count the number of letters left to guess correctly 
   remain = wordSize
   // A list that stores the file paths of the images of hangman 
   private val imageList = List("file:resources/images/wrong1.png", "file:resources/images/wrong2.png", "file:resources/images/wrong3.png", "file:resources/images/wrong4.png", "file:resources/images/wrong5.png")
   // Set image to imageView according to the counter 
   hangmanImage.image = new Image(imageList(counter))
   // Set image to not be visible when the game starts 
   hangmanImage.setVisible(false)

   // Functions for every keys in the game 
   // If letter is guessed correctly, will replace the blank with the correct letter o nthe screen
   // Button will not be visible after button is pressed and guessed correctly 
   // Otherwise, will display a body piece of hangman 
   qKey.onAction = (e: ActionEvent) => {
    if (checkAns('Q')) {
        qKey.setVisible(false)
    }
   }

   wKey.onAction = (e: ActionEvent) => {
    if (checkAns('W')) {
        wKey.setVisible(false)
    }
   }

   eKey.onAction = (e: ActionEvent) => {
    if (checkAns('E')) {
        eKey.setVisible(false)
    }
   }

   rKey.onAction = (e: ActionEvent) => {
    if (checkAns('R')) {
        rKey.setVisible(false)
    }
   }

   tKey.onAction = (e: ActionEvent) => {
    if (checkAns('T')) {
        tKey.setVisible(false)
    }
   }

   yKey.onAction = (e: ActionEvent) => {
    if (checkAns('Y')) {
        yKey.setVisible(false)
    }
   }

   uKey.onAction = (e: ActionEvent) => {
    if (checkAns('U')) {
        uKey.setVisible(false)
    }
   }

   iKey.onAction = (e: ActionEvent) => {
    if (checkAns('I')) {
        iKey.setVisible(false)
    }
   }

   oKey.onAction = (e: ActionEvent) => {
    if (checkAns('O')) {
        oKey.setVisible(false)
    }
   }

   pKey.onAction = (e: ActionEvent) => {
    if (checkAns('P')) {
        pKey.setVisible(false)
    }
   }

   aKey.onAction = (e: ActionEvent) => {
    if (checkAns('A')) {
        aKey.setVisible(false)
    }
   }

   sKey.onAction = (e: ActionEvent) => {
    if (checkAns('S')) {
        sKey.setVisible(false)
    }
   }

   dKey.onAction = (e: ActionEvent) => {
    if (checkAns('D')) {
        dKey.setVisible(false)
    }
   }

   fKey.onAction = (e: ActionEvent) => {
    if (checkAns('F')) {
        fKey.setVisible(false)
    }
   }

   gKey.onAction = (e: ActionEvent) => {
    if (checkAns('G')) {
        gKey.setVisible(false)
    }
   }

   hKey.onAction = (e: ActionEvent) => {
    if (checkAns('H')) {
        hKey.setVisible(false)
    }
   }

   jKey.onAction = (e: ActionEvent) => {
    if (checkAns('J')) {
        jKey.setVisible(false)
    }
   }

   kKey.onAction = (e: ActionEvent) => {
    if (checkAns('K')) {
        kKey.setVisible(false)
    }
   }

   lKey.onAction = (e: ActionEvent) => {
    if (checkAns('L')) {
        lKey.setVisible(false)
    }
   }

   zKey.onAction = (e: ActionEvent) => {
    if (checkAns('Z')) {
        zKey.setVisible(false)
    }
   }

   xKey.onAction = (e: ActionEvent) => {
    if (checkAns('X')) {
        xKey.setVisible(false)
    }
   }

   cKey.onAction = (e: ActionEvent) => {
    if (checkAns('C')) {
        cKey.setVisible(false)
    }
   }

   vKey.onAction = (e: ActionEvent) => {
    if (checkAns('V')) {
        vKey.setVisible(false)
    }
   }

   bKey.onAction = (e: ActionEvent) => {
    if (checkAns('B')) {
        bKey.setVisible(false)
    }
   }

   nKey.onAction = (e: ActionEvent) => {
    if (checkAns('N')) {
        nKey.setVisible(false)
    }
   }

   mKey.onAction = (e: ActionEvent) => {
    if (checkAns('M')) {
        mKey.setVisible(false)
    }
   }

   // Button in menubar 
   // Button to go back to the main menu
   def goHome(action: ActionEvent): Unit = {
    MainApp.showHomeScreen()
   }
   // Button to terminate the program and exit the game 
   def exitGame(action: ActionEvent): Unit = {
    System.exit(0)
   }
}