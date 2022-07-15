package ch.makery.hangman

// Import libraries 
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import javafx.{scene => jfxs}
import scalafxml.core.{NoDependencyResolver, FXMLView, FXMLLoader}
import scalafx.scene.Scene
import scalafx.stage.{ Stage, Modality, StageStyle }
import ch.makery.hangman.view.HangmanWinController
import ch.makery.hangman.view.HangmanGameOverController
import ch.makery.hangman.view.HangmanGameController
import scalafx.scene.image._

// Main app object 
object MainApp extends JFXApp{

    // score: an Int variable to store game score
    var score = 0

    // Load the resources from the main fxml file 
    val rootResource = getClass.getResource("view/RootLayout.fxml")
    val loader = new FXMLLoader(rootResource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.BorderPane]

    // Create primary stage as the main window of the program
    stage = new PrimaryStage{
        title = "Hangman"
        icons += new Image("file:resources/images/hangman.png")
        scene = new Scene{
            root = roots
        }
    }

    // Disable stage resize 
    MainApp.stage.setResizable(false)

    def showHomeScreen(): Unit = {
        val resource = getClass.getResource("view/HomeScreen.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    def showRule(): Unit = {
        val resource = getClass.getResource("view/HangmanRule.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    def showGame(): Unit = {
        val resource = getClass.getResource("view/HangmanGame.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    def showWonGame(): Unit = {
        val resource = getClass.getResource("view/HangmanWin.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val control = loader.getController[HangmanWinController#Controller]
        val roots2 = loader.getRoot[jfxs.layout.AnchorPane]
        var dialog = new Stage() {
            title = "Hangman"
            icons += new Image("file:resources/images/hangman.png")
            initModality(Modality.APPLICATION_MODAL)
            initOwner(stage)
            scene = new Scene {
                root = roots2
            }
        }
        score += 1 
        control.scoreDisplay.setText(score.toString)
        control.dialogStage = dialog
        dialog.setResizable(false)
        dialog.initStyle(StageStyle.UNDECORATED)
        dialog.showAndWait()
    }

    def showGameOver(answer: String): Unit = {
        
        val resource = getClass.getResource("view/HangmanGameOver.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val control = loader.getController[HangmanGameOverController#Controller]
        val roots3 = loader.getRoot[jfxs.layout.AnchorPane]

        var dialog2 = new Stage() {
            title = "Hangman"
            icons += new Image("file:resources/images/hangman.png")
            initModality(Modality.APPLICATION_MODAL)
            initOwner(stage)
            scene = new Scene {
                root = roots3
            }
        }
        control.scoreDisplay.setText(score.toString)
        control.answerDisplay.setText(answer)
        control.dialogStage = dialog2
        dialog2.initStyle(StageStyle.UNDECORATED)
        dialog2.setResizable(false)
        dialog2.showAndWait()
    }
    showHomeScreen()
}