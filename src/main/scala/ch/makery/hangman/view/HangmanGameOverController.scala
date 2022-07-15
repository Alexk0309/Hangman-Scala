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
// Controller for HangGameOver.fxml
class HangmanGameOverController(
    gameoverBG: ImageView,
    homeButton: Button,
    scoreText: Text,
    answerText: Text
) {

    // Set to display total score value in Text object 
    var scoreDisplay = scoreText
    var answerDisplay = answerText

    var dialogStage: Stage = null

    // Set background
    gameoverBG.image = new Image("file:resources/images/dead.jpg")

    // Function to return to the main menu when player click the home button 
    def goHome(action : ActionEvent): Unit = {
        MainApp.showHomeScreen()
        dialogStage.close()
    }
}