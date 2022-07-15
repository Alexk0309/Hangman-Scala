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
// Controller for  HangmanRule.fxml
class HangmanRuleController() {

    // A function to go back to the main menu when player click back button 
    def goHome(action : ActionEvent): Unit = {
        MainApp.showHomeScreen()
    }
}