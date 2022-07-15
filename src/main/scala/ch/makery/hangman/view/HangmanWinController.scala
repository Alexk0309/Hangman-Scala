package ch.makery.hangman.view

import ch.makery.hangman.MainApp
import scalafxml.core.macros.sfxml
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.Alert.AlertType
import scala.util.{Failure, Success}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.control.{Button}
import scalafx.scene.text.Text
import scalafx.stage.Stage

@sfxml
class HangmanWinController(
    wingameBG: ImageView,
    nextButton: Button,
    scoreText: Text
) {

    var scoreDisplay = scoreText
    var dialogStage: Stage = null

    wingameBG.image = new Image("file:resources/images/Win.jpg")

    def goNext(action : ActionEvent): Unit = { 
        MainApp.showGame()
        dialogStage.close()
    }
}