import com.ahaid.landingpad.controller.rest.LpController
import com.ahaid.landingpad.controller.swagger.{ResourcesApp, LpSwagger}
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    implicit val swagger = new LpSwagger

    // LandingPad
    context mount (new LpController(), "/*")

    // Swagger Generator
    context mount (new ResourcesApp, "/api-docs/*")


  }
}
