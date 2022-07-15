package ch.makery.hangman.view

// Import libraries 
import ch.makery.hangman.MainApp
import scalafxml.core.macros.sfxml
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.Alert.AlertType
import scala.util.{Failure, Success}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.media.{Media, MediaPlayer}

@sfxml
// Controller for HomeScreen.fxml
class HomeScreenController() {

    // Start the game when player click play button 
    def startGame(action : ActionEvent): Unit = {
        MainApp.showGame()
    }

    // Terminate the program when play click the quit button 
    def endGame(action: ActionEvent): Unit = {
        System.exit(0)
    }

    // Execute a new scene to display the game's instruction when player click the how to play button 
    def showRule(action: ActionEvent): Unit = {
        MainApp.showRule()
    }
}