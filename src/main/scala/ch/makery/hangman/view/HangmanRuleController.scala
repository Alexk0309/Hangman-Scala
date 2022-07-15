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
class HangmanRuleController(
    backbutton: Button
) {
    def goHome(action : ActionEvent): Unit = {
        MainApp.showHomeScreen()
    }
}