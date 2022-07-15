package ch.makery.hangman.view

// Import libraries 
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
// Controller for HangmanWin.fxml
class HangmanWinController(
    wingameBG: ImageView,
    nextButton: Button,
    scoreText: Text
) {

    // Text object; used to change text value 
    var scoreDisplay = scoreText
    var dialogStage: Stage = null

    // Set background image 
    wingameBG.image = new Image("file:resources/images/Win.jpg")

    // Game will go to the next level when user click next button
    def goNext(action : ActionEvent): Unit = { 
        MainApp.showGame()
        dialogStage.close()
    }
}