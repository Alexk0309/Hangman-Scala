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

    // generate random word 
    var hangmanWord = new Word("src/main/randomWords.txt")
    var wordList: List[String] = null
    var word: String = null
    var charList: List[Char] = null
    var wordSize: Int = 0
    var placeholder: List[Char] = null
    var text: String = null
    var counter: Int = 0
    var remain: Int = 0

    def generateWord(): Unit = {
        wordList = hangmanWord.wordList()
        word = hangmanWord.selectWord(wordList)
        charList = hangmanWord.wordSplit(word)
        wordSize = word.length()
        placeholder = hangmanWord.generatePlaceholder(wordSize)
    }

   def checkAns(input: Char): Boolean = {
    if (hangmanWord.checkWord(input)) {
        for (i <- 0 to wordSize-1) {
            if (charList(i) == input) {
                remain -= 1
                placeholder = placeholder.updated(i, input)
            }
        }
        text = placeholder.mkString(" ")
        hangmanText.setText(text)
        if (remain == 0) { 
            MainApp.showWonGame()
        }
        return true
    }
    else {
        if (counter == 0) {
            hangmanImage.setVisible(true)
        }
        else {
            hangmanImage.image = new Image(imageList(counter))
            hangmanImage.setVisible(true)
        }
        counter += 1
        if (counter == 5) {
            MainApp.showGameOver(word)
        }
        return false
    }
   }

   generateWord()

   text = placeholder.mkString(" ")
   hangmanText.setText(text)

   counter = 0
   remain = wordSize
   private val imageList = List("file:resources/images/wrong1.png", "file:resources/images/wrong2.png", "file:resources/images/wrong3.png", "file:resources/images/wrong4.png", "file:resources/images/wrong5.png")

   hangmanImage.image = new Image(imageList(counter))
   hangmanImage.setVisible(false)

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

   def goHome(action: ActionEvent): Unit = {
    MainApp.showHomeScreen()
   }

   def exitGame(action: ActionEvent): Unit = {
    System.exit(0)
   }
}