package ch.makery.hangman.view

import ch.makery.hangman.MainApp
import scalafxml.core.macros.sfxml
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.Alert.AlertType
import scala.util.{Failure, Success}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.media.{Media, MediaPlayer}

@sfxml
class HomeScreenController() {
    
    def startGame(action : ActionEvent): Unit = {
        MainApp.showGame()
    }

    def endGame(action: ActionEvent): Unit = {
        System.exit(0)
    }

    def showRule(action: ActionEvent): Unit = {
        MainApp.showRule()
    }
}